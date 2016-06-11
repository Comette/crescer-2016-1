package br.com.crescer.aula04.tema.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.Session;

public class Persistencia {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");    

    public static final EntityManager em = emf.createEntityManager();    
    
    public static final Session session = em.unwrap(Session.class);
}
