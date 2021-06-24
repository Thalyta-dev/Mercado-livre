package br.com.zup.mercadolivre.eventos

import br.com.zup.mercadolivre.email.EnviaEmail
import br.com.zup.mercadolivre.pergunta.Pergunta
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class EnviarEmailEventPublisher(

    val applicationEventPublisher: ApplicationEventPublisher

) {

    @Autowired
    val enviaEmail = EnviaEmail()

    fun enviaEmail(pergunta: Pergunta){

        var enviaEmailPergunta =
            enviaEmail.enviaEmailPergunta(pergunta)

        println(enviaEmailPergunta)

    }



}