package br.edu.femass.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    protected Long codigo;
    protected String titulo;
    protected Long incremento = 1L;
    protected List<Autor> autores = new ArrayList<>();
    public Livro(String titulo, List<Autor> autores) {
        this.codigo = incremento;
        this.titulo = titulo;
        this.autores = autores;
        this.incremento++;
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
    public List<Autor> getAutor() {
        return autores;
    }
    public void setAutor(List<Autor> autor) {
        this.autores = autor;
    }

    @Override
    public String toString() {
        return codigo + " - " + titulo;
    }
}