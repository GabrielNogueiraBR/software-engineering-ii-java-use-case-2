package com.example.demo.model;

public class User {
    private String nome;
    private String email;
    private String senha;
    private UserType tipo;
    
    private double saldo = 0;

    public enum UserType {
        USUARIO,
        ASSINANTE,
        ASSINANTE_PREMIUM
    }

    public User(String nome, String email, String senha, UserType tipo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UserType getTipo() {
        return tipo;
    }

    public void setTipo(UserType tipo) {
        this.tipo = tipo;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void adicionarSaldo(double saldo) {
        this.saldo += saldo;
    }
}