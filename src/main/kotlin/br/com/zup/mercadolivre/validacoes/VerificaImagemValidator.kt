package br.com.zup.mercadolivre.validacoes


import org.apache.tomcat.util.codec.binary.Base64
import org.springframework.web.multipart.MultipartFile
import java.lang.Exception

import javax.persistence.EntityManager
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class VerificaImagemValidator(

    val manager: EntityManager

) : ConstraintValidator<VerificaImagem, MultipartFile> {


    override fun isValid(o: MultipartFile?, p1: ConstraintValidatorContext?): Boolean {

        try{
            String(Base64.encodeBase64(o?.bytes));
            return true

        }catch (e:Exception){
            return false
        }


        }

}