package br.edu.femass.dao;


import java.util.List;


import br.edu.femass.model.Livro;

public class DaoLivro extends Dao<Livro>{ 
    
    public List<Livro> searchAll() {
        return em.createQuery("select c from Livro c order by c.id").getResultList();
    }    
    
}