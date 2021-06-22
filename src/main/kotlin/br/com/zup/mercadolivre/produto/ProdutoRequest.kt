package br.com.zup.mercadolivre.produto

import br.com.zup.mercadolivre.Categoria
import br.com.zup.mercadolivre.CategoriaRepository
import br.com.zup.mercadolivre.usuario.Usuario
import br.com.zup.mercadolivre.validacoes.ExistValor
import java.math.BigDecimal
import javax.persistence.CascadeType
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive
import javax.validation.constraints.Size

class ProdutoRequest(

    @field: NotEmpty
    val nome: String,

    @field: NotNull
    @Positive
    val valor: BigDecimal,

    @Positive
    @Size(min = 1)
    val quantidade: Int,

    @OneToMany(cascade = [CascadeType.ALL])
    @Size(min = 3)
    val caracteristicas: Set<CaracteristicasRequest>,

    @field: NotEmpty
    val descricao: String,

    @ManyToOne
    @field: NotNull
    @ExistValor(domainClass = Categoria::class, fieldName = "id")
    val categoria: Long


) {

    fun toModel(vendedor: Usuario, categoriaRepository: CategoriaRepository): Produto {


        return Produto(
            nome = nome,
            vendedor = vendedor,
            descricao = descricao,
            quantidade = quantidade,
            valor = valor,
            caracteristicas = caracteristicas.map { caracteristicasRequest -> caracteristicasRequest.toModel() }
                .toSet(),
            categoria = categoriaRepository.findById(categoria).get()
        )
    }
}




