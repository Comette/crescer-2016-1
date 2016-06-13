package br.com.crescer.aula04.run;

import br.com.crescer.aula04.entity.Pessoa;
import br.com.crescer.aula04.tema.DAO.CidadeDAO;
import br.com.crescer.aula04.tema.Model.Cidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {

//    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
//    static final EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
//        System.out.println(em.isOpen());

//        Pessoa pessoaEncontrada = em.find(Pessoa.class, 1l);
//        System.out.println(pessoaEncontrada.getNmPessoa());
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNmPessoa("Victor");
//
//        em.getTransaction().begin();
//            
//        em.persist(pessoa);
//
//        em.getTransaction().commit();
//        em.close();
//        emf.close();

        CidadeDAO repo = new CidadeDAO();
        List<Cidade> todas = repo.listAll();
        for(Cidade cidade : todas){
            System.out.println(cidade.getNome() + ", " + cidade.getUF());
        }
        
    }
}
