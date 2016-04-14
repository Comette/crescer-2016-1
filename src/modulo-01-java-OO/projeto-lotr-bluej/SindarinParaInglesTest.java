import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class SindarinParaInglesTest
{
    //TESTES traduzir();
    @Test
    public void traduzirPalavraNaur(){
        //Arrange
        TradutorSindarin tradutor = new SindarinParaIngles();
        String esperado = "fire";
        //Act
        String obtido = tradutor.traduzir("naur");
        //Assert
        assertEquals(esperado, obtido);
    }
    @Test
    public void traduzirPalavraNîn(){
        //Arrange
        TradutorSindarin tradutor = new SindarinParaIngles();        
        //Act
        String obtido = tradutor.traduzir("nîn");
        //Assert
        assertEquals(null, obtido);
    }
}
