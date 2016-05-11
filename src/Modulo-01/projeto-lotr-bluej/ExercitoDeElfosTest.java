import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ExercitoDeElfosTest
{    
    //TESTES alistaElfo()
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
    
    //TESTES agrupaElfoPorStatus()
    @Test
    public void testaAgraPorStatusCom4ElfosSendo2VivosE2Mortos(){
        //Arrange
        Elfo e1 = new ElfoNoturno("Recruta01", 100);
        Elfo e2 = new ElfoNoturno("Recruta02", 100);
        Elfo e3 = new ElfoNoturno("Recruta03", 100);
        Elfo e4 = new ElfoNoturno("Recruta04", 100);
        for(int i =0; i < 90; i++){
            e3.atirarFlecha(new Dwarf("Feito pra Morrer"));
            e4.atirarFlecha(new Dwarf("Feito pra Morrer"));
        }
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        exercito.alistaElfo(e4);        
        //Act
        exercito.agrupaElfosPorStatus();
        //Assert
        assertTrue(exercito.getExercitoAgrupado().containsKey(Status.VIVO) &&
                   exercito.getExercitoAgrupado().containsKey(Status.MORTO));
    }
    
    //TESTES buscaElfoPorStatus()
    @Test
    public void testaBuscaDeElfosPorStatus(){
        //Arrange
        Elfo e1 = new ElfoNoturno("Recruta01", 100);
        Elfo e2 = new ElfoNoturno("Recruta02", 100);
        Elfo e3 = new ElfoNoturno("Recruta03", 100);
        Elfo e4 = new ElfoNoturno("Recruta04", 100);
        for(int i =0; i < 90; i++){
            e3.atirarFlecha(new Dwarf("Feito pra Morrer"));
            e4.atirarFlecha(new Dwarf("Feito pra Morrer"));
        }
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        exercito.alistaElfo(e4);
        exercito.agrupaElfosPorStatus();
        //Act
        ArrayList<Elfo> obtidoVIVO = exercito.buscarElfoPorStatus(Status.VIVO);
        ArrayList<Elfo> obtidoMORTO = exercito.buscarElfoPorStatus(Status.MORTO);
        //Assert
        assertTrue(obtidoVIVO.contains(e1) && obtidoVIVO.contains(e2));
        assertTrue(obtidoMORTO.contains(e3) && obtidoMORTO.contains(e4));
    }
}










