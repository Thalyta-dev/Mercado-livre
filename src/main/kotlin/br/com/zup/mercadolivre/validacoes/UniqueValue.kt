package br.com.zup.mercadolivre.validacoes

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.TYPE, AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = arrayOf(UniqueValueValidator::class))
annotation class UniqueValue(
    val message: String = "Este atributo está com valores repetidos",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val fieldName: String,
    val domainClass: KClass<*>

){
}