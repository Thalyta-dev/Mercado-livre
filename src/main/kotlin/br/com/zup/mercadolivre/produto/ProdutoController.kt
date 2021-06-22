package br.com.zup.mercadolivre.produto

import br.com.zup.mercadolivre.CategoriaRepository
import br.com.zup.mercadolivre.usuario.Usuario
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping("/produtos")
class ProdutoController(
    
    val produtoRepository: ProdutoRepository,
    val categoriaRepository: CategoriaRepository

) {
    
    
    
    @PostMapping
    fun login(@RequestBody @Valid produtoRequest: ProdutoRequest, uriComponentsBuilder: UriComponentsBuilder,
              @AuthenticationPrincipal jwt: Jwt
              ): ResponseEntity<Any>{

        println(jwt.claims["email"].toString())

        val vendedorAutenticado = Usuario( email = jwt.claims["email"].toString()


        )

        val produto = this.produtoRepository.save(produtoRequest.toModel(vendedorAutenticado, categoriaRepository))

         return  uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(produto.id).toUri().run {
            return ResponseEntity.created(this).body(
                object {
                    val id = produto.id
                    val nomeProduto = produto.nome
                    val valor = produto.valor
                    val vendedor = produto.vendedor

                }
            )
        }

    }
}