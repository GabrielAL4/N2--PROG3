package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Leitor;

public class DaoLeitor extends Dao<Leitor>{
    public List<Leitor> searchAll() {
        return em.createQuery("select c from Autor c order by c.nome").getResultList();
    }    
    
    public List<Leitor> searchAllById() {
        return em.createQuery("select c from Autor c order by c.id").getResultList();
    }
}
