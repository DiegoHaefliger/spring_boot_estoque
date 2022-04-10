package com.estoque.spring.resource;

import com.estoque.spring.entidades.Produto;
import com.estoque.spring.servicos.ProdutoServico;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping(value = "/produtos")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProdutoResource {

    @Autowired
    private ProdutoServico service;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto produto = service.findById(id);

        return ResponseEntity.ok().body(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody Produto newProduto) {
        Produto produto = service.insert(newProduto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(produto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> update(@RequestBody Produto updatedproduto, @PathVariable Long id) {
        Produto produto = service.update(updatedproduto, id);

        return ResponseEntity.ok().body(produto);
    }
}
