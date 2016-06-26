package br.com.crescer.aula02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MeuReaderUtils {

    public void exibeConteudo(String nome) {
        File arquivo = new File(nome);
        if (arquivo.exists() && nome.toLowerCase().contains(".txt")) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                while (!reader.readLine().trim().isEmpty()) {
                    System.out.println(reader.readLine());
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("ERRO: Arquivo incorreto ou não encontrado!");
        }
    }
}
