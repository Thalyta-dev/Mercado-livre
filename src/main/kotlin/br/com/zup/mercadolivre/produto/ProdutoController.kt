package br.com.zup.mercadolivre.produto

import br.com.zup.mercadolivre.CategoriaRepository
import br.com.zup.mercadolivre.usuario.Usuario
import br.com.zup.mercadolivre.usuario.UsuarioRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.util.function.Supplier
import javax.validation.Valid


@RestController
@RequestMapping("/produtos")
class ProdutoController(
    
    val produtoRepository: ProdutoRepository,
    val categoriaRepository: CategoriaRepository,
    val usuarioRepository: UsuarioRepository


) {
    
    
    
    @PostMapping
    fun login(@RequestBody @Valid produtoRequest: ProdutoRequest, uriComponentsBuilder: UriComponentsBuilder,
              @AuthenticationPrincipal jwt: Jwt
              ): ResponseEntity<Any>{


        val emailVendedor = jwt.claims["email"].toString()

        val vendedorAutenticado = usuarioRepository.findByEmail(emailVendedor).
        orElseGet { usuarioRepository.save(Usuario(email = jwt.claims["email"].toString())) }

        val produto = this.produtoRepository.save(produtoRequest.toModel(vendedorAutenticado, categoriaRepository))

         return  uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(produto.id).toUri().run {

             ResponseEntity.created(this).body(
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