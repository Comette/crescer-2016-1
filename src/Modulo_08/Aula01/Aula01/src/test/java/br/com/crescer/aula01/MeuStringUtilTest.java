package br.com.crescer.aula01;

import org.junit.Test;
import static org.junit.Assert.*;

public class MeuStringUtilTest {
    
    public MeuStringUtilTest() {
    }
    
    @Test
    public void testEstaVaziaVerdadeiro() {
        System.out.println("estaVazia");
        String string = "   ";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = true;
        boolean result = instance.estaVazia(string);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEstaVaziaFalso() {
        System.out.println("estaVazia");
        String string = "   . ";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = false;
        boolean result = instance.estaVazia(string);
        assertEquals(expResult, result);
    }

    @Test
    public void testContaVogais() {
        System.out.println("contaVogais");
        String string = "meu passado me condena";
        MeuStringUtil instance = new MeuStringUtil();
        int expResult = 9;
        int result = instance.contaVogais(string);
        assertEquals(expResult, result);
    }

    @Test
    public void testInverte() {
        System.out.println("inverte");
        String string = "amo";
        MeuStringUtil instance = new MeuStringUtil();
        String expResult = "oma";
        String result = instance.inverte(string);
        assertEquals(expResult, result);
    }

    @Test
    public void testEhPalindromoVerdadeiro() {
        System.out.println("ehPalindromo");
        String string = "Ama";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = true;
        boolean result = instance.ehPalindromo(string);
        assertEquals(expResult, result);
    }
    @Test
    public void testEhPalindromoFalso() {
        System.out.println("ehPalindromo");
        String string = "Ceu";
        MeuStringUtil instance = new MeuStringUtil();
        boolean expResult = false;
        boolean result = instance.ehPalindromo(string);
        assertEquals(expResult, result);
    }
    
}
