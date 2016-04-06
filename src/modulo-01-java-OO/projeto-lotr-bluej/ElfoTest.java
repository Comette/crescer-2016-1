import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void criaElfoComNomeFlechasDefault(){
        Elfo elfo = new Elfo("Legolas");
        boolean resultado = (elfo.getNome() == "Legolas" && elfo.getFlechas() == 42);
        assertTrue(resultado);
    }
    @Test
    public void criaElfoComNomeComFlechas(){
        Elfo elfo = new Elfo("Legolas", 20);
        boolean resultado = (elfo.getNome() == "Legolas" && elfo.getFlechas() == 20);
        assertTrue(resultado);
    }
    @Test
    public void testaAtirarFlechaPerderFlechaGanhaExperiencia(){
        Elfo elfo = new Elfo("Legolas");
        Dwarf anao = new Dwarf("Sofredor");
        elfo.atirarFlecha(anao);
        boolean resultado = (elfo.getFlechas() == 41 && elfo.getExperiencia() == 1 && anao.getVida() == 100);
        assertTrue(resultado);
    }
    @Test
    public void testaToString(){
        Elfo elfo = new Elfo("Legolas");
        String correta = "Legolas possui 42 flechas e 0 niveis de experiencia.";                
        assertTrue(correta.equals(elfo.toString()));        
    }
}
