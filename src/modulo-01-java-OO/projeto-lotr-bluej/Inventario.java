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
    public void adiciona1000Unidades(){
        for(int i = 0; i < itens.size(); i++){
            itens.get(i).aumenta1000();
        }
    }
    public void multiplica1000Unidades(){
        for(int i = 0; i < itens.size(); i++){
            itens.get(i).multiplica1000();
        }
    }
    public Item itemMaisPopular(){
        Item maisPopular = new Item(0, "Empty");
        for(int i = 0; i < itens.size(); i++){
            if(itens.get(i).getQuantidade() > maisPopular.getQuantidade()){
                maisPopular = itens.get(i);
            }
        }
        return maisPopular;
    }
    public void ordenarItens(){
        ArrayList<Item> listaOrdenada = new ArrayList<>();       
        for (int i = 0; i < itens.size(); i++){
            if(listaOrdenada.isEmpty() || itens.get(i).getQuantidade() <= listaOrdenada.get(0).getQuantidade()){
                listaOrdenada.add(0, itens.get(i));
            }else{
                for(int j = 1; j < listaOrdenada.size(); j++){
                    if(itens.get(i).getQuantidade() <= listaOrdenada.get(j).getQuantidade()){
                        listaOrdenada.add(j, itens.get(i));
                        break;
                    }
                }
            }
        }
        itens = listaOrdenada;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
            
}
