package br.edu.femass.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo {
    protected LocalDate dataEmprestimo;
    protected LocalDate dataDevolucao;
    protected LocalDate dataPrevistaDevolucao;

    protected List<Livro> livros = new ArrayList<>();
    protected List<Professor> professores = new ArrayList<>();
    protected List<Aluno> alunos = new ArrayList<>();
    public Emprestimo(LocalDate dataEmprestimo, LocalDate dataDevolucao, LocalDate dataPrevistaDevolucao,
                      List<Livro> livros, List<Professor> professores, List<Aluno> alunos) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.livros = livros;
        this.professores = professores;
        this.alunos = alunos;
    }

    public Emprestimo() {
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }
}