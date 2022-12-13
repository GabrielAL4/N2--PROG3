package br.edu.femass.model;

import javax.persistence.Entity;

@Entity
public class Professor extends Leitor{
    private String disciplina;
    public Professor(String nome, String endereco, String telefone, String disciplina) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.disciplina = disciplina;
        setPrazoMaximoDeDevolucao(30);
    }

    public Professor() {
        setPrazoMaximoDeDevolucao(30);
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return nome + " " + disciplina;
    }

    @Override
    public int setPrazoMaximoDeDevolucao(Integer prazoMaximoDeDevolucao) {
        return super.setPrazoMaximoDeDevolucao(prazoMaximoDeDevolucao);
    }
}