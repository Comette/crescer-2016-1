package br.com.crescer.aula02;

import java.io.File;
import java.io.IOException;

public class MeuFileUtils {

    private void criaArquivo(String nome) {
        File file = new File(nome);
        if (file.exists()) {
            System.out.println("ERRO: arquivo já existe!");
        } else {
            try {
                file.createNewFile();
                System.out.println("SUCESSO: Arquivo criado!");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void criaDiretorio(String nome) {
        File dir = new File(nome);
        if (dir.exists()) {
            System.out.println("ERRO: Diretório já existente");
        } else {
            try {
                dir.mkdir();
                System.out.println("SUCESSO: Diretório criado!");
            } catch (SecurityException ex) {
                System.out.println("ERRO: Sem permissão de acesso!");
            }

        }
    }

    private void excluirArquivo(String nome){
        File file = new File(nome);
        if(file.isDirectory()){
            System.out.println("ERRO: o nome informado não é um arquivo!");
        }else if(file.isFile()){
            file.delete();
            System.out.println("SUCESSO: Arquivo excluído");
        }else{
            System.out.println("ERRO: Não foi possível encontrar o arquivo solicitado");
        }
    }
    
    private void exibeCaminho(String nome){
        File file = new File(nome);
        if(file.exists()){
            System.out.println(file.getAbsolutePath());
        }else{
            System.out.println("ERRO: Arquivo inexistente");
        }
    }
    
    private void exibeArquivosContidos(String diretorio){
        File dir = new File (diretorio);
        if(dir.exists()){
            System.out.println(new File(diretorio).list());            
        }else{
            System.out.println("ERRO: diretório inexistente");
        }
    }
    
    public void instrucao(String comando, String path){
        switch (comando.toLowerCase()){
            case "mk":
                if(path.contains(".txt")){
                    criaArquivo(path);
                }else{
                    criaDiretorio(path);
                }
                break;
            case "rm":
                excluirArquivo(path);
                break;
            case "ls":
                File file = new File(path);
                if(file.exists() && file.isFile()){
                    exibeCaminho(path);
                }else if(file.exists() && file.isDirectory()){
                    exibeArquivosContidos(path);
                }else{
                    System.out.println("ERRO: Path inválido!");
                }
                break;
            default:
                System.out.println("Comando Inválido");
                break;            
        }
    }
    
}
