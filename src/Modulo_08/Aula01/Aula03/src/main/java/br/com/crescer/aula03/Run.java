package br.com.crescer.aula03;

import java.util.List;

public class Run {

    public static void main(String[] args) {
        PessoaDAO dao = new PessoaDAO();
        //dao.insert(new Pessoa(0l, "Teste"));
        List<Pessoa> pessoas = dao.findNome("Teste");
        System.out.println(pessoas);
    }
}
