package br.com.zup.mercadolivre.email

import br.com.zup.mercadolivre.pergunta.Pergunta

interface ServicoEmail {

    fun enviaEmailPergunta(pergunta: Pergunta): String
}