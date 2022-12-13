package br.edu.femass.model;

import javax.persistence.Entity;

@Entity
public class Aluno extends Leitor{

    private String matricula;


    public Aluno(String nome, String endereco, String telefone, String matricula) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.matricula = matricula;
        setPrazoMaximoDeDevolucao(15);
    }
    public Aluno() {
        setPrazoMaximoDeDevolucao(15);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return nome + " " + matricula;
    }

    @Override
    public int setPrazoMaximoDeDevolucao(Integer prazoMaximoDeDevolucao) {
        return super.setPrazoMaximoDeDevolucao(prazoMaximoDeDevolucao);
    }
}