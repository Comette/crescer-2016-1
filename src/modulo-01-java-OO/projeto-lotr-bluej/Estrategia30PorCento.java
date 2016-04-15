import java.util.*;
public class Estrategia30PorCento implements Estrategia
{
    private ExercitoDeElfos exercito = new ExercitoDeElfos();
    private Map<String, Elfo> ordemUltimoAtaque = new HashMap<String, Elfo>();    
    public void atacaHordaDwarves(ArrayList<Elfo> elfosQueAtacam, ArrayList<Dwarf> hordaDwarves){
        for(Elfo elfo : elfosQueAtacam){
            if(elfo.status != Status.VIVO){
                elfosQueAtacam.remove(elfo);
            }
        }
        int intencoesAtaque = elfosQueAtacam.size() * hordaDwarves.size();
        int limiteElfosNoturnos = (int)(intencoesAtaque * 0.3);
        for(Elfo elfo : elfosQueAtacam){
            for(Dwarf dwarf : hordaDwarves){
                if((elfo instanceof ElfoNoturno) && (limiteElfosNoturnos > 0)){
                    elfo.atirarFlecha(dwarf);
                    limiteElfosNoturnos--;
                    ordemUltimoAtaque.put(elfo.getNome(), elfo);
                }else if (!(elfo instanceof ElfoNoturno)){
                    elfo.atirarFlecha(dwarf);
                    ordemUltimoAtaque.put(elfo.getNome(), elfo);
                }
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
}
