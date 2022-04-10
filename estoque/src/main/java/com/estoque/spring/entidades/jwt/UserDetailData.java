package com.estoque.spring.entidades.jwt;

import com.estoque.spring.entidades.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 *
 * @author diego.haefliger
 */
public class UserDetailData implements UserDetails {

    private final Optional<Usuario> user;

    public UserDetailData(Optional<Usuario> user) {
        super();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {        
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {        
        return user.orElse(new Usuario()).getSenha();
    }

    @Override
    public String getUsername() {        
        return user.orElse(new Usuario()).getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {        
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {       
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {        
        return true;
    }

    @Override
    public boolean isEnabled() {        
        return true;
    }
}
