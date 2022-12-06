package br.edu.femass.dao;


import java.util.List;


import br.edu.femass.model.Aluno;

public class DaoAluno extends Dao<Aluno>{ 
    
    public List<Aluno> searchAll() {
        return em.createQuery("select c from Leitor c order by c.nome").getResultList();
    }    
    
    public List<Aluno> searchAllById() {
        return em.createQuery("select c from Leitor c order by c.id").getResultList();
    }
}