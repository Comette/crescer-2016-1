package br.com.crescer.aula03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MeuSQLUtils {

    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());

    public static void executa(String nomeArquivo) {
        if (nomeArquivo.contains(".sql")) {
            File arquivo = new File(nomeArquivo);
            String sql = leSQL(arquivo);
            if (sql.isEmpty()) {
                System.out.println("ERRO: Arquivo vazio!");
            } else if (sql.substring(0, 4).equals("ERRO")) {
                System.out.println(sql);
            } else {
                try (final Connection conexao = ConnectionUtils.getConnection()) {
                    try (final Statement statement = conexao.createStatement()) {
                        statement.executeUpdate(sql);
                        System.out.println("SUCESSO: arquivo executado!");
                    } catch (final SQLException ex) {
                        LOGGER.severe(ex.getMessage());
                    }
                } catch (final SQLException ex) {
                    LOGGER.severe(ex.getMessage());
                }
            }
        } else {
            System.out.println("ERRO: Arquivo inválido. Por favor entre um arquivo.sql");
        }
    }

    private static String leSQL(File arquivo) {
        if (arquivo.exists()) {
            String sql = "";
            String linha = null;
            try (final BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {                
                while (true) {
                    linha = reader.readLine();
                    if (linha != null) {
                        sql += linha;
                    }else{
                        break;
                    }
                }
            } catch (IOException ex) {
                LOGGER.severe(ex.getMessage());
            }
            return sql;
        } else {
            return "ERRO: Arquivo não encontrado!";
        }
    }
}
