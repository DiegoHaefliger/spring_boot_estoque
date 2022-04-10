package com.estoque.spring.repositorios;

import com.estoque.spring.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author diego haefliger
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
