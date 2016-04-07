import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class InventarioTest
{
    @Test
    public void testaAdicionar3Itens(){
        Inventario bolsa = new Inventario();
        
        Item i1 = new Item(10, "pedra");
        Item i2 = new Item(15, "corda");
        Item i3 = new Item(16, "pocao");
                
        bolsa.adicionaItem(i1);
        bolsa.adicionaItem(i2);
        bolsa.adicionaItem(i3);
        
        assertEquals(3, bolsa.getQuantidadeItens());
    }
    @Test
    public void testaAdiciona3ItensERemove2(){
        Inventario bolsa = new Inventario();
        
        Item i1 = new Item(10, "pedra");
        Item i2 = new Item(15, "corda");
        Item i3 = new Item(16, "pocao");
        
        bolsa.adicionaItem(i1);
        bolsa.adicionaItem(i2);
        bolsa.adicionaItem(i3);
        
        bolsa.removeItem(i1);
        bolsa.removeItem(i2);   
        
        assertEquals(1, bolsa.getQuantidadeItens());
    }
}
