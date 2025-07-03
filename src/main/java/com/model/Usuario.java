package com.model;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String corFundo;
    private String corFonte;

    public Usuario() {}

    public Usuario(String login, String senha, String corFundo, String corFonte) {
        this.login = login;
        this.senha = senha;
        this.corFundo = corFundo;
        this.corFonte = corFonte;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCorFundo() {
        return corFundo;
    }

    public void setCorFundo(String corFundo) {
        this.corFundo = corFundo;
    }

    public String getCorFonte() {
        return corFonte;
    }

    public void setCorFonte(String corFonte) {
        this.corFonte = corFonte;
    }
}
