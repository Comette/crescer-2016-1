package br.com.crescer.aula01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParceladorTest {
    
    public ParceladorTest() {
    }
    @Test
    public void testCalculaParcelas() {
        System.out.println("calculaParcelas");
        double valor = 1000.0;
        double juros = 10.0;
        int qtdParcelas = 2;
        // meses inicia em 0 -.-"
        Date dataInicio = new GregorianCalendar(2015, 04, 12).getTime();
        Parcelador instance = new Parcelador();
        String expResult = "Parcelas:\n12-05-2015 - R$ 550.0\n12-06-2015 - R$ 550.0";
        String result = instance.calculaParcelas(valor, juros, qtdParcelas, dataInicio);
        assertEquals(expResult, result);
    }
    
}
