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
        if (pessoa.getId() > 0) {
            String indexNoBanco=null;
            for(Pessoa pes : RepositorioStatico.getRepositorio().getPessoas()){
                if(pes.getId()==pessoa.getId()){
                    indexNoBanco = String.valueOf(RepositorioStatico.getRepositorio().getPessoas().indexOf(pes));
                    break;
                }
            }
            if(indexNoBanco!=null){
                RepositorioStatico.getRepositorio().getPessoas().set(Integer.parseInt(indexNoBanco), pessoa);
            }else{
                pessoa.setId(RepositorioStatico.getRepositorio().getPessoas().get(RepositorioStatico.getRepositorio().getPessoas().size()-1).getId() + 1);
                RepositorioStatico.getRepositorio().getPessoas().add(pessoa);
            }
        } else {
            pessoa.setId(RepositorioStatico.getRepositorio().getPessoas().get(RepositorioStatico.getRepositorio().getPessoas().size()-1).getId() + 1);
            RepositorioStatico.getRepositorio().getPessoas().add(pessoa);
        }
    }

    public void deletePessoa(Pessoa pessoa) {
        int indexExcluir = RepositorioStatico.getRepositorio().getPessoas().indexOf(pessoa);
        RepositorioStatico.getRepositorio().getPessoas().remove(indexExcluir);
    }
}
