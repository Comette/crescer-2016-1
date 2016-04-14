import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ElfoVerdeTest
{
    //TESTES atirarFlecha()
    @Test
    public void ganhaExperienciaDobradaAoAtirarFlecha(){
        //Arrange
        Elfo verde = new ElfoVerde("Gafanhoto");
        Dwarf dwarf = new IrishDwarf("Gimli");
        int experienciaEsperada = 2;
        //Act
        verde.atirarFlecha(dwarf);
        //Assert
        assertEquals(experienciaEsperada, verde.getExperiencia());
    }    
    
    //TESTES ganhaItem()
    @Test
    public void ganhaItemErrado(){
        //Arrange
        Elfo verde = new ElfoVerde("Gafanhoto");
        Item itemEsperado = new Item(10, "pedra");
        //Act
        verde.ganhaItem(new Item(10, "pedra"));
        //Assert
        assertFalse(verde.possuiItem(itemEsperado));
    }
    @Test
    public void ganhaItemCerto(){
        //Arrange
        Elfo verde = new ElfoVerde("Gafanhoto");
        Item itemEsperado = new Item(10, "Espada de aço valiriano");
        //Act
        verde.ganhaItem(itemEsperado);        
        //Assert
        assertTrue(verde.possuiItem(itemEsperado));
    }
}
