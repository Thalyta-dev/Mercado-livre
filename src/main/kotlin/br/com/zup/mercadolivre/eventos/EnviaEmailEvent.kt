package br.com.zup.mercadolivre.eventos

import br.com.zup.mercadolivre.email.EnviaEmail
import org.springframework.context.ApplicationEvent
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class EnviaEmailEvent(
    var enviaEmail: EnviaEmail? = null,

    var source: JvmType.Object

): ApplicationEvent(source) {


}