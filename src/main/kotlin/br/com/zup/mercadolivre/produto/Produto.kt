package br.com.zup.mercadolivre.produto

import br.com.zup.mercadolivre.Categoria
import br.com.zup.mercadolivre.usuario.Usuario
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Produto(

    @field: Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val nome: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    val vendedor: Usuario?,

    val valor: BigDecimal,

    val quantidade: Int,

    @OneToMany(cascade = [CascadeType.ALL])
    val caracteristicas: Set<Caracteristica>,

    val descricao: String,

    @ManyToOne
    val categoria: Categoria,

    private val dataCriacao: LocalDateTime = LocalDateTime.now()



) {
}



