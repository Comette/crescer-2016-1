import java.util.*;
public class EstrategiaAtaqueIntercalado implements Estrategia
{
    private ExercitoDeElfos exercito = new ExercitoDeElfos();
    private Map<String, Elfo> ordemUltimoAtaque = new HashMap<String, Elfo>();  
    private ArrayList<Elfo> elfosEmOrdem = new ArrayList<Elfo>();
    public void atacaHordaDwarves(ArrayList<Elfo> elfosQueAtacam, ArrayList<Dwarf> hordaDwarves){
        int elfosVerdes=0;
        int elfosNoturnos=0;    
                
        for(Elfo elfo : elfosQueAtacam){
            if(elfo.status != Status.VIVO){
                elfosQueAtacam.remove(elfo);
                continue;
            }
            if(elfo instanceof ElfoVerde){
                elfosVerdes++;
            }else{
                elfosNoturnos++;
            }            
        }
        boolean podeAtacar = elfosVerdes == elfosNoturnos;
        if(podeAtacar){
            ordenaElfos(elfosQueAtacam);
            for(Elfo elfo: elfosEmOrdem){            
                for(Dwarf dwarf : hordaDwarves){
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
