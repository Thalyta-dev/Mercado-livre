package br.com.zup.mercadolivre.imagem

import br.com.zup.mercadolivre.validacoes.VerificaImagem
import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.NotBlank

class ImagemRequest(

    @field:NotBlank
    var imagem: MutableSet<@VerificaImagem MultipartFile> = mutableSetOf<MultipartFile>()


) {

}