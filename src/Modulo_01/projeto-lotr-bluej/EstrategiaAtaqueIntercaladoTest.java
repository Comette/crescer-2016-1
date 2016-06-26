import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class EstrategiaAtaqueIntercaladoTest
{
    @Test
    public void exercitoCom3ElfosVerdesE3ElfosNoturnos(){
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
    @Test
    public void exercitoCom2ElfosVerdesE3ElfosNoturnos(){
        //Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(new ElfoVerde("EF1"));
        exercito.alistaElfo(new ElfoVerde("EF2"));        
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
        assertTrue(exercito.getOrdemUltimoAtaque().isEmpty());    
    }
    @Test
    public void exercitoComElfosMortosFicando2VerdesE1Noturno(){
        //Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(new ElfoVerde("EF1"));
        exercito.alistaElfo(new ElfoVerde("EF2"));        
        exercito.alistaElfo(new ElfoNoturno("EN1"));               
        Elfo en3 = new ElfoNoturno("EN3", 100);        
        for(int i = 0; i < 91; i++){
            en3.atirarFlecha(new Dwarf("Inutil"));
        }
        exercito.alistaElfo(en3);
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
        assertTrue(exercito.getOrdemUltimoAtaque().isEmpty());    
    }
    @Test
    public void exercitoComElfosMortosFicando2VerdesE2Noturnos(){
        //Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(new ElfoVerde("EF1"));
        exercito.alistaElfo(new ElfoVerde("EF2"));        
        exercito.alistaElfo(new ElfoNoturno("EN1")); 
        exercito.alistaElfo(new ElfoNoturno("EN2"));
        Elfo en3 = new ElfoNoturno("EN3", 100);        
        for(int i = 0; i < 91; i++){
            en3.atirarFlecha(new Dwarf("Inutil"));
        }
        exercito.alistaElfo(en3);
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
        }else{
            assertTrue(exercito.getOrdemUltimoAtaque().get(0) instanceof ElfoNoturno);
            assertTrue(exercito.getOrdemUltimoAtaque().get(1) instanceof ElfoVerde);
            assertTrue(exercito.getOrdemUltimoAtaque().get(2) instanceof ElfoNoturno);
            assertTrue(exercito.getOrdemUltimoAtaque().get(3) instanceof ElfoVerde);
        }    
    }    
}
