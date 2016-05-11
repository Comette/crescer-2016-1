import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class Estrategia30PorCentoTest
{
    @Test
    public void exercitoCom3ElfosVerdesE2ElfosNoturnosAtacam6Dwarves(){
        //Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(new ElfoVerde("EF1"));
        exercito.alistaElfo(new ElfoVerde("EF2"));
        exercito.alistaElfo(new ElfoVerde("EF3"));
        exercito.alistaElfo(new ElfoNoturno("EN1"));
        exercito.alistaElfo(new ElfoNoturno("EN2"));
        ArrayList<Dwarf> hordaDwarves = new ArrayList<Dwarf>();
        hordaDwarves.add(new Dwarf("D1"));
        hordaDwarves.add(new Dwarf("D2"));
        hordaDwarves.add(new Dwarf("D3"));
        hordaDwarves.add(new Dwarf("D4"));
        hordaDwarves.add(new Dwarf("D5"));
        hordaDwarves.add(new Dwarf("D6"));
        Estrategia estrategia = new Estrategia30PorCento();
        
        ArrayList<Elfo> esperado = new ArrayList<Elfo>();
        ElfoVerde ef1 = new ElfoVerde("EF1");
        ElfoVerde ef2 = new ElfoVerde("EF2");
        ElfoVerde ef3 = new ElfoVerde("EF3");
        ElfoNoturno en1 = new ElfoNoturno("EN1");
        ElfoNoturno en2 = new ElfoNoturno("EN2");
        ElfoNoturno en1C = new ElfoNoturno("EN1");
        ElfoNoturno en2C = new ElfoNoturno("EN2");
        for (int i = 0; i < 6; i++){
            ef1.atirarFlecha(new Dwarf("Morri"));
            ef2.atirarFlecha(new Dwarf("Morri"));
            ef3.atirarFlecha(new Dwarf("Morri"));
            en1.atirarFlecha(new Dwarf("Morri"));
            en2C.atirarFlecha(new Dwarf("Morri"));
        }
        for (int i = 0; i < 3; i++){
            en2.atirarFlecha(new Dwarf("MorriMenos"));
            en1C.atirarFlecha(new Dwarf("MorriMenos"));
        }
        //Act
        exercito.atacar(hordaDwarves);
        //Assert
        assertTrue(exercito.getOrdemUltimoAtaque().contains(ef1));
        assertTrue(exercito.getOrdemUltimoAtaque().contains(ef2));
        assertTrue(exercito.getOrdemUltimoAtaque().contains(ef3));
        assertTrue((exercito.getOrdemUltimoAtaque().contains(en1)) &&
                   exercito.getOrdemUltimoAtaque().contains(en2) ||
                   (exercito.getOrdemUltimoAtaque().contains(en1C) &&
                   exercito.getOrdemUltimoAtaque().contains(en2C))); 
    }
}










