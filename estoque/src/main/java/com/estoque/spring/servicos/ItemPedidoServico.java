package com.estoque.spring.servicos;

import com.estoque.spring.entidades.ItemPedido;
import com.estoque.spring.repositorios.ItemPedidoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Haefliger
 */
@Service
public class ItemPedidoServico {

    @Autowired
    private ItemPedidoRepositorio repositorio;

    public List<ItemPedido> findAll() {
        return repositorio.findAll();
    }

    public ItemPedido findById(Long id) {
        Optional<ItemPedido> ItemPedido = repositorio.findById(id);

        return ItemPedido.get();
    }

    public ItemPedido insert(ItemPedido ItemPedido) {
        return repositorio.save(ItemPedido);
    }
}
