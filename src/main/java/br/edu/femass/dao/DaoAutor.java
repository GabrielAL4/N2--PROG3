package br.edu.femass.dao;


import java.util.List;


import br.edu.femass.model.Autor;

public class DaoAutor extends Dao<Autor>{ 
    
    public List<Autor> searchAll() {
        return em.createQuery("select c from Autor c order by c.nome").getResultList();
    }    
    
}