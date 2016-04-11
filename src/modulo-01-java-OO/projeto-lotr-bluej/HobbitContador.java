import java.util.*;
public class HobbitContador
{
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> array){        
        int soma = 0;
        ArrayList<Integer> arrayMMC = new ArrayList<>();
        ArrayList<Integer> arrayProdutos = new ArrayList<>();
        ArrayList<Integer> arrayDiferencas = new ArrayList<>();
        for(int i = 0; i< array.size(); i++){            
            arrayMMC.add(calculaMMC(array.get(i).get(0), array.get(i).get(1)));
            arrayProdutos.add(array.get(i).get(0)*array.get(i).get(1));   
            arrayDiferencas.add(arrayProdutos.get(i) - arrayMMC.get(i));
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
