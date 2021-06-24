package br.com.zup.mercadolivre.validacoes

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.TYPE, AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.VALUE_PARAMETER
)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = arrayOf(ExistValorValidator::class))

annotation class ExistValor(

    val message: String = "Este valor não existe na base de dados",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val fieldName: String,
    val domainClass: KClass<*>

){
}