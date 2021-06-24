package br.com.zup.mercadolivre.opiniao

import br.com.zup.mercadolivre.usuario.Usuario
import javax.persistence.Lob
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class OpiniaoRequest(

    @field:NotEmpty
    val titulo: String = "",

    @field:Lob
    @field:NotEmpty
    val descricao: String = "",

    @field:NotEmpty
    @field:Size(min = 1, max = 5)
    val nota: Int = 0
) {

    fun toModel(usuario: Usuario): Opiniao{

        return Opiniao(
            usuario = usuario,
            descricao = descricao,
            nota = nota,
            titulo = titulo
        )


    }
}