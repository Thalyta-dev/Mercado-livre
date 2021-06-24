package br.com.zup.mercadolivre.validacoes

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.TYPE, AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [VerificaImagemValidator::class])
@Repeatable
annotation class VerificaImagem(

    val message: String = "Este arquivo não é uma imagem",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []


){
}