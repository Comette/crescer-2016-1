import java.util.*;
public class Inventario
{
    private ArrayList<Item> itens = new ArrayList<>();
    public Inventario(){
    }
    public void adicionaItem(Item item){
        itens.add(item);
    }
    public void removeItem(Item item){
        int posicao = itens.indexOf(item);
        itens.remove(posicao);
    }
    public int getQuantidadeItens(){
        return itens.size();
    }
    public boolean verificaItem(Item item){
        return itens.contains(item);
    }   
    public String getDescricoesItens(){
        String descricoes = "";        
        for(int i = 0; i < itens.size(); i++){
            if(i == (itens.size() - 1)){
                descricoes += itens.get(i).getDescricao();
            }else{
                descricoes += itens.get(i).getDescricao() + ", ";
            }                
        }
        return descricoes;
    }
}
