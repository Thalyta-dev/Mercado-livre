package br.com.zup.mercadolivre.produto

import org.springframework.data.repository.CrudRepository

interface ProdutoRepository: CrudRepository<Produto,Long> {
}