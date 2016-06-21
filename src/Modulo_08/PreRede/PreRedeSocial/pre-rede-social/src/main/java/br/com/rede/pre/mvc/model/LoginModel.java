package br.com.rede.pre.mvc.model;

public class LoginModel {
    private String email;
    private String senha;

    public LoginModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
