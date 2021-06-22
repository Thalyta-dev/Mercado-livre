package br.com.zup.mercadolivre.produto

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Caracteristica(

    @field: Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val nome: String,
    val descricao: String

) {


}
