package br.com.zup.mercadolivre.compra

import br.com.zup.mercadolivre.produto.Produto
import br.com.zup.mercadolivre.usuario.Usuario
import java.math.BigDecimal
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class Compra(

    @field: Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val produto: Produto,

    val quantidade: Int,

    val comprador: Usuario,

    val valorProduto: BigDecimal,

    val statusCompra: StatusCompra = StatusCompra.INICIADA,

    val gatewayPagamento: GatewayPagamentoDisponiveis
){
}