package com.estoque.spring.servicos;

import com.estoque.spring.entidades.Pedido;
import com.estoque.spring.repositorios.PedidoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Haefliger
 */
@Service
public class PedidoServico {

    @Autowired
    private PedidoRepositorio repositorio;

    public List<Pedido> findAll() {
        return repositorio.findAll();
    }

    public Pedido findById(Long id) {
        Optional<Pedido> Pedido = repositorio.findById(id);
        return Pedido.get();
    }

    public Pedido insert(Pedido newPedido) {
        return repositorio.save(newPedido);
    }
}
