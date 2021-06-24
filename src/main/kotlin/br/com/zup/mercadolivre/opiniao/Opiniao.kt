package br.com.zup.mercadolivre.opiniao

import br.com.zup.mercadolivre.usuario.Usuario
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Size


@Entity
class Opiniao(

    @field: Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(cascade = [CascadeType.ALL])
    val usuario: Usuario,

    val titulo: String,

    @Lob
    val descricao: String,

    @Size(min = 1, max = 5)
    val nota: Int,

    private val dataCriacao: LocalDateTime = LocalDateTime.now()

    ) {

}