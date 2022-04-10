package com.estoque.spring.repositorios;

import com.estoque.spring.entidades.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego Haefliger
 */

@Repository
public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, Long>{
    
}
