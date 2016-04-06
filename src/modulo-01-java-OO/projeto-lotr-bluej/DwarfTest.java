

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void criaAnaoComNome(){
        Dwarf anao = new Dwarf("Nome");
        assertEquals(true, anao.getNome() == "Nome");
    }
    @Test
    public void testaLevarFlechada(){
        Dwarf anao = new Dwarf("Nome");
        anao.levaFlechada();        
        assertEquals(true, anao.getVida() == 100);
    }    
}
