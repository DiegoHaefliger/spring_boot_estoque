package com.estoque.spring.servicos;

import com.estoque.spring.entidades.CategoriaProduto;
import com.estoque.spring.repositorios.CategoriaProdutoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Haefliger
 */
@Service
public class CategoriaServicos {
    	@Autowired
	private CategoriaProdutoRepositorio repository;
	
	public List<CategoriaProduto> findAll() {
		return repository.findAll();
	}
	
	public CategoriaProduto findById(Long id) {
		Optional<CategoriaProduto> Category = repository.findById(id);
		
		return Category.get();
	}
	
	public CategoriaProduto insert(CategoriaProduto categoria) {
		return repository.save(categoria);
	}
}
