import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void testaEhBissextoComAnoBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(06, 04, 12);
        assertTrue(data.ehBissexto());
    }
}
