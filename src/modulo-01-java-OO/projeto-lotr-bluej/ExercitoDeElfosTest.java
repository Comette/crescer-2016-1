import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest
{    
    @Test
    public void testaAlistarElfoVerde(){
        //Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo esperado = new ElfoVerde("Legolas");
        //Act
        exercito.alistaElfo(new ElfoVerde("Legolas"));
        //Assert
        assertEquals(esperado, exercito.buscaElfoPeloNome("Legolas"));
    }
    @Test
    public void testaAlistarElfoNoturno(){
        //Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo esperado = new ElfoNoturno("Legolas");
        //Act
        exercito.alistaElfo(new ElfoNoturno("Legolas"));
        //Assert
        assertEquals(esperado, exercito.buscaElfoPeloNome("Legolas"));
    }
    @Test
    public void testaAlistarElfo(){
        //Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();        
        //Act
        exercito.alistaElfo(new Elfo("Legolas"));
        //Assert
        assertEquals(null, exercito.buscaElfoPeloNome("Legolas"));
    }
}
