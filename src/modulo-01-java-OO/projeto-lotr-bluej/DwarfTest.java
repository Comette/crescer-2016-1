

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void criaAnaoComNomeVidaDefault(){
        Dwarf anao = new Dwarf("Nome");
        assertEquals(true, anao.getNome() == "Nome");
    }
    @Test
    public void testaLevarFlechadaPerderVida(){
        Dwarf anao = new Dwarf("Nome");
        anao.levaFlechada();        
        assertEquals(true, anao.getVida() == 100);
    }    
    @Test
    public void testaDwarfNasceVivo(){
        Dwarf anao = new Dwarf("Nome");                
        assertEquals(Status.VIVO, anao.getStatus());
    } 
    @Test
    public void mataDwarfCom11Flechadas(){
        Dwarf dwarf = new Dwarf("Gimli");
        Elfo elfo = new Elfo("Legolas");
        for(int i=0; i<11; i++){
            elfo.atirarFlecha(dwarf);
        }
        assertEquals(Status.MORTO, dwarf.getStatus());
    }
    @Test
    public void testaDwarfNaoPodeTerVidaNegativa(){
        Dwarf dwarf = new Dwarf("Gimli");
        Elfo elfo = new Elfo("Legolas");
        for(int i=0; i<12; i++){
            elfo.atirarFlecha(dwarf);
        }
        assertEquals(0, dwarf.getVida());
    }
}
