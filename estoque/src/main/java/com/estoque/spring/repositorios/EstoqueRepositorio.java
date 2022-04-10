package com.estoque.spring.repositorios;

import com.estoque.spring.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego Haefliger
 */
@Repository
public interface EstoqueRepositorio extends JpaRepository<Pedido, Long> {

}
