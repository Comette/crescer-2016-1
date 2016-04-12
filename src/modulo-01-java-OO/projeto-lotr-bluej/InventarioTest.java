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
    @Test
    public void testaAdiciona3ItensEPegaDescricao(){
        Inventario bolsa = new Inventario();
        String esperado = "pedra, corda, pocao";
        Item i1 = new Item(10, "pedra");
        Item i2 = new Item(15, "corda");
        Item i3 = new Item(16, "pocao");
        
        bolsa.adicionaItem(i1);
        bolsa.adicionaItem(i2);
        bolsa.adicionaItem(i3);
               
        assertTrue(esperado.equals(bolsa.getDescricoesItens()));
    }
    @Test
    public void testaItemMaisPopular(){
        Inventario bolsa = new Inventario();
        Item i1 = new Item(10, "pedra");
        Item i2 = new Item(12, "corda");
        Item i3 = new Item(18, "pocao");
        
        bolsa.adicionaItem(i1);
        bolsa.adicionaItem(i2);
        bolsa.adicionaItem(i3);
        
        assertEquals(i3, bolsa.itemMaisPopular());
    }
    @Test
    public void testaOrdenacaocincoItens(){
        Inventario bolsa = new Inventario();
        Item i1 = new Item(18, "pedra");
        Item i2 = new Item(10, "corda");
        Item i3 = new Item(15, "pocao");
        Item i4 = new Item(12, "machado");
        Item i5 = new Item(8, "picareta");
        
        bolsa.adicionaItem(i1);
        bolsa.adicionaItem(i2);
        bolsa.adicionaItem(i3);
        bolsa.adicionaItem(i4);
        bolsa.adicionaItem(i5);
        
        String esperado = "picareta, corda, machado, pocao, pedra";
        
        bolsa.ordenarItens();
        
        assertTrue(esperado.equals(bolsa.getDescricoesItens()));
    }
    @Test
    public void ordenarItensBaguncados(){
        // Arrange
        Inventario mochila = new Inventario();
        Item elderScroll = new Item(9, "Elder Scroll");
        Item escudo = new Item(99, "Escudo");
        Item canivete = new Item(2, "Canivete suíço");
        mochila.adicionaItem(elderScroll);
        mochila.adicionaItem(escudo);
        mochila.adicionaItem(canivete); 
        String esperado = "Canivete suíço, Elder Scroll, Escudo";
        // Act
        mochila.ordenarItens();
        // Assert
        assertTrue(esperado.equals(mochila.getDescricoesItens()));
    }
}
