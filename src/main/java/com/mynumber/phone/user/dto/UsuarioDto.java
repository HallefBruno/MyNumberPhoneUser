
package com.mynumber.phone.user.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class UsuarioDto implements Serializable {
  private String login;
  private String senha;
  private List<String> roles;

  public UsuarioDto() {
  }
  
  public UsuarioDto(String login, String senha, List<String> roles) {
    this.login = login;
    this.senha = senha;
    this.roles = roles;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 37 * hash + Objects.hashCode(this.login);
    hash = 37 * hash + Objects.hashCode(this.senha);
    hash = 37 * hash + Objects.hashCode(this.roles);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final UsuarioDto other = (UsuarioDto) obj;
    if (!Objects.equals(this.login, other.login)) {
      return false;
    }
    if (!Objects.equals(this.senha, other.senha)) {
      return false;
    }
    return Objects.equals(this.roles, other.roles);
  }
  
  
  
}
