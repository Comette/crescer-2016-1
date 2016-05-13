import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    //TESTES atirarFlecha()
    @Test
    public void elfoGanhaTriploExperienciaAoAtirarFlecha(){
        //Arrange
        Elfo elfo = new ElfoNoturno("Legolas da Nigth");
        Dwarf anao = new IrishDwarf("Feito pra Morrer");
        //Act
        elfo.atirarFlecha(anao);
        //Assert
        assertEquals(3, elfo.getExperiencia());
    }
    @Test
    public void elfoPerde5PorCentoDeVidaAoAtirarFlecha(){
        //Arrange
        Elfo elfo = new ElfoNoturno("Legolas da Nigth");
        Dwarf anao = new IrishDwarf("Feito pra Morrer");
        //Act
        elfo.atirarFlecha(anao);        
        //Assert
        assertEquals(95, elfo.getVida(), 0.0001);
    }
    @Test
    public void elfoMorreAoAtirar150Vezes(){
        //Arrange
        Elfo elfo = new ElfoNoturno("Legolas da Nigth", 150);
        Dwarf anao = new IrishDwarf("Feito pra Morrer");
        //Act
        for (int i = 0; i< 150; i++){
            elfo.atirarFlecha(anao);  
        }
        //Assert
        assertEquals(Status.MORTO, elfo.getStatus());
    }
    @Test
    public void elfoMorreAoAtirar89Vezes(){
        //Arrange
        Elfo elfo = new ElfoNoturno("Legolas da Nigth", 150);
        Dwarf anao = new IrishDwarf("Feito pra Morrer");
        //Act
        for (int i = 0; i< 89; i++){
            elfo.atirarFlecha(anao);  
        }
        //Assert
        assertEquals(Status.VIVO, elfo.getStatus());
    }
}
