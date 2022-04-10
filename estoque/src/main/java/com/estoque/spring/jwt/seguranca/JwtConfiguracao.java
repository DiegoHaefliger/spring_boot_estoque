package com.estoque.spring.jwt.seguranca;

import com.estoque.spring.servicos.jwt.UserDetailServiceJWT;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author diego haefliger
 */
@EnableWebSecurity
public class JwtConfiguracao extends WebSecurityConfigurerAdapter {

    private final UserDetailServiceJWT usuarioService;
    private final PasswordEncoder passwordEncoder;

    public JwtConfiguracao(UserDetailServiceJWT usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()                
                .antMatchers(HttpMethod.POST, "/login").permitAll()                                
                .antMatchers(HttpMethod.POST, "/usuarios").permitAll()
                .antMatchers(HttpMethod.GET, "/usuarios").permitAll()                
                .anyRequest().authenticated()
                .and().cors().and().csrf().disable()
                .addFilter(new JwtAutenticacao(authenticationManager()))
                .addFilter(new JwtValidacao(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
