package br.edu.femass.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate dataPrevistaDevolucao;

    @ManyToOne(cascade = CascadeType.ALL)
    private Exemplar exemplar;

    @ManyToOne(cascade = CascadeType.ALL)
    private Leitor leitor;

    public Emprestimo(Exemplar exemplar, Leitor leitor) {
        this.leitor = leitor;
        this.exemplar = exemplar;
        this.exemplar.setDisponivel(false);

        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = LocalDate.now().plusDays(leitor.getPrazoMaximoDeDevolucao());
    }

    public Emprestimo() {
        this.dataEmprestimo = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public void setDataEmprestimo() {
        this.dataEmprestimo = LocalDate.now();
    }

    public void setDataPrevistaDevolucao() {
        this.dataPrevistaDevolucao = LocalDate.now().plusDays(this.leitor.getPrazoMaximoDeDevolucao());
    }

    public void setDatadevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
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