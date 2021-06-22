package br.com.zup.mercadolivre

import org.springframework.data.repository.CrudRepository

interface CategoriaRepository: CrudRepository<Categoria,Long> {
}