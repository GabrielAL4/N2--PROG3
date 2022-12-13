package br.edu.femass.dao;


import java.util.List;

<<<<<<< HEAD
=======

>>>>>>> 3c5deed0ea6433c25c13577c3b573e0de51fc1f8
import br.edu.femass.model.Professor;

public class DaoProfessor extends Dao<Professor>{ 
    
    public List<Professor> searchAll() {
        return em.createQuery("select c from Leitor c order by c.nome").getResultList();
    }    
    
<<<<<<< HEAD
=======
    public List<Professor> searchAllById() {
        return em.createQuery("select c from Leitor c order by c.id").getResultList();
    }
>>>>>>> 3c5deed0ea6433c25c13577c3b573e0de51fc1f8
}