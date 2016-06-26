package br.com.crescer;

import java.util.ArrayList;
import java.util.List;


public class RepositorioStatico {
    private static final RepositorioStatico REPOSITORIO = new RepositorioStatico();
    private RepositorioStatico() {  
        pessoas.add(new Pessoa(1, "Joao", 20, "Programador"));
        pessoas.add(new Pessoa(2, "pedro", 30, "testador"));
        pessoas.add(new Pessoa(3, "tiago", 23, "DBA"));
    }    
    public static RepositorioStatico getRepositorio() {
        return REPOSITORIO;
    }
    
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }    
}
