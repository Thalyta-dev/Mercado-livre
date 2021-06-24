package br.com.zup.mercadolivre.pergunta

import br.com.zup.mercadolivre.produto.Produto
import br.com.zup.mercadolivre.usuario.Usuario
import javax.persistence.*


@Entity
class Pergunta    (

    @field: Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val titulo: String,

    @Lob
    val descricao: String,

    @ManyToOne
    val usuario: Usuario,

    @ManyToOne
    val produto: Produto

    ) {





}