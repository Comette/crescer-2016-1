public class Personagem
{
    protected String nome;
    protected int experiencia;
    protected Inventario bolsa = new Inventario();
    public Personagem(String nome){
        this.nome = nome;
    }    
    public String getNome(){
        return this.nome;
    }
    public int getExperiencia(){
        return experiencia;
    }
    public void ganhaItem(Item item){
        bolsa.adicionaItem(item);
    }
    public void perdeItem(Item item){
        bolsa.removeItem(item);
    }
    public boolean possuiItem(Item item){
        return bolsa.verificaItem(item);
    }
    public Inventario getInventario(){
        return bolsa;
    }
}
