package br.edu.femass.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String titulo;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Autor autor;
    
    

    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;

    }

    public Livro() {
    }

    public Long getId() {
        return id;
    }
    public void getId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return id + " - " + titulo;
    }
}