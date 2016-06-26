package br.com.crescer.dominio;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    public List<Pessoa> list() {
        Pessoa p = new Pessoa();
        p.setNome("Victor COmette Ribeiro");
        p.setNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }
}
