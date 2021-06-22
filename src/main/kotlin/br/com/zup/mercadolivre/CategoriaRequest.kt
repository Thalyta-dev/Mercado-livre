package br.com.zup.mercadolivre

import br.com.zup.mercadolivre.validacoes.ExistValor
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class CategoriaRequest(

    @field: NotEmpty
    @Size(min = 5)
    val nome: String = "",

    @ExistValor(domainClass = Categoria::class, fieldName = "categoria_mae_id")
    val categoriaMae: Long? = null

) {
    fun toModel(categoriaRepository: CategoriaRepository): Categoria {

        val categoriaMae = categoriaMae?.let { categoriaRepository.findById(it) }

        return Categoria(
            categoriaMae = categoriaMae?.get(),
            nome = nome
        )

    }


}