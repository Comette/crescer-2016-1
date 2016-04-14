import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class SindarinParaPortuguesTest
{
    //TESTES traduzir();
    @Test
    public void traduzirPalavraNaur(){
        //Arrange
        TradutorSindarin tradutor = new SindarinParaPortugues();
        String esperado = "fogo";
        //Act
        String obtido = tradutor.traduzir("naur");
        //Assert
        assertEquals(esperado, obtido);
    }
    @Test
    public void traduzirPalavraAmar(){
        //Arrange
        TradutorSindarin tradutor = new SindarinParaPortugues();
        String esperado = "terra";
        //Act
        String obtido = tradutor.traduzir("amar");
        //Assert
        assertEquals(esperado, obtido);
    }
    @Test
    public void traduzirPalavraNîn(){
        //Arrange
        TradutorSindarin tradutor = new SindarinParaPortugues();        
        //Act
        String obtido = tradutor.traduzir("nada");
        //Assert
        assertEquals(null, obtido);
    }
}
