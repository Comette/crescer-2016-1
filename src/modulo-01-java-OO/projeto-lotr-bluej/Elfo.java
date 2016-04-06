
public class Elfo
{
 
    private String nome;
    private int experiencia;
    private int flechas = 42;
    private boolean acertar;

    public Elfo(String name)
    {
        nome = name;        
    }
    public Elfo (String name, int arrows)
    {
        nome = name;
        flechas = arrows;
    }    
    public void atirarFlecha()
    {
        if (flechas > 0){
            flechas--;
            experiencia++;
        }
    }
    public void atirarFlechaRefactory()
    {
        flechas--;
        if(acertar)
        {            
            experiencia++;            
        }
    }
    public void cheatMira()
    {
        if(acertar){
            acertar = false;
        }else{
            acertar = true;
        }
    }
    public void atirarEmDwarf(Dwarf anao){
        flechas--;
        anao.levaFlechada();
    }
}
