package br.com.zup.mercadolivre.usuario

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


/*@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    
    val usuarioRepository: UsuarioRepository
) {
    
    
    
    @PostMapping
    fun login(@RequestBody @Valid usuarioRequest:UsuarioRequest, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<Any>{

        val usuarioSalvo = this.usuarioRepository.save(usuarioRequest.toModel())

         return  uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuarioSalvo.id).toUri().run {
            return ResponseEntity.created(this).body(
                object {
                    val id = usuarioSalvo.id
                    val email = usuarioSalvo.email
                }
            )
        }

    }
}*/