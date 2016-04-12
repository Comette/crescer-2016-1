import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ItemTest
{
    @Test
    public void testaAumentar1000(){
        Item item = new Item(1, "espada");
        item.aumenta1000();
        assertEquals(1001, item.getQuantidade());
    }
    @Test
    public void testaMultiplicar1000(){
        Item item = new Item(5, "espada");
        item.multiplica1000();
        assertEquals(15005, item.getQuantidade());
    }
}
