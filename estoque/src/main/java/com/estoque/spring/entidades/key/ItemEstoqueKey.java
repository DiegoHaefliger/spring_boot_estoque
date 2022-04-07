package com.estoque.spring.entidades.key;

import com.estoque.spring.entidades.Estoque;
import com.estoque.spring.entidades.Produto;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author diego haefliger
 */
@Embeddable
public class ItemEstoqueKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne()
    @JoinColumn(name = "ID_ESTOQUE", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_id_estoque"))
    private Estoque estoque;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_id_produto"))
    private Produto produto;

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(estoque, produto);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ItemEstoqueKey other = (ItemEstoqueKey) obj;
        return Objects.equals(estoque, other.estoque) && Objects.equals(produto, other.produto);
    }

}
