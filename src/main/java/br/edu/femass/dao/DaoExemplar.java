package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Exemplar;


public class DaoExemplar extends Dao<Exemplar>{
    public List<Exemplar> searchAll() {
        return em.createQuery("select c from Exemplar c order by c.nome").getResultList();
    }    
    
}