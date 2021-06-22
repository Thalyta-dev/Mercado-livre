package br.com.zup.mercadolivre.produto

import javax.validation.constraints.NotEmpty

data class CaracteristicasRequest(


    @field: NotEmpty
    val nome: String,

    @field: NotEmpty
    val descricao: String
) {

    fun toModel(): Caracteristica {

        return Caracteristica(
            nome= nome,
            descricao = descricao
        )
    }
}
