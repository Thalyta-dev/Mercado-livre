package br.com.zup.mercadolivre.email

import br.com.zup.mercadolivre.pergunta.Pergunta
import org.springframework.stereotype.Component

@Component
class EnviaEmail: ServicoEmail {

    override fun enviaEmailPergunta(pergunta: Pergunta): String {

        return """
                 De:${pergunta.usuario.email} 
                 Para:  ${pergunta.produto.vendedor.email} 
                 Assunto:  ${pergunta.titulo}  
                 Corpo do email: ${pergunta.descricao} 
        """.trimIndent()
    }
}