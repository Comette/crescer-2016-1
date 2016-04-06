

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CestoDeLembasTest
{
    @Test
    public void criarCestoCom2Lembas(){
        CestoDeLembas cesto = new CestoDeLembas(2);       
        assertEquals(false, cesto.podeDividir());
    } 
    @Test
    public void criarCestoComMenosUmLembas(){
        CestoDeLembas cesto = new CestoDeLembas(-1);       
        assertEquals(false, cesto.podeDividir());
    }
    @Test
    public void criarCestoComCemLembas(){
        CestoDeLembas cesto = new CestoDeLembas(100);       
        assertEquals(true, cesto.podeDividir());
    }
    @Test
    public void criarCestoComCentoEDoisLembas(){
        CestoDeLembas cesto = new CestoDeLembas(102);       
        assertEquals(false, cesto.podeDividir());
    }
    @Test
    public void criarCestoComUmLembas(){
        CestoDeLembas cesto = new CestoDeLembas(1);       
        assertEquals(false, cesto.podeDividir());
    }
}
