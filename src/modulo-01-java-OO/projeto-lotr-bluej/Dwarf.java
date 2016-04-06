public class Dwarf
{
    private int vida = 110;
    private String nome;
    public Dwarf(String nome)
    {        
        this.nome = nome;
    }
    public void levaFlechada(){
        if (vida >= 10){
            vida -= 10;
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
}
