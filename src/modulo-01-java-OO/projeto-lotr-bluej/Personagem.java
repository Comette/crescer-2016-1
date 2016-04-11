public class Personagem
{
    protected String nome;
    protected int experiencia;
    protected Inventario bolsa = new Inventario();
    protected Status status = Status.VIVO;
    protected double vida = 110;
    public Personagem(String nome){
        this.nome = nome;
    }    
    public String getNome(){
        return this.nome;
    }
    public double getVida(){
        return vida;
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
    public Status getStatus(){
        return status;
    }
}
