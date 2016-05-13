import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ItemTest
{
    //TESTES aumenta1000()
    @Test
    public void testaAumentar1000(){
        //Arrange
        Item item = new Item(1, "espada");
        //Act
        item.aumenta1000();
        //Assert
        assertEquals(1001, item.getQuantidade());
    }
    @Test
    public void testaAumentar1000DuasVezes(){
        //Arrange
        Item item = new Item(1, "espada");
        //Act
        item.aumenta1000();
        item.aumenta1000();
        //Arrange
        assertEquals(2001, item.getQuantidade());
    }
    
    //TESTES multiplica1000()
    @Test
    public void testaMultiplicar1000(){
        //Arrange
        Item item = new Item(5, "espada");
        //Act
        item.multiplica1000();
        //Assert
        assertEquals(15005, item.getQuantidade());
    }
    @Test
    public void testaMultiplicar1000DuasVezes(){
        //Arrange
        Item item = new Item(5, "espada");
        //Act
        item.multiplica1000();
        item.multiplica1000();
        //Assert
        assertEquals(913380309, item.getQuantidade());
    }
    
    //TESTES equals()
    @Test
    public void testaEqualsComDoisObjetosIguais(){
        //Arrange
        Item i1 = new Item(10, "pocao");
        Item i2 = new Item(10, "pocao");
        //Act
        boolean obtido = i1.equals(i2);
        //Assert
        assertTrue(obtido);
    }
    @Test
    public void testaEqualsComDoisObjetosDiferentes(){
        //Arrange
        Item i1 = new Item(10, "pocao");
        Item i2 = new Item(9, "pocao");
        //Act
        boolean obtido = i1.equals(i2);
        //Assert
        assertFalse(obtido);
    }      
}
