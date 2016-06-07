
package br.com.crescer;

import java.util.Scanner;

/**
 *
 * @author victor.ribeiro
 */
public class ex01 {

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite um numero: ");
            int numero = scanner.nextInt();
            if(numero % 2 == 0){
                System.out.println("o numero é par");
            }else{
                System.out.println("O numero é impar");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
