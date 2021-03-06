import java.util.*;
public class Inventario
{
    private ArrayList<Item> itens = new ArrayList<>();    
    public void adicionaItem(Item item){
        itens.add(item);
    }
    public void removeItem(Item item){
        itens.remove(item);
    }
    public int getQuantidadeItens(){
        return itens.size();
    }
    public boolean verificaItem(Item item){
        return itens.contains(item);
    }   
    public Item getItemNoInventario(int index){
        return itens.get(index);
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
        Item maisPopular = new Item(0, null);
        for(int i = 0; i < itens.size(); i++){
            if(itens.get(i).getQuantidade() > maisPopular.getQuantidade()){
                maisPopular = itens.get(i);
            }
        }
        return maisPopular;
    }
    public void ordenarItens(){
        Collections.sort(this.itens, new Comparator<Item>(){
            public int compare(Item item1, Item item2) {
                return Integer.compare(item1.getQuantidade(), item2.getQuantidade());
            }
        });       
    }    
    public boolean equals(Object obj){
        Inventario outro = (Inventario)obj;
        boolean saoIguais=false;
        if(this.itens.isEmpty() && outro.itens.isEmpty()){
            saoIguais = true;
        }else if(this.itens.isEmpty() && !outro.itens.isEmpty() || !this.itens.isEmpty() && outro.itens.isEmpty()){
            saoIguais = false;
        }else{
            saoIguais = this.itens.equals(outro.itens);
        }
        return saoIguais;
    }
}









