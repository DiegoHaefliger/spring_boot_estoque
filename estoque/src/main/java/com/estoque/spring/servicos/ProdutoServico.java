package com.estoque.spring.servicos;

import com.estoque.spring.entidades.Produto;
import com.estoque.spring.entidades.Usuario;
import com.estoque.spring.repositorios.ProdutoRepositorio;
import com.estoque.spring.servicos.excetions.ExceptionDatabase;
import com.estoque.spring.servicos.excetions.ExceptionResourceNotFound;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Haefliger
 */
@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio repositorio;

    public List<Produto> findAll() {
        return repositorio.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> Produto = repositorio.findById(id);

        return Produto.get();
    }

    public Produto insert(Produto produto) {
        return repositorio.save(produto);
    }

    public void delete(Long id) {
        try {
            repositorio.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ExceptionResourceNotFound(id);
        } catch (DataIntegrityViolationException e) {
            throw new ExceptionDatabase(e.getMessage());
        }
    }

    public Produto update(Produto updatedProduto, Long id) {
        try {
            @SuppressWarnings("deprecation")
            Produto entity = repositorio.getOne(id);
            updatedData(entity, updatedProduto);

            return repositorio.save(entity);

        } catch (EntityNotFoundException e) {
            throw new ExceptionResourceNotFound(id);
        }
    }

    private void updatedData(Produto entity, Produto updatedProduto) {        
        entity.setValor(updatedProduto.getValor());
    }
}
