package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Exemplar;


public class DaoExemplar extends Dao<Exemplar>{
    public List<Exemplar> searchAll() {
        return em.createQuery("select c from Exemplar c order by c.id").getResultList();
    }    

    public List<Exemplar> searchAvaible(){
        return em.createQuery("select c from Exemplar c where disponivel=true order by id").getResultList();
    }
}