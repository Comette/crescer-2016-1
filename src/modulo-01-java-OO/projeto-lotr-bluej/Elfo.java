
public class Elfo
{ 
    private String nome;
    private int experiencia;
    private int flechas = 42;  
    private Inventario inventario = new Inventario();

    public Elfo(String nome)
    {
        this.nome = nome;        
    }
    public Elfo (String nome, int flechas)
    {
        this(nome);
        this.flechas = flechas;
    }    
    public void atirarFlecha(Dwarf anao)
    {
        if (flechas > 0){
            flechas--;
            experiencia++;
            anao.levaFlechada();
        }
    }   
    public String getNome(){
        return nome;
    }
    public int getExperiencia(){
        return experiencia;
    }
    public int getFlechas(){
        return flechas;
    }
    public String toString(){
        boolean flechaSingular = Math.abs(flechas) == 1;
        return String.format("%s possui %d %s e %d níveis de experiência.", nome, flechas, flechaSingular ? "flecha" : "flechas", experiencia);
    }
}
