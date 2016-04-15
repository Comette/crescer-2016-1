import java.util.*;
public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercitoDeElfos = new HashMap<>();  
    private HashMap<Status, ArrayList<Elfo>> exercitoDeElfosAgrupados = new HashMap<>();    
    public void alistaElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            String key = elfo.getNome();
            exercitoDeElfos.put(key, elfo);
        }
    }
    public Elfo buscaElfoPeloNome(String nome){
        return exercitoDeElfos.get(nome);    
    }
    public void agrupaElfosPorStatus(){
        exercitoDeElfosAgrupados.clear();
        for(Elfo elfo : exercitoDeElfos.values()){
            if(!exercitoDeElfosAgrupados.containsKey(elfo.getStatus())){
                exercitoDeElfosAgrupados.put(elfo.getStatus(), new ArrayList<Elfo>());
            }
            exercitoDeElfosAgrupados.get(elfo.getStatus()).add(elfo);
        }
    } 
    public HashMap getExercitoAgrupado(){
        return exercitoDeElfosAgrupados;
    }
    public ArrayList<Elfo> buscarElfoPorStatus (Status status){
        return exercitoDeElfosAgrupados.get(status);
    }
    
}










