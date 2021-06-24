package br.com.zup.mercadolivre.imagem

import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class enviaImagem: UploaderImage {

    override fun enviarImagem(image: MutableSet<MultipartFile>):MutableSet<Imagem> {


       return image.map { imagem -> Imagem(
            urlImagem = "http://amazonCloud/MercadoLivre/${imagem.originalFilename}"
        ) }.toMutableSet()


    }
}