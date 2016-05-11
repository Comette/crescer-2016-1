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
    // erros: metodo retornara um array e não um int; 
    // metodo recebia uma variavel não utilizada e utilizava uma variavel não instanciada;
    // metodo criava um array desnecessário
    public int obterMaiorMultiploDeTresAte(int numero){
        int maiorMultiplo=0;
        for (int i = numero; i >= 3; i--){
            if(i%3==0){
                maiorMultiplo = i;
                break;
            }
        }
        return maiorMultiplo;
    }
    //erros: metodo recebia uma variavel não utilizada e utilizava uma variavel não instanciada;
    // instanciava arrayList<> com atribuição da primeira posicao desnecessariamente;
    // metodo tinha um break antes de adicionar o numero no array de retorno;
    public ArrayList<Integer> obterMultiplosDeTresAte(int numero){
        ArrayList<Integer> multiplos = new ArrayList<>();
        for (int i = 1; i <= numero; i++){
            if(i%3==0){
                multiplos.add(i);
            }
        }
        return multiplos;
    }
}
