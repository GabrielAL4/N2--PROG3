package br.edu.femass.dao;


import java.util.List;


import br.edu.femass.model.Emprestimo;

public class DaoEmprestimo extends Dao<Emprestimo>{ 
    
    public List<Emprestimo> searchAll() {
        return em.createQuery("select e from Emprestimo e order by e.id").getResultList();
    }    
}