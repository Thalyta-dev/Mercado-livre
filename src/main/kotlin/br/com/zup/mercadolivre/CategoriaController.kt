package br.com.zup.mercadolivre

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/categorias")
class CategoriaController(


    val categoriaRepository: CategoriaRepository

) {

    @PostMapping
    fun saveCategoria(

        @RequestBody @Valid categoriaRequest: CategoriaRequest,
        uriComponentsBuilder: UriComponentsBuilder

    ): ResponseEntity<Any>{

        val categoria = categoriaRepository.save(categoriaRequest.toModel(categoriaRepository))

        return  uriComponentsBuilder.path("/categoria/{id}").buildAndExpand(categoria.id).toUri().run {
             ResponseEntity.created(this).body(
                object {
                    val id = categoria.id
                    val nome = categoria.nome
                }
            )
        }

    }
}

