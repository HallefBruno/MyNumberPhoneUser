
package com.mynumber.phone.user.service;

import com.mynumber.phone.user.dto.BearerToken;
import com.mynumber.phone.user.dto.LoginDto;
import com.mynumber.phone.user.dto.UsuarioDto;
import com.mynumber.phone.user.model.Usuario;
import com.mynumber.phone.user.repository.UsuarioRepository;
import com.mynumber.phone.user.security.JwtUtilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
  
  @Autowired
  private UsuarioRepository usuarioRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private JwtUtilities jwtUtilities;
  @Autowired
  private AuthenticationManager authenticationManager;
  
  @Transactional
  public BearerToken salvar(UsuarioDto usuarioDto) {
    Usuario user = new Usuario();
    user.setLogin(usuarioDto.getLogin());
    user.setSenha(passwordEncoder.encode(usuarioDto.getSenha()));
    user.setRoles(usuarioDto.getRoles());
    String token = jwtUtilities.generateToken(usuarioDto.getLogin(), usuarioDto.getRoles());
    usuarioRepository.save(user);
    return new BearerToken(token, "Bearer ");
  }
  
  public String authenticate(LoginDto loginDto) {
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    Usuario user = usuarioRepository.findByLogin(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    List<String> rolesNames = new ArrayList<>();
    user.getRoles().forEach(r -> rolesNames.add(r));
    String token = jwtUtilities.generateToken(user.getLogin(), rolesNames);
    return token;
  }
  
  public Optional<Usuario> findByLogin(String username) {
    return usuarioRepository.findByLogin(username);
  }
  
}
