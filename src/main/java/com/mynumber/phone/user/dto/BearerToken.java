package com.mynumber.phone.user.dto;

import java.io.Serializable;
import java.util.Objects;

public class BearerToken implements Serializable {

  private String accessToken;
  private String tokenType;

  public BearerToken(String accessToken, String tokenType) {
    this.tokenType = tokenType;
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 37 * hash + Objects.hashCode(this.accessToken);
    hash = 37 * hash + Objects.hashCode(this.tokenType);
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
    final BearerToken other = (BearerToken) obj;
    if (!Objects.equals(this.accessToken, other.accessToken)) {
      return false;
    }
    return Objects.equals(this.tokenType, other.tokenType);
  }
  
  
}
