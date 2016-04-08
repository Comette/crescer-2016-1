

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void criaAnaoComVidaENascimentoDefault(){
        Dwarf anao = new Dwarf("Nome");
        DataTerceiraEra dataEsperada = new DataTerceiraEra(1,1,1);
        assertEquals(anao.getNome(), "Nome");
        assertTrue(dataEsperada.equals(anao.getDataNascimento())); 
    }
    @Test
    public void criaAnaoComDataNascimento3019(){
        DataTerceiraEra dataEsperada = new DataTerceiraEra(1,1,3019);
        DataTerceiraEra dataTestada = new DataTerceiraEra(1,1,3019);
        Dwarf anao = new Dwarf("Nome", dataEsperada);
        assertTrue(dataEsperada.equals(anao.getDataNascimento()));        
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
        for(int i=0; i<11; i++){
            dwarf.levaFlechada();
        }
        assertEquals(Status.MORTO, dwarf.getStatus());
    }
    @Test
    public void testaDwarfNaoPodeTerVidaNegativa(){
        Dwarf dwarf = new Dwarf("Gimli");
        for(int i=0; i<12; i++){
            dwarf.levaFlechada();
        }
        assertEquals(0, dwarf.getVida());
    }
    @Test
    public void testaGanharItem10Pedras(){
        Dwarf dwarf = new Dwarf("Gimli");
        Item item = new Item(10, "pedra");
        dwarf.ganhaItem(item);
        assertTrue(dwarf.possuiItem(item));
    }
    @Test
    public void testaGanharItem10PedrasEPerder(){
        Dwarf dwarf = new Dwarf("Gimli");
        Item item = new Item(10, "pedra");
        dwarf.ganhaItem(item);
        dwarf.perdeItem(item);
        assertFalse(dwarf.possuiItem(item));
    }
}
