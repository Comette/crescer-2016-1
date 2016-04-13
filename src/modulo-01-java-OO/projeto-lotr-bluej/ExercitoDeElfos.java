import java.util.*;
public class ExercitoDeElfos
{
    HashMap<String, Elfo> exercitoDeElfos = new HashMap<>();    
    public void alistaElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            String key = elfo.getNome();
            exercitoDeElfos.put(key, elfo);
        }
    }
    public Elfo buscaElfoPeloNome(String nome){
        return exercitoDeElfos.get(nome);    
    }
}
