package br.com.zup.mercadolivre.usuario

import org.springframework.data.repository.CrudRepository
import java.util.*

interface UsuarioRepository: CrudRepository<Usuario,Long> {

    fun findByEmail(email: String): Optional<Usuario>
}