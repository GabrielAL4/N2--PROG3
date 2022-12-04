package br.edu.femass.model;

public class Leitor {
    protected static long codigo = 0;
    protected String nome;
    protected String endereco;
    protected String telefone;

    protected Integer prazoMaximoDeDevolucao;

    public Leitor() {
    }

    public Leitor(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo += codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getPrazoMaximoDeDevolucao() {
        return prazoMaximoDeDevolucao;
    }

    public int setPrazoMaximoDeDevolucao(Integer prazoMaximoDeDevolucao) {
        return this.prazoMaximoDeDevolucao = prazoMaximoDeDevolucao;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}