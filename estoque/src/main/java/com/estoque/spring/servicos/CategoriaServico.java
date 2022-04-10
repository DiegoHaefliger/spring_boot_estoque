package com.estoque.spring.servicos;

import com.estoque.spring.entidades.Categoria;
import com.estoque.spring.entidades.Usuario;
import com.estoque.spring.repositorios.CategoriaProdutoRepositorio;
import com.estoque.spring.servicos.excetions.ExceptionResourceNotFound;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Haefliger
 */
@Service
public class CategoriaServico {

    @Autowired
    private CategoriaProdutoRepositorio repositorio;

    public List<Categoria> findAll() {
        return repositorio.findAll();
    }

    public Categoria findById(Long id) {
        Optional<Categoria> Category = repositorio.findById(id);

        return Category.get();
    }

    public Categoria insert(Categoria categoria) {
        return repositorio.save(categoria);
    }

    public Categoria update(Categoria updatedCategoria, Long id) {
        try {
            @SuppressWarnings("deprecation")
            Categoria entity = repositorio.getOne(id);
            updatedData(entity, updatedCategoria);

            return repositorio.save(entity);

        } catch (EntityNotFoundException e) {
            throw new ExceptionResourceNotFound(id);
        }
    }

    private void updatedData(Categoria entity, Categoria updatedCategoria) {
        entity.setNome(updatedCategoria.getNome());
    }
}
