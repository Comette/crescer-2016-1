import java.util.*;
public class HobbitContador
{
    public HobbitContador(){
        
    }
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> array){
        int a = 0;
        int b = 0;
        int soma = 0;
        ArrayList<Integer> arrayMMC = new ArrayList<>();
        ArrayList<Integer> arrayProdutos = new ArrayList<>();
        ArrayList<Integer> arrayDiferencas = new ArrayList<>();
        for(int i = 0; i< array.size(); i++){
            a = array.get(i).get(0);
            b = array.get(i).get(1);
            arrayMMC.add(calculaMMC(a, b));
            arrayProdutos.add(a*b);            
        }
        for(int i = 0; i < array.size(); i++){
            arrayDiferencas.add(arrayProdutos.get(i) - arrayMMC.get(i));
        }
        for(int i = 0; i < array.size(); i++){
            soma += arrayDiferencas.get(i);
        }
        return soma;        
    }
    private int calculaMMC(int a, int b){
        int mmc = 0;
        for (int i = a; i <= a*b; i++){
            if(i%a==0 && i%b==0){
                mmc = i;
                break;
            }
        }
        return mmc;    
    }
}
