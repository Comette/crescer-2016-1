package br.com.crescer.aula03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

public class MeuSQLUtils {

    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());

    public static void executa(String nomeArquivo) {
        if(nomeArquivo.endsWith(".sql")) {
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
    
    public static void importaCSV(String nomeArquivo){
        if(nomeArquivo.endsWith(".csv")){            
            PessoaDAO repositorio = new PessoaDAO();
            try (final BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))){
                String linha="";                 
                while((linha = reader.readLine()) != null){
                    String[] data = linha.split(",");
                    Long id = Long.parseLong(data[0]);
                    String nome = data[1];
                    repositorio.insert(new Pessoa(id, nome));
                }
                System.out.println("SUCESSO: arquivo importado!");
            } catch (FileNotFoundException ex) {
                LOGGER.severe(ex.getMessage());
            } catch (IOException ex) {
                LOGGER.severe(ex.getMessage());
            }
        }else{
            System.out.println("ERRO: Arquivo inválido");
        }
    }
    
    public static void exportarCSV(String nomeArquivo){
        if(nomeArquivo.endsWith(".csv")){
            PessoaDAO repositorio = new PessoaDAO();
            List<Pessoa> extraditados = repositorio.listAll();
            try(FileWriter writer = new FileWriter(nomeArquivo)){
                for(Pessoa pessoa : extraditados){
                    writer.append(pessoa.getId().toString());
                    writer.append(",");
                    writer.append(pessoa.getNome());
                    writer.append("\n");
                }
                System.out.println("SUCESSO: arquivo exportado!");
            } catch (IOException ex) {
                LOGGER.severe(ex.getMessage());
            }            
        }else{
            System.out.println("ERRO: Digite um nome que termine com .csv!");
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
