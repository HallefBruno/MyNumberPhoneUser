
package com.mynumber.phone.user.controller;

import com.mynumber.phone.user.model.Pessoa;
import com.mynumber.phone.user.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
  
  @Autowired
  private PessoaService pessoaService;
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Pessoa salvar(@RequestBody Pessoa pessoa) {
    return pessoaService.salvar(pessoa);
  }
  
  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void excluir(@PathVariable(required = true) Long id) {
    pessoaService.excluir(id);
  }
  
  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public Pessoa update(@RequestBody Pessoa pessoa) {
    return pessoaService.update(pessoa);
  }
  
  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public Pessoa get(@PathVariable(required = true) Long id) {
    return pessoaService.get(id);
  }
  
}
