package br.com.zup.mercadolivre.usuario

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email

@Entity
class Usuario(

    @field: Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Email
    val email: String,

    private val dataCriacao: LocalDateTime = LocalDateTime.now()

) {


}