package br.com.zup.mercadolivre.produto

import javax.persistence.*

@Entity
data class Caracteristica(

    @field: Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(columnDefinition = "text")
    val nome: String,
    val descricao: String

) {


}
