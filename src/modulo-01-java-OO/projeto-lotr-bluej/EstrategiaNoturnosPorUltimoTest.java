import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class EstrategiaNoturnosPorUltimoTest
{
    @Test
    public void exercitoComElfoNoturnoAlistadoPrimeiro(){
        //Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(new ElfoNoturno("EN1"));
        exercito.alistaElfo(new ElfoNoturno("EN2"));
        exercito.alistaElfo(new ElfoVerde("EF1"));
        exercito.alistaElfo(new ElfoVerde("EF2"));
        exercito.alistaElfo(new ElfoVerde("EF3")); 
        Estrategia estrategia = new EstrategiaNoturnosPorUltimo(); 
        exercito.mudarEstrategia(estrategia);
        
        ArrayList<Dwarf> hordaDwarves = new ArrayList<Dwarf>();
        hordaDwarves.add(new Dwarf("D1"));
        hordaDwarves.add(new Dwarf("D2"));
        hordaDwarves.add(new Dwarf("D3"));
        hordaDwarves.add(new Dwarf("D4"));
        hordaDwarves.add(new Dwarf("D5"));
        hordaDwarves.add(new Dwarf("D6"));
              
        //Act        
        exercito.atacar(hordaDwarves);
        //Assert
        assertTrue(exercito.getOrdemUltimoAtaque().get(0) instanceof ElfoVerde);
        assertTrue(exercito.getOrdemUltimoAtaque().get(1) instanceof ElfoVerde);
        assertTrue(exercito.getOrdemUltimoAtaque().get(2) instanceof ElfoVerde);
        assertTrue(exercito.getOrdemUltimoAtaque().get(3) instanceof ElfoNoturno);
        assertTrue(exercito.getOrdemUltimoAtaque().get(4) instanceof ElfoNoturno);
    }
}
