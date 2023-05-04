
package com.mynumber.phone.user.controller;

import com.mynumber.phone.user.dto.BearerToken;
import com.mynumber.phone.user.dto.LoginDto;
import com.mynumber.phone.user.dto.UsuarioDto;
import com.mynumber.phone.user.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
  
  @Autowired
  private UsuarioService usuarioService;
  
  @PostMapping("salvar")
  @ResponseStatus(HttpStatus.CREATED)
  public BearerToken salvar(@RequestBody UsuarioDto usuarioDto) {
    return usuarioService.salvar(usuarioDto);
  }
  
  @PostMapping("autenticar")
  @ResponseStatus(HttpStatus.OK)
  public String autenticar(@RequestBody LoginDto loginDto) {
    return usuarioService.authenticate(loginDto);
  }
  
}
