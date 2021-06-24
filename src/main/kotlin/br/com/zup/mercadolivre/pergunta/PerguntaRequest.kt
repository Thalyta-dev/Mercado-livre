package br.com.zup.mercadolivre.pergunta

import br.com.zup.mercadolivre.produto.Produto
import br.com.zup.mercadolivre.usuario.Usuario
import javax.validation.constraints.NotBlank

class PerguntaRequest   (

    @field: NotBlank
    val titulo: String,

    @field: NotBlank
    val descricao: String


) {

    fun toModel(usuario: Usuario, produto: Produto): Pergunta {

        return Pergunta(
            usuario = usuario,
            descricao = descricao,
            titulo = titulo,
            produto = produto
        )
    }

}