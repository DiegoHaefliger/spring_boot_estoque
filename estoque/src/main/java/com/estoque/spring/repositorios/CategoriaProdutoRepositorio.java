package com.estoque.spring.repositorios;

/**
 *
 * @author Diego Haefliger
 */
import com.estoque.spring.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaProdutoRepositorio extends JpaRepository<Categoria, Long> {

}
