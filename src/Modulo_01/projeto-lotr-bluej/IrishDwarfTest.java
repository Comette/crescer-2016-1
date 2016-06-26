import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    //TESTES
    @Test
    public void tentarSorteComNumeroCorreto(){
        //Arrange
        IrishDwarf irish = new IrishDwarf("Trevoso", new DataTerceiraEra(1,1,2016));
        for(int i=0; i<3; i++){
            irish.levaFlechada();
        }
        Item item = new Item(4, "pedra");
        irish.ganhaItem(item);
        //Act
        irish.tentarSorte();  
        //Assert
        assertEquals(10004, irish.getInventario().getItemNoInventario(0).getQuantidade());
    }
    @Test
    public void tentarSorteComNumeroErrado(){
        //Arrange  
        IrishDwarf irish = new IrishDwarf("Trevoso", new DataTerceiraEra(1,1,2016));        
        Item item = new Item(4, "pedra");
        irish.ganhaItem(item);
        //Act
        irish.tentarSorte();
        //Assert
        assertEquals(4, irish.getInventario().getItemNoInventario(0).getQuantidade());
    }
}
