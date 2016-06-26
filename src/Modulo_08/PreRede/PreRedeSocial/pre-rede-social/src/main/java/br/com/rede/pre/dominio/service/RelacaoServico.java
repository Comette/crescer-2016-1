package br.com.rede.pre.dominio.service;

import br.com.rede.pre.dominio.model.Relacao;
import br.com.rede.pre.dominio.model.TipoRelacao;
import br.com.rede.pre.dominio.model.Usuario;
import br.com.rede.pre.infraestrutura.RelacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelacaoServico {
    
    @Autowired
    RelacaoRepositorio repositorio;
    
    public Relacao nova(Usuario solicitante, Usuario solicitado, TipoRelacao tRelacao){
        Relacao nova = new Relacao(0l, solicitante, solicitado, tRelacao);
        return repositorio.save(nova);        
    }
}
