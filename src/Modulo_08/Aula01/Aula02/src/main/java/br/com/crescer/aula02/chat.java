package br.com.crescer.aula02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class chat {

    public static void main(String[] args) throws IOException {
        boolean nomeOk = false;
        String nick = null;
        while (!nomeOk) {
            System.out.println("Digite seu Nick:");
            Scanner scan1 = new Scanner(System.in);
            nick = scan1.nextLine();
            if (nick != null && !nick.trim().isEmpty()) {
                nomeOk = true;
            } else {
                System.out.println("Digite um nick válido!");
            }
        }
        args = new String[]{"//10.0.100.102/cwitmp/carloshenrique/crescer.txt", nick};
        new File(args[0]).createNewFile();
        final String s = args[0];
        //[0] path, [1] nick        
        new Thread(new Runnable() {
            BufferedReader reader = null;

            @Override
            public void run() {
                try {
                    reader = new BufferedReader(new FileReader(s));
                    while (true) {
                        String linha = reader.readLine();
                        if (linha != null && !linha.trim().isEmpty()) {
                            System.out.println(linha);
                        }
                        Thread.sleep(500);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                } finally {
                    try {
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }).start();

        while (true) {
            Scanner scan = new Scanner(System.in);
            String digitado = scan.nextLine();
            if (":q!".equals(digitado)) {
                break;
            }
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(args[0], true));
                SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-YYYY HH:mm");
                String dataDigitacao = fmt.format(new Date());
                writer.append(dataDigitacao + " - " + args[1]);
                writer.newLine();
                writer.append(digitado);
                writer.newLine();
                writer.flush();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
