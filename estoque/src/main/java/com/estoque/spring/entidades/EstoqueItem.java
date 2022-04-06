package com.estoque.spring.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author diego haefliger
 */
@Entity
@Table(name = "ESTOQUE_ITEM")
public class EstoqueItem implements Serializable {

    private static final long serialVersionUID = 1L;

//        @EmbeddedId
//        private EstoqueItemPK id = new EstoqueItemPK();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantidade;
    private Double valor;

    public EstoqueItem() {

    }

    public EstoqueItem(Estoque estoque, Produto produto, Integer quantidade, Double valor) {
        super();

    }

    @JsonIgnore
    public Estoque getEstoque() {
//        return id.getEstoque();
        return null;
    }

    public void setEstoque(Estoque estoque) {
//        id.setEstoque(estoque);
    }

    public Produto getProduto() {
//        return id.getProduto();
        return null;
    }

    public void setProduto(Produto produto) {
//        id.setProduto(produto);
    }

    public Integer getQuantidade() {
//        return quantidade;
        return null;
    }

    public void setQuantity(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setPrice(Double valor) {
        this.valor = valor;
    }

    public Double getSubTotal() {
        return quantidade * valor;
    }

    @Override
    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        EstoqueItem other = (EstoqueItem) obj;
//        return Objects.equals(id, other.id);
        return false;
    }
}
