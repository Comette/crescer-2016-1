import java.util.*;
public class EstrategiaNoturnosPorUltimo implements Estrategia
{
    private ExercitoDeElfos exercito = new ExercitoDeElfos();
    private Map<String, Elfo> ordemUltimoAtaque = new HashMap<String, Elfo>();    
    public void atacaHordaDwarves(ArrayList<Elfo> elfosQueAtacam, ArrayList<Dwarf> hordaDwarves){ 
        for(Elfo elfo : elfosQueAtacam){
            if(elfo.status != Status.VIVO){
                elfosQueAtacam.remove(elfo);
            }
        }
        elfosQueAtacam = organizaLista(elfosQueAtacam);
        for(Elfo elfo: elfosQueAtacam){            
            for(Dwarf dwarf : hordaDwarves){
                elfo.atirarFlecha(dwarf);
                ordemUltimoAtaque.put(elfo.getNome(), elfo);
            }
        }
    }
    public ArrayList<Elfo> getOrdemUltimoAtaque(){
        ArrayList<Elfo> retorno = new ArrayList<Elfo>();
        for(Elfo elfo : ordemUltimoAtaque.values()){
            retorno.add(elfo);
        }
        return retorno;
    }
    private ArrayList<Elfo> organizaLista(ArrayList<Elfo> lista){
        ArrayList<Elfo> listaOrganizada = new ArrayList<Elfo>();
        for(Elfo elfo : lista){
            if (!(elfo instanceof ElfoNoturno)){
                listaOrganizada.add(0, elfo);
            }else{
                listaOrganizada.add(elfo);
            }
        }
        return listaOrganizada;
    }
}
