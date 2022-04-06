package com.estoque.spring.repositorios;

/**
 *
 * @author diego haefliger
 */
import com.estoque.spring.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
