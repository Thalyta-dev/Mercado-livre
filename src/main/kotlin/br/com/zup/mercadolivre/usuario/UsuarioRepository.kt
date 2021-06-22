package br.com.zup.mercadolivre.usuario

import org.springframework.data.repository.CrudRepository

interface UsuarioRepository: CrudRepository<Usuario,Long> {
}