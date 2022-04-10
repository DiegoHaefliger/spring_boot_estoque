package com.estoque.spring.resource;

import com.estoque.spring.entidades.ItemPedido;
import com.estoque.spring.servicos.ItemPedidoServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diego Haefliger
 */
@RestController
@RequestMapping(value = "/item")
public class ItemPedidoResource {
  @Autowired
	private ItemPedidoServico service;
	
	@GetMapping
	public ResponseEntity<List<ItemPedido>> findAll() {
		List<ItemPedido> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemPedido> findById(@PathVariable Long id) {
		ItemPedido ItemPedido = service.findById(id);
		
		return ResponseEntity.ok().body(ItemPedido);
	} 
}
