package br.com.crescer;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "repositorio")
@ViewScoped
public class RepositorioMB implements Serializable {

    public List<Pessoa> getPessoas() {
        return RepositorioStatico.getRepositorio().getPessoas();
    }

    public void setPessoas(List<Pessoa> pessoas) {
        RepositorioStatico.getRepositorio().getPessoas();
    }

    public void addPessoa(Pessoa pessoa) {
        RepositorioStatico.getRepositorio().getPessoas().add(pessoa);
    }

    public void deletePessoa(Pessoa pessoa) {
        int indexExcluir = RepositorioStatico.getRepositorio().getPessoas().indexOf(pessoa);
        RepositorioStatico.getRepositorio().getPessoas().remove(indexExcluir);
    }
}
