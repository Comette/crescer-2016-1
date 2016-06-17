package br.com.crescer.controller;

import br.com.crescer.dominio.Pessoa;
import br.com.crescer.dominio.PessoaService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaRest {
    
    @Autowired
    PessoaService service;
    
    @RequestMapping(value = "/data_atual")
    public Date date() {
        return new Date();
    }

    @RequestMapping(value = "/pessoa")
    public List<Pessoa> list(){
        return service.list();
    }
    
}
