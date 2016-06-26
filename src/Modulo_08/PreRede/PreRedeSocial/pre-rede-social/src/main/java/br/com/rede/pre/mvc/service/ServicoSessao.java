package br.com.rede.pre.mvc.service;

import br.com.rede.pre.dominio.model.Usuario;
import br.com.rede.pre.mvc.model.UsuarioLogadoModel;

public class ServicoSessao {
    
    private static UsuarioLogadoModel usuarioLogado;

    public static void criar(UsuarioLogadoModel usuarioLogado) {
        ServicoSessao.usuarioLogado = usuarioLogado;
    }

    public static UsuarioLogadoModel getUsuarioLogado() {
        return usuarioLogado;
    }    
}
