package com.estoque.spring.repositorios;

import com.estoque.spring.entidades.EstoqueItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego Haefliger
 */

@Repository
public interface EstoqueItemRepositorio extends JpaRepository<EstoqueItem, Long>{
    
}
