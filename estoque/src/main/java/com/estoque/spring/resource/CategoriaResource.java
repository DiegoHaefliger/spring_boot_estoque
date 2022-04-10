package com.estoque.spring.resource;

import com.estoque.spring.entidades.Categoria;
import com.estoque.spring.entidades.Usuario;
import com.estoque.spring.servicos.CategoriaServico;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Diego Haefliger
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaServico service;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Categoria Category = service.findById(id);

        return ResponseEntity.ok().body(Category);
    }

    @PostMapping
    public ResponseEntity<Categoria> insert(@RequestBody Categoria categoria) {
        Categoria newCategory = service.insert(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCategory.getId()).toUri();

        return ResponseEntity.created(uri).body(newCategory);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Categoria> update(@RequestBody Categoria updatedCategoria, @PathVariable Long id) {
        Categoria categoria = service.update(updatedCategoria, id);

        return ResponseEntity.ok().body(categoria);
    }

}
