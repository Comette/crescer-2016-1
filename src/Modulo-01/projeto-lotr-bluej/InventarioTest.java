import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class InventarioTest
{
    //TESTES adicionaItem()
    @Test
    public void testaAdicionar3Itens(){
        //Arrange
        Inventario bolsa = new Inventario();        
        Item i1 = new Item(10, "pedra");
        Item i2 = new Item(15, "corda");
        Item i3 = new Item(16, "pocao");
        //Act        
        bolsa.adicionaItem(i1);
        bolsa.adicionaItem(i2);
        bolsa.adicionaItem(i3);
        //Assert
        assertEquals(3, bolsa.getQuantidadeItens());
    }
    @Test
    public void testaAdicionar3ItensIguais(){
        //Arrange
        Inventario bolsa = new Inventario();        
        Item i1 = new Item(10, "pedra");
        Item i2 = new Item(10, "pedra");
        Item i3 = new Item(10, "pedra");
        //Act       
        bolsa.adicionaItem(i1);
        bolsa.adicionaItem(i2);
        bolsa.adicionaItem(i3);
        //Assert
        assertEquals(3, bolsa.getQuantidadeItens());
    }
    
    //TESTES removeItem()
    @Test
    public void testaAdiciona3ItensERemove2(){
        //Arrange
        Inventario bolsa = new Inventario();        
        Item i1 = new Item(10, "pedra");
        Item i2 = new Item(15, "corda");
        Item i3 = new Item(16, "pocao");        
        bolsa.adicionaItem(i1);
        bolsa.adicionaItem(i2);
        bolsa.adicionaItem(i3);
        //Act
        bolsa.removeItem(i1);
        bolsa.removeItem(i2);   
        //Assert
        assertEquals(1, bolsa.getQuantidadeItens());
    }
    @Test
    public void testaAdiciona3ItensERemove4(){
        //Arrange
        Inventario bolsa = new Inventario();        
        Item i1 = new Item(10, "pedra");
        Item i2 = new Item(15, "corda");
        Item i3 = new Item(16, "pocao");        
        bolsa.adicionaItem(i1);
        bolsa.adicionaItem(i2);
        bolsa.adicionaItem(i3);
        //Act
        bolsa.removeItem(i1);
        bolsa.removeItem(i2);  
        bolsa.removeItem(i3);
        bolsa.removeItem(i3);
        //Assert
        assertEquals(0, bolsa.getQuantidadeItens());
    }
    
    //TESTES getDescricoesItens()
    @Test
    public void testaAdiciona3ItensEPegaDescricao(){
        //Arrange
        Inventario bolsa = new Inventario();        
        Item i1 = new Item(10, "pedra");
        Item i2 = new Item(15, "corda");
        Item i3 = new Item(16, "pocao");        
        bolsa.adicionaItem(i1);
        bolsa.adicionaItem(i2);
        bolsa.adicionaItem(i3);
        String esperado = "pedra, corda, pocao";
        //Act
        String recebido = bolsa.getDescricoesItens();
        //Assert
        assertTrue(esperado.equals(recebido));
    }
    @Test
    public void testaAdiciona3Itens1ComDescricaoVaziaEPegaDescricao(){
        //Arrange
        Inventario bolsa = new Inventario();        
        Item i1 = new Item(10, "pedra");
        Item i2 = new Item(15, "corda");
        Item i3 = new Item(16, "");        
        bolsa.adicionaItem(i1);
        bolsa.adicionaItem(i2);
        bolsa.adicionaItem(i3);
        String esperado = "pedra, corda, ";
        //Act
        String recebido = bolsa.getDescricoesItens();
        //Assert
        assertTrue(esperado.equals(recebido));
    }
    
    //TESTES itemMaisPopular()
    @Test
    public void testaItemMaisPopular(){
        Inventario bolsa = new Inventario(); 
        Item i3 = new Item(18, "pocao");
        
        bolsa.adicionaItem(new Item(10, "pedra"));
        bolsa.adicionaItem(new Item(12, "corda"));
        bolsa.adicionaItem(new Item(18, "pocao"));
        
        assertTrue(i3.equals(bolsa.itemMaisPopular()));
    }
    @Test
    public void testaItemMaisPopularComItensDeMesmaDescricao(){
        Inventario bolsa = new Inventario();        
        Item i3 = new Item(18, "pedra");
        
        bolsa.adicionaItem(new Item (10, "pedra"));
        bolsa.adicionaItem(new Item(12, "pedra"));
        bolsa.adicionaItem(new Item(18, "pedra"));
        
        assertTrue(i3.equals(bolsa.itemMaisPopular()));
    }
    
    //TESTES ordenaItens()
    @Test
    public void testaOrdenacaocincoItens(){
        //Arrange
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
        //Act
        bolsa.ordenarItens();
        //Assert
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
    
    //TESTES equals()
    @Test
    public void testaEqualsComObjetosIguais(){
        //Arrange
        Inventario i1 = new Inventario();
        i1.adicionaItem(new Item(10, "pedra"));
        i1.adicionaItem(new Item(15, "canivete"));
        i1.adicionaItem(new Item(8, "pocao"));
        Inventario i2 = new Inventario();
        i2.adicionaItem(new Item(10, "pedra"));
        i2.adicionaItem(new Item(15, "canivete"));
        i2.adicionaItem(new Item(8, "pocao"));
        boolean esperado = true;
        //Act        
        boolean obtido = i1.equals(i2);
        //Assert
        assertEquals(esperado, obtido);
    }
    @Test
    public void testaEqualsComObjetosDiferentes(){
        //Arrange
        Inventario i1 = new Inventario();
        i1.adicionaItem(new Item(15, "canivete"));
        i1.adicionaItem(new Item(10, "pedra"));        
        i1.adicionaItem(new Item(8, "pocao"));
        Inventario i2 = new Inventario();
        i2.adicionaItem(new Item(8, "pocao"));
        i2.adicionaItem(new Item(10, "pedra"));
        i2.adicionaItem(new Item(15, "canivete"));        
        boolean esperado = false;
        //Act
        boolean obtido = i1.equals(i2);
        //Assert
        assertEquals(esperado, obtido);
    }
    @Test
    public void testaEqualsComDoisObjetosVazios(){
        //Arrange
        Inventario i1 = new Inventario();
        Inventario i2 = new Inventario();       
        boolean esperado = true;
        //Act
        boolean obtido = i1.equals(i2);
        //Assert
        assertEquals(esperado, obtido);
    }
    @Test
    public void testaEqualsComUmObjetoVazio(){
        //Arrange
        Inventario i1 = new Inventario();
        Inventario i2 = new Inventario();
        i2.adicionaItem(new Item(8, "pocao"));
        i2.adicionaItem(new Item(10, "pedra"));
        i2.adicionaItem(new Item(15, "canivete"));
        boolean esperado = false;
        //Act
        boolean obtido = i1.equals(i2);
        //Assert
        assertEquals(esperado, obtido);
    }
}
