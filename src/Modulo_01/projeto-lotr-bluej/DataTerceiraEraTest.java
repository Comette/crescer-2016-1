import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void testaEhBissextoComAnoBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(06, 04, 3012);
        assertTrue(data.ehBissexto());
    }
    @Test
    public void testaEhBissextoComAno2000(){
        DataTerceiraEra data = new DataTerceiraEra(20, 02, 2000);
        assertEquals(true, data.ehBissexto());
    }
    @Test
    public void testaEhBissextoComAno2016(){
        DataTerceiraEra data = new DataTerceiraEra(06, 04, 2016);
        assertEquals(true, data.ehBissexto());
    }
    @Test
    public void testaEhBissextoComAno1911(){
        DataTerceiraEra data = new DataTerceiraEra(06, 11, 1911);
        assertEquals(false, data.ehBissexto());
    }
    @Test
    public void testaEhBissextoComAno1917(){
        DataTerceiraEra data = new DataTerceiraEra(06, 10, 1917);
        assertEquals(false, data.ehBissexto());
    }
    @Test
    public void testaEhBissextoComAno2100(){
        DataTerceiraEra data = new DataTerceiraEra(06, 10, 2100);
        assertEquals(false, data.ehBissexto());
    }
}
