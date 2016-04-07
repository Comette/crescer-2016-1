
public class Elfo
{ 
    private String nome;
    private int experiencia;
    private int flechas = 42;    

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
        return (nome + " possui " + flechas + " flechas e " + experiencia + " niveis de experiencia.");
    }
}
