package br.com.rede.pre.infraestrutura;

import br.com.rede.pre.dominio.model.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    
}
