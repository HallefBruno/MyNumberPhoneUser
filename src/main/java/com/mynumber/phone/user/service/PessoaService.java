package com.mynumber.phone.user.service;

import com.mynumber.phone.user.model.Pessoa;
import com.mynumber.phone.user.repository.PessoaRepository;
import com.mynumber.phone.user.util.VendasUtil;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PessoaService {
  
  @Autowired
  private PessoaRepository pessoaRepository; 
  
  @Transactional
  public Pessoa salvar(Pessoa pessoa) {
    pessoa = pessoaRepository.save(pessoa);
    return pessoa;
  }
  
  @Transactional
  public Pessoa update(Pessoa pessoa) {
    if (Objects.nonNull(pessoa) && (Objects.nonNull(pessoa.getId()) && pessoa.getId() > 0)) {
      Pessoa atual = pessoaRepository.findById(pessoa.getId()).get();
      VendasUtil.copyProperties(pessoa, atual, "");
      atual = pessoaRepository.save(atual);
      return atual;
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador inválido!");
  }
  
  @Transactional
  public void excluir(Long id) {
    if(Objects.nonNull(id) && id > 0 && pessoaRepository.existsById(id)) {
      pessoaRepository.deleteById(id);
      return;
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador inválido!");
  }
  
  public Pessoa get(Long id) {
    if(Objects.nonNull(id) && id > 0 && pessoaRepository.existsById(id)) {
      return pessoaRepository.findById(id).get();
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador inválido!");
  }
  
}
