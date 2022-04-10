package com.estoque.spring.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author diego haefliger
 */
@Entity
@Table(name = "ITEM_PEDIDO")
public class ItemPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "pedido_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_id_pedido"))
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_id_produto"))
    private Produto produto;
    @Column(nullable = false)
    private Integer quantidade;
    @Column(nullable = false)
    private Double valor;

    public ItemPedido() {

    }

    public ItemPedido(Pedido estoque, Produto produto, Integer quantidade, Double valor) {
        this.setEstoque(estoque);
        this.setProduto(produto);
        this.setQuantidade(quantidade);
        this.setValor(valor);
    }

    @JsonIgnore
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getEstoque() {
        return pedido;
    }

    public void setEstoque(Pedido estoque) {
        this.pedido = estoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;

        if (produto != null && this.valor == null) {
            this.setValor(produto.getValor());
        }
    }
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
