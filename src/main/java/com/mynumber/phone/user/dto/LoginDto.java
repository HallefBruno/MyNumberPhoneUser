package com.mynumber.phone.user.dto;

import java.io.Serializable;
import java.util.Objects;

public class LoginDto implements Serializable {
  
  private String email;
  private String password;

  public LoginDto(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public LoginDto() {
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 79 * hash + Objects.hashCode(this.email);
    hash = 79 * hash + Objects.hashCode(this.password);
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
    final LoginDto other = (LoginDto) obj;
    if (!Objects.equals(this.email, other.email)) {
      return false;
    }
    return Objects.equals(this.password, other.password);
  }

  @Override
  public String toString() {
    return "LoginDto{" + "email=" + email + ", password=" + password + '}';
  }
  
}
