package br.edu.femass.dao;


import java.util.List;


import br.edu.femass.model.Emprestimo;

public class DaoEmprestimo extends Dao<Emprestimo>{ 
    
    public List<Emprestimo> searchAll() {
        return em.createQuery("select c from Autor c order by c.nome").getResultList();
    }    
    
<<<<<<< HEAD
=======
    public List<Emprestimo> searchAllById() {
        return em.createQuery("select c from Autor c order by c.id").getResultList();
    }
>>>>>>> 3c5deed0ea6433c25c13577c3b573e0de51fc1f8
}