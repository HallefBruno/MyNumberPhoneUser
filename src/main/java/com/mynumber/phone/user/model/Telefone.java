
package com.mynumber.phone.user.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Telefone implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String numero;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JsonBackReference
  private Pessoa pessoa;

  public Telefone() {
  }

  public Telefone(Long id, String numero, Pessoa pessoa) {
    this.id = id;
    this.numero = numero;
    this.pessoa = pessoa;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.id);
    hash = 89 * hash + Objects.hashCode(this.numero);
    hash = 89 * hash + Objects.hashCode(this.pessoa);
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
    final Telefone other = (Telefone) obj;
    if (!Objects.equals(this.numero, other.numero)) {
      return false;
    }
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return Objects.equals(this.pessoa, other.pessoa);
  }

  @Override
  public String toString() {
    return "Telefone{" + "id=" + id + ", numero=" + numero + ", pessoa=" + pessoa + '}';
  }
  
}
