package br.com.zup.mercadolivre.compra

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

enum class GatewayPagamentoDisponiveis {
//    PAYPAL {
//
//        override fun retornaParaPlatarformaPagamento(uriComponentBuilder: UriComponentsBuilder, compra: Compra): ResponseEntity.BodyBuilder {
//
//e            uriComponentBuilder.path("/paypal/compra/{idCompra}")
//                .buildAndExpand(compra.produto.id, compra.id).toUri().let {
//                    return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).location(it)
//                }
//        }
//    },
//    PAGSEGURO {
//
//    }
//
//    abstract fun retornaParaPlatarformaPagamento(uriComponentBuilder: UriComponentsBuilder,  compra: Compra):ResponseEntity.BodyBuilder

}
