package br.edu.femass.dao;


import java.util.List;

import br.edu.femass.model.Professor;

public class DaoProfessor extends Dao<Professor>{ 
    
    public List<Professor> searchAll() {
        return em.createQuery("select c from Leitor c order by c.nome").getResultList();
    }    
    
}