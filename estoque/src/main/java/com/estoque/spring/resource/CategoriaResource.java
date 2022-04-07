package com.estoque.spring.resource;

import com.estoque.spring.entidades.CategoriaProduto;
import com.estoque.spring.servicos.CategoriaServicos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diego Haefliger
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaServicos categoriaServico;

    @GetMapping
    public ResponseEntity<List<CategoriaProduto>> findAll() {
        List<CategoriaProduto> list = categoriaServico.findAll();

        return ResponseEntity.ok().body(list);
    }

}
