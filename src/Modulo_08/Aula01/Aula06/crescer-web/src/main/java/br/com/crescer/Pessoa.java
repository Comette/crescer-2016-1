package br.com.crescer;

public class Pessoa {
    private String nome;
    private String idade;
    private String profissao;  
    
    public Pessoa(){}
    
    public Pessoa(String nome, String idade, String profissao) {
        this.nome = nome;
        this.idade = idade;        
        this.profissao = profissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    @Override
    public String toString() {
        return nome + ", " + idade + " anos, " + profissao;
    }
    
    
}
