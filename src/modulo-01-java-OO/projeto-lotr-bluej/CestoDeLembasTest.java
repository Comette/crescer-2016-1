

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CestoDeLembasTest
{
    @Test
    public void criarCestoCom2Lembas(){
        CestoDeLembas cesto = new CestoDeLembas(2);
        boolean esperado = false;
        boolean obtido = cesto.podeDividir(2);
        assertEquals(esperado, obtido);
    }
}
