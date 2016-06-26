import java.util.*;
public class Estrategia30PorCento implements Estrategia
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
        int intencoesAtaque = elfosQueAtacam.size() * hordaDwarves.size();
        int limiteElfosNoturnos = (int)(intencoesAtaque * 0.3);
        for(Elfo elfo : elfosQueAtacam){
            for(Dwarf dwarf : hordaDwarves){
                if((elfo instanceof ElfoNoturno) && (limiteElfosNoturnos > 0)){
                    elfo.atirarFlecha(dwarf);
                    limiteElfosNoturnos--;                    
                }else if (!(elfo instanceof ElfoNoturno)){
                    elfo.atirarFlecha(dwarf);                    
                }
            } 
            ordemUltimoAtaque.add(elfo);
        }
    }
    public ArrayList<Elfo> getOrdemUltimoAtaque(){        
        return ordemUltimoAtaque;
    }
}
