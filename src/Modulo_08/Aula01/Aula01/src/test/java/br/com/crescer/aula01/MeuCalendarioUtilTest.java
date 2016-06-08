package br.com.crescer.aula01;

import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class MeuCalendarioUtilTest {
    
    public MeuCalendarioUtilTest() {
    }
    
    @Test
    public void testDiaNascimento() {
        System.out.println("diaNascimento");
        Date dataNascimento = new GregorianCalendar(2016, 05, 07).getTime();
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        String expResult = "Terça";
        String result = instance.diaNascimento(dataNascimento);
        assertEquals(expResult, result);
    }

    @Test
    public void testTempoDecorrido() {
        System.out.println("tempoDecorrido");
        Date data = new GregorianCalendar(2015, 03, 04).getTime();
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        String expResult = "Decorreram 1 - anos, 2 - meses e 3 - dias";
        String result = instance.tempoDecorrido(data);
        assertEquals(expResult, result);
    }
    
}
