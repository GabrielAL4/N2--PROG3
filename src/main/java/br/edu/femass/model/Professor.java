package br.edu.femass.model;

public class Professor extends Leitor{
    protected String disciplina;
    protected  int prazo;
    public Professor(String nome, String endereco, String telefone, String disciplina) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.disciplina = disciplina;
        this.prazo = setPrazoMaximoDeDevolucao(30);
    }

    public Professor() {
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