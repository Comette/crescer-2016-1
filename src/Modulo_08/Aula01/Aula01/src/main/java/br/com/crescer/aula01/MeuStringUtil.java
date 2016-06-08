package br.com.crescer.aula01;

import java.util.Arrays;

public class MeuStringUtil {

    public boolean estaVazia(String string) {
        return string != null || string.trim().isEmpty();
    }

    public int contaVogais(String string) {
        String vogais = "aeiou";
        int numVogais = 0;
        for (char c : string.toLowerCase().toCharArray()) {
            if (vogais.indexOf(c)>=0) {
                numVogais++;
            }
        }
        return numVogais;
    }
    
    public String inverte(String string){
        StringBuilder inversao = new StringBuilder(string);
        return inversao.reverse().toString();
    }
    
    public boolean ehPalindromo (String string){
        return string.equalsIgnoreCase(inverte(string));
    }
    
    public static void main(String[] args){
        System.out.println("\nBem-Vindo(a) ao StringUtil!");
        System.out.println("Métodos disponíveis:\n-estaVazia-\n-contaVogais-\n-inverte-\n-ehPalindromo-");
    }
}
