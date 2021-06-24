package br.com.zup.mercadolivre.imagem

import ErrosDto
import br.com.zup.mercadolivre.produto.Produto
import br.com.zup.mercadolivre.produto.ProdutoRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.util.*
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/produtos")
class ImagemController(


    val produtoRepository: ProdutoRepository,
    val enviaImagem: enviaImagem

) {


    @Transactional
    @PostMapping("/{id}/imagens")
    fun saveCategoria(

        @Valid imagemRequest: ImagemRequest,
        @PathVariable id: Long,
        @AuthenticationPrincipal jwt: Jwt,
        uriComponentsBuilder: UriComponentsBuilder

    ): ResponseEntity<Any> {


        val produto:Optional<Produto> = produtoRepository.findById(id)

        if (produto.isEmpty) {
            return ResponseEntity.notFound().build()
        }

        if (!produto.get().verificaVededorDoProduto(jwt.claims["email"].toString())) {

            return ResponseEntity.unprocessableEntity().body(
                ErrosDto(
                    campo = "Produto",
                    erro = "Produto não pertence a esse vendedor"
                )
            )

        }
        val imagensSalvas = enviaImagem.enviarImagem(imagemRequest.imagem)


        val adicionaImagem = produto.get().adicionaImagem(imagensSalvas)

        val save = produtoRepository.save(adicionaImagem)

        uriComponentsBuilder.path("/produtos/{id}/imagens").buildAndExpand(save.id).toUri()
            .run {
                return   ResponseEntity.created(this).build()
            }

    }

}

