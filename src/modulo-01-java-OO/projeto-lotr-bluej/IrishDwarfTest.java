

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void testaTentarSorteComNumeroCorreto(){
        IrishDwarf irish = new IrishDwarf("Trevoso", new DataTerceiraEra(1,1,2016));
        for(int i=0; i<3; i++){
            irish.levaFlechada();
        }
        Item item = new Item(4, "pedra");
        irish.ganhaItem(item);
        irish.tentarSorte();        
        assertEquals(10004, irish.getInventario().getItemNoInventario(0).getQuantidade());
    } 
}
