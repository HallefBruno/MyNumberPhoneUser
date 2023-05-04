package com.mynumber.phone.user.model;

import com.mynumber.phone.user.annotation.NotEmptyList;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column
  private String login;
  
  @Column
  private String senha;
  
  @NotEmptyList
  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
  @Column(name = "usuario_role")
  private List<String> roles;

  public Usuario(Long id, String login, String senha, List<String> roles) {
    this.id = id;
    this.login = login;
    this.senha = senha;
    this.roles = roles;
  }

  public Usuario() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
    hash = 31 * hash + Objects.hashCode(this.id);
    hash = 31 * hash + Objects.hashCode(this.login);
    hash = 31 * hash + Objects.hashCode(this.senha);
    hash = 31 * hash + Objects.hashCode(this.roles);
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
    final Usuario other = (Usuario) obj;
    if (!Objects.equals(this.login, other.login)) {
      return false;
    }
    if (!Objects.equals(this.senha, other.senha)) {
      return false;
    }
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return Objects.equals(this.roles, other.roles);
  }

  @Override
  public String toString() {
    return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", roles=" + roles + '}';
  }

}
