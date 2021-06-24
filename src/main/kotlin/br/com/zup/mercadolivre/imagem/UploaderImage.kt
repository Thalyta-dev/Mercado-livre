package br.com.zup.mercadolivre.imagem

import org.springframework.web.multipart.MultipartFile

interface UploaderImage {

    fun enviarImagem(image: MutableSet<MultipartFile>): MutableSet<Imagem>;
}