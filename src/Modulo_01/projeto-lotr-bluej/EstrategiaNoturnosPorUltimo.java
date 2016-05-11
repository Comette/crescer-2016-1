import java.util.*;
public class EstrategiaNoturnosPorUltimo implements Estrategia
{
    private ExercitoDeElfos exercito = new ExercitoDeElfos();
    private ArrayList<Elfo> ordemUltimoAtaque = new ArrayList<Elfo>();    
    public void atacaHordaDwarves(ArrayList<Elfo> elfosQueAtacam, ArrayList<Dwarf> hordaDwarves){ 
        for(int i = 0; i < elfosQueAtacam.size(); i++){
            if(elfosQueAtacam.get(i).status != Status.VIVO){
                elfosQueAtacam.remove(elfosQueAtacam.get(i));
                int proximo = i + 1;
                if(proximo < elfosQueAtacam.size()){
                    continue;
                }else{
                    break;
                }
            }                        
        }
        elfosQueAtacam = organizaLista(elfosQueAtacam);
        for(Elfo elfo: elfosQueAtacam){            
            for(Dwarf dwarf : hordaDwarves){
                elfo.atirarFlecha(dwarf);                
            }
            ordemUltimoAtaque.add(elfo);
        }
    }
    public ArrayList<Elfo> getOrdemUltimoAtaque(){
        return ordemUltimoAtaque;
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
