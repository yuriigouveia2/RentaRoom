package com.savio.rentaroom.banco;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "GERENTE".
 */
public class Gerente {

    private String login;
    private String senha;

    public Gerente() {
    }

    public Gerente(String login) {
        this.login = login;
    }

    public Gerente(String login, String senha) {
        this.login = login;
        this.senha = senha;
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

}
