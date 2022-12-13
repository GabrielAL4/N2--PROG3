package br.edu.femass.dao;


import java.util.List;


import br.edu.femass.model.Livro;

public class DaoLivro extends Dao<Livro>{ 
    
    public List<Livro> searchAll() {
        return em.createQuery("select c from Livro c order by c.nome").getResultList();
    }    
    
<<<<<<< HEAD
=======
    public List<Livro> searchAllById() {
        return em.createQuery("select c from Livro c order by c.id").getResultList();
    }
>>>>>>> 3c5deed0ea6433c25c13577c3b573e0de51fc1f8
}