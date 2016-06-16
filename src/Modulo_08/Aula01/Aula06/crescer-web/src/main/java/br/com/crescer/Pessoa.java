package br.com.crescer;

public class Pessoa {

    private int id = 0;
    private String nome;
    private Integer idade;
    private String profissao;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, Integer idade, String profissao) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
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
