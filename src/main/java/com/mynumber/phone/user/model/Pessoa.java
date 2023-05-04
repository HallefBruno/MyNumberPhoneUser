
package com.mynumber.phone.user.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Pessoa implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String nome;
  
  private Integer idade;
  
  @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, mappedBy = "pessoa", fetch = FetchType.EAGER)
  @JsonManagedReference
  private List<Telefone> telefones;
  
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "usuario_id", nullable = false)
  private Usuario usuario;

  public Pessoa() {
  }

  public Pessoa(Long id, String nome, Integer idade, List<Telefone> telefones, Usuario usuario) {
    this.id = id;
    this.nome = nome;
    this.idade = idade;
    this.telefones = telefones;
    this.usuario = usuario;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public List<Telefone> getTelefones() {
    return telefones;
  }

  public void setTelefones(List<Telefone> telefones) {
    this.telefones = telefones;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 89 * hash + Objects.hashCode(this.id);
    hash = 89 * hash + Objects.hashCode(this.nome);
    hash = 89 * hash + Objects.hashCode(this.idade);
    hash = 89 * hash + Objects.hashCode(this.telefones);
    hash = 89 * hash + Objects.hashCode(this.usuario);
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
    final Pessoa other = (Pessoa) obj;
    if (!Objects.equals(this.nome, other.nome)) {
      return false;
    }
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    if (!Objects.equals(this.idade, other.idade)) {
      return false;
    }
    if (!Objects.equals(this.telefones, other.telefones)) {
      return false;
    }
    return Objects.equals(this.usuario, other.usuario);
  }

  
  
}
