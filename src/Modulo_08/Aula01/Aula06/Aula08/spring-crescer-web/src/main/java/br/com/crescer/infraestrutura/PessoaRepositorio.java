package br.com.crescer.infraestrutura;

import br.com.crescer.dominio.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepositorio extends CrudRepository<Pessoa, Long>{
    
}
