package com.estoque.spring.resource;

import com.estoque.spring.entidades.Usuario;
import com.estoque.spring.servicos.UsuarioServico;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diego Haefliger
 */
@RestController
@RequestMapping(value = "/login")
public class LoginResource {

    @Autowired
    private UsuarioServico service;

    @GetMapping
    public ResponseEntity<Usuario> validatePassword(@RequestParam String login,
            @RequestParam String senha) throws UnsupportedEncodingException {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Usuario> optUser = Optional.ofNullable(service.findByEmail(login));

        if (optUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        boolean valid = false;

        Usuario usuarios = optUser.get();
        valid = encoder.matches(senha, usuarios.getSenha());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(usuarios);
    }
}
