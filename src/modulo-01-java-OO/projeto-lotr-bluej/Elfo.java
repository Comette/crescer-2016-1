
public class Elfo extends Personagem
{ 
    protected int flechas = 42;  
    public Elfo(String nome)
    {
        super(nome); 
        vida = 100;
    }
    public Elfo (String nome, int flechas)
    {
        super(nome);
        this.flechas = flechas;
        vida = 100;
    }    
    public void atirarFlecha(Dwarf anao)
    {
        if (flechas > 0){
            flechas--;
            experiencia++;
            anao.levaFlechada();
        }
    }    
    public int getFlechas(){
        return flechas;
    }
    public String toString(){
        boolean flechaSingular = Math.abs(flechas) == 1;
        return String.format("%s possui %d %s e %d níveis de experiência.", nome, flechas, flechaSingular ? "flecha" : "flechas", experiencia);
    }
}
