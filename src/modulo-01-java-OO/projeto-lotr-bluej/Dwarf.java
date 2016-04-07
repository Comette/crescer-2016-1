public class Dwarf
{
    private int vida = 110;
    private String nome;
    private Status status = Status.VIVO;
    
    public Dwarf(String nome)
    {        
        this.nome = nome;
    }
    public void levaFlechada(){
        vida -= 10;
      if(vida == 0){
            status = Status.MORTO;
        }
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public int getVida(){
        return vida;
    }
    public Status getStatus(){
        return status;
    }
}
