import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ElfoVerdeTest
{
    @Test
    public void testaExperienciaDobrada(){
        Elfo verde = new ElfoVerde("Gafanhoto");
        Dwarf dwarf = new IrishDwarf("Gimli");
        verde.atirarFlecha(dwarf);
        int experienciaEsperada = 2;
        assertEquals(experienciaEsperada, verde.getExperiencia());
    }
    @Test
    public void testaGanhaItemErrado(){
        Elfo verde = new ElfoVerde("Gafanhoto");
        verde.ganhaItem(new Item(10, "pedra"));
        Item itemEsperado = new Item(10, "pedra");
        assertFalse(verde.possuiItem(itemEsperado));
    }
    @Test
    public void testaGanhaItemCerto(){
        Elfo verde = new ElfoVerde("Gafanhoto");
        Item itemEsperado = new Item(10, "Espada de aço valiriano");
        verde.ganhaItem(itemEsperado);        
        assertTrue(verde.possuiItem(itemEsperado));
    }
}
