package br.com.crescer.aula03;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class PessoaDAOTest {
    
    public PessoaDAOTest() {
    }
    
    @Test
    public void testInsert() {
        System.out.println("insert");
        PessoaDAO instance = new PessoaDAO();
        List<Pessoa> esperado = new ArrayList<>();
        esperado.add(new Pessoa(0l, "potato"));
        instance.insert(new Pessoa(0l, "potato"));
        List<Pessoa> obtido = instance.findNome("potato");
        assertEquals(esperado.size(), obtido.size());
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        PessoaDAO instance = new PessoaDAO();
        Pessoa inicial = instance.findNome("potato").get(0);
        Pessoa alterada = inicial;
        alterada.setNome("batata");
        instance.update(alterada);
        assertEquals(alterada.getId(), instance.findNome("batata").get(0).getId());
        assertEquals(alterada.getNome(), instance.findNome("batata").get(0).getNome());
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        Pessoa pessoa = null;
        PessoaDAO instance = new PessoaDAO();
        instance.delete(pessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testListAll() {
        System.out.println("listAll");
        PessoaDAO instance = new PessoaDAO();
        List<Pessoa> expResult = null;
        List<Pessoa> result = instance.listAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindNome() {
        System.out.println("findNome");
        String nome = "";
        PessoaDAO instance = new PessoaDAO();
        List<Pessoa> expResult = null;
        List<Pessoa> result = instance.findNome(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
