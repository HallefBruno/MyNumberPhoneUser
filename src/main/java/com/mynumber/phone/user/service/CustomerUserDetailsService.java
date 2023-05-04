
package com.mynumber.phone.user.service;

import com.mynumber.phone.user.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomerUserDetailsService implements UserDetailsService {
  
  @Autowired
  private UsuarioService usuarioService;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario = usuarioService.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados."));
    List<GrantedAuthority> authorities = new ArrayList<>();
    usuario.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.toUpperCase())));
    return User
      .builder()
      .username(usuario.getLogin())
      .password(usuario.getSenha())
      .authorities(authorities)
      .build();
  }
  
}
