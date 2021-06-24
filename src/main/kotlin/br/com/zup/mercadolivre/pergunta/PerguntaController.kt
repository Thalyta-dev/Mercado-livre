package br.com.zup.mercadolivre.pergunta

import br.com.zup.mercadolivre.eventos.EnviarEmailEventPublisher
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
class PerguntaController(


    val produtoRepository: ProdutoRepository,
    val usuarioRepository: UsuarioRepository,
    val enviaEmailEvent: EnviarEmailEventPublisher


) {

    @PostMapping("/{id}/perguntas")
    fun saveCategoria(

        @Valid @RequestBody perguntaRequest: PerguntaRequest,
        @PathVariable id: Long,
        @AuthenticationPrincipal jwt: Jwt,
        uriComponentsBuilder: UriComponentsBuilder

    ): ResponseEntity<Any> {


        val produto = produtoRepository.findById(id)

        if (produto.isEmpty) {
            return ResponseEntity.notFound().build()
        }


        val emailUsuario = jwt.claims["email"].toString()

        val usuario =
            usuarioRepository.findByEmail(emailUsuario)
                .orElseGet { usuarioRepository.save(Usuario(email = jwt.claims["email"].toString())) }

        val pergunta = perguntaRequest.toModel(usuario, produto.get())

        enviaEmailEvent.enviaEmail(pergunta)


        produto.get().adicionaPergunta(pergunta).let {produtoAtualizado ->

            var save = produtoRepository.save(produtoAtualizado)

            uriComponentsBuilder.path("/produtos/{id}/opniao")
                .buildAndExpand(produtoAtualizado.id).toUri()

                .run {
                    return ResponseEntity.created(this).build()
                }

        }
    }

}