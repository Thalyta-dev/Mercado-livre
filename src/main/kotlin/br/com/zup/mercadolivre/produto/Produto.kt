package br.com.zup.mercadolivre.produto

import br.com.zup.mercadolivre.Categoria
import br.com.zup.mercadolivre.imagem.Imagem
import br.com.zup.mercadolivre.opiniao.Opiniao
import br.com.zup.mercadolivre.pergunta.Pergunta
import br.com.zup.mercadolivre.usuario.Usuario
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Produto(

    @field: Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val nome: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    val vendedor: Usuario,

    @NotBlank
    val valor: BigDecimal,

    val quantidade: Int,

    @OneToMany(cascade = [CascadeType.ALL])
    @Size(min = 3)
    val caracteristicas: Set<Caracteristica>,


    val descricao: String,

    @ManyToOne
    val categoria: Categoria,

    val dataCriacao: LocalDateTime = LocalDateTime.now(),

    @OneToMany(cascade = [CascadeType.ALL])
    val imagens: MutableSet<Imagem> = mutableSetOf<Imagem>(),

    @OneToMany(cascade = [CascadeType.ALL])
    val opnioes: MutableSet<Opiniao> = mutableSetOf<Opiniao>(),

    @OneToMany(cascade = [CascadeType.ALL])
    val perguntas: MutableSet<Pergunta> = mutableSetOf<Pergunta>()

) {


    fun verificaVededorDoProduto(usuarioLogado: String): Boolean {

        return vendedor.email.equals(usuarioLogado)

    }

    fun adicionaImagem(imagens: MutableSet<Imagem>): Produto {
        this.imagens.addAll(imagens)
        return this

    }

    fun adicionaOpniao(opniao: Opiniao): Produto {
        this.opnioes.add(opniao)
        return this

    }

    fun adicionaPergunta(pergunta: Pergunta): Produto {
        this.perguntas.add(pergunta)
        return this

    }
}





