package br.com.dalcim.exemples.model;

import java.io.Serializable;

import br.com.dalcim.architecture.model.Entity;

public class Filme implements Entity, Serializable{
    private long id;
    private String nome;
    private int anoLancamento;

    public Filme() {
    }

    public Filme(String nome, int anoLancamento) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return (nome.length() > 23 ? nome.substring(0, 20) + "..." : nome) + " - " + anoLancamento;
    }
}
