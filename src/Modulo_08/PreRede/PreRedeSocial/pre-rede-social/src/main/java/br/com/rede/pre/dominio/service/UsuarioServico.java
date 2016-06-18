package br.com.rede.pre.dominio.service;

import br.com.rede.pre.dominio.model.Usuario;
import br.com.rede.pre.infraestrutura.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {
    
    @Autowired
    UsuarioRepositorio repositorio;
    
    public Iterable<Usuario> usuarios(){
        return repositorio.findAll();
    }
}
