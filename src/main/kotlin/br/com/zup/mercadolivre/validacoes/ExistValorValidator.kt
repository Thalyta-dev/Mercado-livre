package br.com.zup.mercadolivre.validacoes

import javax.persistence.EntityManager
import javax.persistence.Query
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

class ExistValorValidator(

    val manager: EntityManager

) : ConstraintValidator<ExistValor, Any> {

    var domainAttibute: String = ""
    var aClass: KClass<*>? = null

    override fun initialize(constraintAnnotation: ExistValor) {
        this.aClass = constraintAnnotation.domainClass;
        this.domainAttibute = constraintAnnotation.fieldName;
    }



    override fun isValid(o: Any?, p1: ConstraintValidatorContext?): Boolean {
        if(o == null){
            return true
        }

        val query: Query = manager.createQuery(
            "select 1 from " + (aClass?.java?.name) + " WHERE " + domainAttibute + " = :value"
        ).run { this.setParameter("value", o)}


        val lista = query.resultList

        return lista.isNotEmpty()    }


}