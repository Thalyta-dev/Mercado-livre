package br.com.zup.mercadolivre.opiniao

import ErrosDto
import br.com.zup.mercadolivre.produto.ProdutoRepository
import br.com.zup.mercadolivre.usuario.Usuario
import br.com.zup.mercadolivre.usuario.UsuarioRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/produtos")
class OpiniaoController(


    val produtoRepository: ProdutoRepository,
    val usuarioRepository: UsuarioRepository


) {

    @PostMapping("/{id}/opinioes")
    fun saveCategoria(

        @Valid @RequestBody opniaoRequest: OpiniaoRequest,
        @PathVariable id: Long,
        @AuthenticationPrincipal jwt: Jwt,
        uriComponentsBuilder: UriComponentsBuilder

    ): ResponseEntity<Any> {


        val produto = produtoRepository.findById(id)

        if (produto.isEmpty) {
            return ResponseEntity.notFound().build()
        }


        val emailUsuario = jwt.claims["email"].toString()

        val usuario = usuarioRepository.findByEmail(emailUsuario).
        orElseGet { usuarioRepository.save(Usuario(email = jwt.claims["email"].toString())) }

        produto.get().adicionaOpniao(opniaoRequest.toModel(usuario)).let { produtoAtualizado ->
            var save = produtoRepository.save(produtoAtualizado)

            uriComponentsBuilder.path("/produtos/{id}/opniao").buildAndExpand(produtoAtualizado.id).toUri()
                .run {
                 return   ResponseEntity.created(this).build()
                }

        }
    }

}