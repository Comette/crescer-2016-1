package br.com.rede.pre.mvc.model;

import br.com.rede.pre.dominio.model.Usuario;

public class UsuarioLogadoModel {
    private long id;
    private String nome;
    private String email;
    private String imgPerfil;

    public UsuarioLogadoModel(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    
    public UsuarioLogadoModel(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.imgPerfil = usuario.getImgPerfil();
    }

    public UsuarioLogadoModel() {
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
