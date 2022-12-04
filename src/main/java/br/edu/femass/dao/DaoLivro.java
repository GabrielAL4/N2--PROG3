package br.edu.femass.dao;


import java.util.List;


import br.edu.femass.model.Livro;

public class DaoLivro extends Dao<Livro>{ 
    
    public List<Livro> searchAll() {
        return em.createQuery("select c from Autor c order by c.nome").getResultList();
    }    
    
    public List<Livro> searchAllById() {
        return em.createQuery("select c from Autor c order by c.id").getResultList();
    }
}