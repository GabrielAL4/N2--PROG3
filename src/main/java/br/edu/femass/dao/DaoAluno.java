package br.edu.femass.dao;


import java.util.List;


import br.edu.femass.model.Aluno;

public class DaoAluno extends Dao<Aluno>{ 
    
    public List<Aluno> searchAll() {
        return em.createQuery("select c from Leitor c order by c.nome").getResultList();
    }    
    
<<<<<<< HEAD
=======
    public List<Aluno> searchAllById() {
        return em.createQuery("select c from Leitor c order by c.id").getResultList();
    }
>>>>>>> 3c5deed0ea6433c25c13577c3b573e0de51fc1f8
}