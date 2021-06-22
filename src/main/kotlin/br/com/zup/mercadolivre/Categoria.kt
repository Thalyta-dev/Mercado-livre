package br.com.zup.mercadolivre

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
class Categoria(

    @field: Id
    @field: GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @field: NotEmpty
    val nome: String,

    @ManyToOne
    val categoriaMae: Categoria? = null

) {
}