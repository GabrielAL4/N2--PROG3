package br.edu.femass.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao<E> {

    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    
    static {
        try {
            emf = Persistence.createEntityManagerFactory("jpa_library");
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Dao() {
        em = emf.createEntityManager();
    }

    public void insert(E entidade) {
        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();
    }    
    
    public void delete(E entidade) {
        em.getTransaction().begin();
        em.remove(entidade);
        em.getTransaction().commit();
    }    
    
    public void modify(E entidade) {
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
    }
}