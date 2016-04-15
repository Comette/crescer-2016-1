import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class EstrategiaAtaqueIntercaladoTest
{
    @Test
    public void exercitoCom3ElfosVerdesE3ElfosNoturnosAtacam6Dwarves(){
        //Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(new ElfoVerde("EF1"));
        exercito.alistaElfo(new ElfoVerde("EF2"));
        exercito.alistaElfo(new ElfoVerde("EF3"));
        exercito.alistaElfo(new ElfoNoturno("EN1"));
        exercito.alistaElfo(new ElfoNoturno("EN2"));
        exercito.alistaElfo(new ElfoNoturno("EN3"));
        ArrayList<Dwarf> hordaDwarves = new ArrayList<Dwarf>();
        hordaDwarves.add(new Dwarf("D1"));
        hordaDwarves.add(new Dwarf("D2"));
        hordaDwarves.add(new Dwarf("D3"));
        hordaDwarves.add(new Dwarf("D4"));
        hordaDwarves.add(new Dwarf("D5"));
        hordaDwarves.add(new Dwarf("D6"));
        Estrategia estrategia = new EstrategiaAtaqueIntercalado(); 
        exercito.mudarEstrategia(estrategia);
        //Act
        exercito.atacar(hordaDwarves);
        //Assert
        if(exercito.getOrdemUltimoAtaque().get(0) instanceof ElfoVerde){
            assertTrue(exercito.getOrdemUltimoAtaque().get(0) instanceof ElfoVerde);
            assertTrue(exercito.getOrdemUltimoAtaque().get(1) instanceof ElfoNoturno);
            assertTrue(exercito.getOrdemUltimoAtaque().get(2) instanceof ElfoVerde);
            assertTrue(exercito.getOrdemUltimoAtaque().get(3) instanceof ElfoNoturno);
            assertTrue(exercito.getOrdemUltimoAtaque().get(4) instanceof ElfoVerde);
            assertTrue(exercito.getOrdemUltimoAtaque().get(5) instanceof ElfoNoturno);
        }else{
            assertTrue(exercito.getOrdemUltimoAtaque().get(0) instanceof ElfoNoturno);
            assertTrue(exercito.getOrdemUltimoAtaque().get(1) instanceof ElfoVerde);
            assertTrue(exercito.getOrdemUltimoAtaque().get(2) instanceof ElfoNoturno);
            assertTrue(exercito.getOrdemUltimoAtaque().get(3) instanceof ElfoVerde);
            assertTrue(exercito.getOrdemUltimoAtaque().get(4) instanceof ElfoNoturno);
            assertTrue(exercito.getOrdemUltimoAtaque().get(5) instanceof ElfoVerde);
        }        
    }
}
