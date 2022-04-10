package com.estoque.spring.servicos.jwt;

import com.estoque.spring.entidades.Usuario;
import com.estoque.spring.entidades.jwt.UserDetailData;
import com.estoque.spring.servicos.UsuarioServico;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author diego haefliger
 */
@Component
public class UserDetailServiceJWT implements UserDetailsService {

    @Autowired
    private UsuarioServico service;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> user = Optional.ofNullable(service.findByEmail(email));

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + email + "] não encontrado");
        }

        return new UserDetailData(user);
    }
}
