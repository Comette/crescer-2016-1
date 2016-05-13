import java.util.*;
public class DicionarioSindarin
{
    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Bem vindo ao tradutor Sindarin! Escolha a Linguagem: ");
        System.out.println("[P]ortugues - [I]ngles");
        String idioma = scanner.nextLine();
        TradutorSindarin tradutor = criarTradutor(idioma);
        System.out.println("Digite a palavre a ser traduzida: ");
        String palavra = scanner.nextLine();
        System.out.println("A palavra " + palavra + " significa: " + tradutor.traduzir(palavra));
    }
    
    private static TradutorSindarin criarTradutor(String idioma) {
        switch (idioma.toLowerCase()) {
            case "i":
                return new SindarinParaIngles();
            default:
                return new SindarinParaPortugues();
        }
    }
   
    public static void rodarExemploHashMap(){
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
