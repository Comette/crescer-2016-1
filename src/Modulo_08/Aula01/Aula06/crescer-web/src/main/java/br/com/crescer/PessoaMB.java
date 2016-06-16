package br.com.crescer;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "pessoa")
@RequestScoped
public class PessoaMB implements Serializable{

    private Pessoa pessoa;    

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
        
    @PostConstruct
    public void init(){ 
        this.pessoa = new Pessoa();
    }

    
}
