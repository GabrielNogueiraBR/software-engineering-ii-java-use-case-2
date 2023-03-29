package com.example.demo.model;

public class School {
    private String nome;
    private Plan[] planos = new Plan[0];

    public School(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Plan[] getPlanos() {
        return planos;
    }

    public void adicionarPlano(Plan plano) {
        
    }
}
