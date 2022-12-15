package br.edu.femass.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Exemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @ManyToOne(cascade = CascadeType.ALL)
    private Livro livro;
    
    private String titulo;
    private LocalDate dataAquisicao;
    private boolean disponivel;

    public Exemplar(Livro livro) {
        //this.titulo = livro.getTitulo();
        this.livro = livro;
        this.dataAquisicao= LocalDate.now();
        this.disponivel = true;
    }

    public Exemplar() {
        this.dataAquisicao= LocalDate.now();
        this.disponivel = true;
    }
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Livro getLivro() {
        return livro;
    }


    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    
    public boolean isDisponivel() {
        return disponivel;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.livro.getTitulo();
    }

}