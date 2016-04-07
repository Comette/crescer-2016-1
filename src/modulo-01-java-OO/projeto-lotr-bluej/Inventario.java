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
}
