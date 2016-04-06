
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
}
