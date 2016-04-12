import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void testaElfoGanhaTriploExperienciaAoAtirarFlecha(){
        Elfo elfo = new ElfoNoturno("Legolas da Nigth");
        Dwarf anao = new IrishDwarf("Feito pra Morrer");
        elfo.atirarFlecha(anao);
        assertEquals(3, elfo.getExperiencia());
    }
    @Test
    public void testaElfoPerde5PorCentoDeVidaAoAtirarFlecha(){
        Elfo elfo = new ElfoNoturno("Legolas da Nigth");
        Dwarf anao = new IrishDwarf("Feito pra Morrer");
        elfo.atirarFlecha(anao);        
        assertEquals(95, elfo.getVida(), 0.0001);
    }
    @Test
    public void testaElfoMorreAoAtirar150Vezes(){
        Elfo elfo = new ElfoNoturno("Legolas da Nigth", 150);
        Dwarf anao = new IrishDwarf("Feito pra Morrer");
        for (int i = 0; i< 150; i++){
            elfo.atirarFlecha(anao);  
        }
        assertEquals(Status.MORTO, elfo.getStatus());
    }
    @Test
    public void testaElfoMorreAoAtirar89Vezes(){
        Elfo elfo = new ElfoNoturno("Legolas da Nigth", 150);
        Dwarf anao = new IrishDwarf("Feito pra Morrer");
        for (int i = 0; i< 89; i++){
            elfo.atirarFlecha(anao);  
        }
        assertEquals(Status.VIVO, elfo.getStatus());
    }
}
