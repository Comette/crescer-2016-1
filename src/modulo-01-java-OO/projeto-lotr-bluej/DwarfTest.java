

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
}
