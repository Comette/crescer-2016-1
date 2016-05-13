import java.util.*;
public class EstrategiaAtaqueIntercalado implements Estrategia
{
    private ExercitoDeElfos exercito = new ExercitoDeElfos();
    private ArrayList<Elfo> ordemUltimoAtaque = new ArrayList<Elfo>();  
    private ArrayList<Elfo> elfosEmOrdem = new ArrayList<Elfo>();
    public void atacaHordaDwarves(ArrayList<Elfo> elfosQueAtacam, ArrayList<Dwarf> hordaDwarves){
        int elfosVerdes=0;
        int elfosNoturnos=0;               
        //Elfo elfo : elfosQueAtacam)
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
            if(elfosQueAtacam.get(i) instanceof ElfoVerde){
                elfosVerdes++;
            }else{
                elfosNoturnos++;
            }            
        }
        boolean podeAtacar = elfosVerdes == elfosNoturnos;
        if(podeAtacar){
            ordenaElfos(elfosQueAtacam);
            for(int i = 0; i < elfosEmOrdem.size(); i++){            
                for(Dwarf dwarf : hordaDwarves){
                    elfosEmOrdem.get(i).atirarFlecha(dwarf);                    
                }
                ordemUltimoAtaque.add(elfosEmOrdem.get(i));
            }
        }
    }
    public ArrayList<Elfo> getOrdemUltimoAtaque(){        
        return ordemUltimoAtaque;
    }
    private void ordenaElfos(ArrayList<Elfo> elfosQueAtacam){
        int quantidadeElfos=elfosQueAtacam.size();
        Elfo ultimo = null;
        do{
            for(Elfo elfo : elfosQueAtacam){
                if((!elfosEmOrdem.contains(elfo)) && ((ultimo == null) || (elfo.getClass() != ultimo.getClass()))){
                    elfosEmOrdem.add(elfo);
                    ultimo = elfo;
                    quantidadeElfos--;
                }
            }
        }while(quantidadeElfos>0);        
    }     
}
