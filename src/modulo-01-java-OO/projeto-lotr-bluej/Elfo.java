
public class Elfo
{ 
    private String nome;
    private int experiencia;
    private int flechas = 42;    

    public Elfo(String name)
    {
        nome = name;        
    }
    public Elfo (String name, int arrows)
    {
        nome = name;
        flechas = arrows;
    }    
    public void atirarFlecha(Dwarf anao)
    {
        if (flechas > 0){
            flechas--;
            experiencia++;
            anao.levaFlechada();
        }
    }    
}
