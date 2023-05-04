
package com.mynumber.phone.user.service;

import com.mynumber.phone.user.model.Telefone;
import com.mynumber.phone.user.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TelefoneService {
  
  @Autowired
  private TelefoneRepository telefoneRepository;
  
  @Transactional
  public Telefone salvar(Telefone telefone) {
    telefone = telefoneRepository.save(telefone);
    return telefone;
  }
  
}
