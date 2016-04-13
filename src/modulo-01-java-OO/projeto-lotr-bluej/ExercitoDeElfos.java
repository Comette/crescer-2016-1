import java.util.*;
public class ExercitoDeElfos
{
    HashMap<String, Elfo> exercitoDeElfos = new HashMap<>();  
    HashMap<Status, ArrayList> exercitoDeElfosAgrupados = new HashMap<>();
    ArrayList<Elfo> elfosVivos = new ArrayList<>();
    public void alistaElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            String key = elfo.getNome();
            exercitoDeElfos.put(key, elfo);
        }
    }
    public Elfo buscaElfoPeloNome(String nome){
        return exercitoDeElfos.get(nome);    
    }
    /*public void agrupaElfosPorStatus(){
        for(Elfo elfo : exercitoDeElfos.valueSet()){
            if(elfo.getStatus == Status.VIVO){    
                elfosVivos.add(elfo);                
            }else if(elfo.getStatus == Status.MORTO){
                elfosMortos
        }
        exercitoDeElffosAgrupado.put(Status.VIVO, elfosVivos);
    }*/
        
}
