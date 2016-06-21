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

    public Usuario buscaPorEmailSenha(String email, String senha) {
        String senhaCriptografada = this.criptografa(senha);
        return repositorio.findByEmailAndSenha(email, senhaCriptografada);        
    }

    private String criptografa(String senha) {
        return "123" + senha;
    }

    public Usuario buscaPorId(long id) {
        return repositorio.findOne(id);
    }
}
