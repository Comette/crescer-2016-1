import java.util.*;
public class DicionarioSindarin
{
    public static void main(String[] args){
        HashMap<String, String> dicionarioSindarin = new HashMap<>();
        //Inserir chave-valor
        dicionarioSindarin.put("terra", "amar");
        dicionarioSindarin.put("fogo", "naur"); 
        dicionarioSindarin.put("vento", "gwaew");
        dicionarioSindarin.put("água", "nen");
        dicionarioSindarin.put("coração", "gûr");
        //obter um valor a partir de uma chave
        String terraEmSindarin = dicionarioSindarin.get("terra");
        //sobrepor o valor de uma determinada chave
        dicionarioSindarin.put("água", "nîn");        
        // Remover chave-valor
        dicionarioSindarin.remove("água");
        //Está vazio?
        boolean estaVazio = dicionarioSindarin.isEmpty();
        // Tamanho
        int tamanho = dicionarioSindarin.size();
        // Contém chave?
        boolean contemChaveAgua = dicionarioSindarin.containsKey("água");
        // Contem valor?
        boolean contemValorNaur = dicionarioSindarin.containsValue("naur");
        
    }
}
