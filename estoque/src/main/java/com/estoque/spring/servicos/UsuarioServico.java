package com.estoque.spring.servicos;

import com.estoque.spring.entidades.Usuario;
import com.estoque.spring.repositorios.UsuarioRepositorio;
import com.estoque.spring.servicos.excetions.ExceptionDatabase;
import com.estoque.spring.servicos.excetions.ExceptionResourceNotFound;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 *
 * @author diego haefliger
 */
@Service
public class UsuarioServico {
  @Autowired
	private UsuarioRepositorio repository;
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> user = repository.findById(id);
		
		return user.orElseThrow(() -> new ExceptionResourceNotFound(id));
	}
	
	public Usuario findByEmail(String email) {
		Usuario sample = new Usuario();
		sample.setEmail(email); // set some data in sample
		boolean exists = repository.exists(Example.of(sample));
		
		Optional<Usuario> user = repository.findOne(Example.of(sample));
		
		return user.orElseThrow(() -> new ExceptionResourceNotFound(email));
	}
	
	public Usuario insert(Usuario newUser) {
		return repository.save(newUser);
	}
	
	public void delete(Long idUser) {
		try {
			repository.deleteById(idUser);
		} catch (EmptyResultDataAccessException e) {
			throw new ExceptionResourceNotFound(idUser);
		} catch (DataIntegrityViolationException e) {
			throw new ExceptionDatabase(e.getMessage());
		}
	}
	
	public Usuario update(Usuario updatedUser, Long id) {
		try { 
			@SuppressWarnings("deprecation")
			Usuario entity = repository.getOne(id);
			updatedData(entity, updatedUser);
		
			return repository.save(entity);
		
		} catch (EntityNotFoundException e) {
			throw new ExceptionResourceNotFound(id);
		}
	}

	private void updatedData(Usuario entity, Usuario updatedUser) {
		entity.setNome(updatedUser.getNome());
		entity.setEmail(updatedUser.getEmail());		
	}  
}
