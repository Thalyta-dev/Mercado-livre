
package br.com.zup.mercadolivre.TratandoErros

import ErrosDto
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import kotlin.streams.toList


@ControllerAdvice
class APIExceptionHandler(val messageSource: MessageSource) {


    @ExceptionHandler(MethodArgumentNotValidException::class)
     fun handle(exception: MethodArgumentNotValidException): ResponseEntity<*>? {

        val dto: MutableList<ErrosDto> = ArrayList()
        val fieldErrors = exception.bindingResult.fieldErrors


        fieldErrors.forEach { e: FieldError ->
            val mensagem: String = messageSource.getMessage(e, LocaleContextHolder.getLocale())
            val erro = ErrosDto(e.field, mensagem)
            dto.add(erro)
        }
        val naoContemErro = dto.stream().filter { e: ErrosDto ->
            e.erro.equals(
                "Já existe um documento com essa proposta",
                ignoreCase = true
            )
        }.toList()
        return if (naoContemErro.isNotEmpty()) {
            ResponseEntity.unprocessableEntity().body(dto)
        } else ResponseEntity.badRequest().body(dto)
    }
}