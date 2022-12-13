package br.edu.femass.model;

<<<<<<< HEAD
import javax.persistence.CascadeType;
=======
>>>>>>> 3c5deed0ea6433c25c13577c3b573e0de51fc1f8
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.ManyToOne;


=======

>>>>>>> 3c5deed0ea6433c25c13577c3b573e0de51fc1f8
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    protected String titulo;
<<<<<<< HEAD
    @ManyToOne(cascade = {CascadeType.ALL})
    protected Autor autor;
    
    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
=======
    protected Long incremento = 1L;
    protected Autor autor;
    public Livro(String titulo, Autor autor) {
        this.codigo = incremento;
        this.titulo = titulo;
        this.autor = autor;
        this.incremento++;
>>>>>>> 3c5deed0ea6433c25c13577c3b573e0de51fc1f8
    }

    public Livro() {
    }

    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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
        return codigo + " - " + titulo;
    }
}