package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Leitor;

public class DaoLeitor extends Dao<Leitor>{
    public List<Leitor> searchAll() {
        return em.createQuery("select c from Leitor c order by c.nome").getResultList();
    }    
    
<<<<<<< HEAD
=======
    public List<Leitor> searchAllById() {
        return em.createQuery("select c from Leitor c order by c.id").getResultList();
    }
>>>>>>> 3c5deed0ea6433c25c13577c3b573e0de51fc1f8
}
