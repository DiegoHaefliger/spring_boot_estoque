package com.estoque.spring;

import com.estoque.spring.entidades.Categoria;
import com.estoque.spring.entidades.ItemPedido;
import com.estoque.spring.entidades.Pedido;
import com.estoque.spring.entidades.Produto;
import com.estoque.spring.entidades.Usuario;
import com.estoque.spring.repositorios.CategoriaProdutoRepositorio;
import com.estoque.spring.repositorios.ItemPedidoRepositorio;
import com.estoque.spring.repositorios.PedidoRepositorio;
import com.estoque.spring.repositorios.ProdutoRepositorio;
import com.estoque.spring.repositorios.UsuarioRepositorio;
import java.util.Arrays;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@RunWith(SpringRunner.class)        
@WebAppConfiguration        
class CourseApplicationTests {

  @Autowired
    private UsuarioRepositorio userRepository;

    @Autowired
    private PedidoRepositorio orderRepository;

    @Autowired
    private CategoriaProdutoRepositorio categoryRepository;

    @Autowired
    private ProdutoRepositorio productRepository;

    @Autowired
    private ItemPedidoRepositorio orderItemRepository;

    @Test
    public void createTeste() {

        Categoria cat1 = new Categoria(null, "Eletronicos");

        Produto p1 = new Produto(null, "Geladeira", 90.5);

        categoryRepository.saveAll(Arrays.asList(cat1));
        productRepository.saveAll(Arrays.asList(p1));

        p1.getCategoria().add(cat1);

        productRepository.saveAll(Arrays.asList(p1));

        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "123456");

        Pedido o1 = new Pedido(null, "Entrada", (new Date()));

        userRepository.saveAll(Arrays.asList(u1, u1));
        orderRepository.saveAll(Arrays.asList(o1));

        ItemPedido oi1 = new ItemPedido(o1, p1, 2, p1.getValor());

        orderItemRepository.saveAll(Arrays.asList(oi1));

        orderRepository.save(o1);

    }

}
