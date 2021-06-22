package br.com.zup.mercadolivre.validacoes

import javax.persistence.EntityManager
import javax.persistence.Query
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

class UniqueValueValidator(

    val manager: EntityManager

) : ConstraintValidator<UniqueValue, Any> {

    var domainAttibute: String = ""
    var aClass: KClass<*>? = null

    override fun initialize(constraintAnnotation: UniqueValue) {
        this.aClass = constraintAnnotation.domainClass;
        this.domainAttibute = constraintAnnotation.fieldName;
    }


    override fun isValid(o: Any?, p1: ConstraintValidatorContext?): Boolean {

        val query: Query = manager.createQuery(
            "select 1 from " + (aClass?.java?.name) + " WHERE " + domainAttibute + " = :value"
        ).run { this.setParameter("value", o)}


        val lista = query.resultList

        return lista.isEmpty()

    }

}