import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HobbitContadorTest
{
    @Test
    public void testaCalcularDiferenca(){
        ArrayList<ArrayList<Integer>> arrayPares = new ArrayList<>();
        arrayPares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayPares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayPares.add(new ArrayList<>(Arrays.asList(12, 60)));
        HobbitContador contador = new HobbitContador();
        int esperado = 840;
        assertEquals(esperado, contador.calcularDiferenca(arrayPares));
    }
}
