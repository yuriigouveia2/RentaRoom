package com.savio.rentaroom.banco;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "ALUGA".
 */
public class Aluga {

    private Long id;
    private java.util.Date dia_inicial;
    private java.util.Date dia_termino;
    private java.util.Date hora_inicial;
    private java.util.Date hora_termino;
    private Integer quantidade_reservada;
    private String finalidade;
    private String sala_id;
    private String matricula_id;

    public Aluga() {
    }

    public Aluga(Long id) {
        this.id = id;
    }

    public Aluga(Long id, java.util.Date dia_inicial, java.util.Date dia_termino, java.util.Date hora_inicial, java.util.Date hora_termino, Integer quantidade_reservada, String finalidade, String sala_id, String matricula_id) {
        this.id = id;
        this.dia_inicial = dia_inicial;
        this.dia_termino = dia_termino;
        this.hora_inicial = hora_inicial;
        this.hora_termino = hora_termino;
        this.quantidade_reservada = quantidade_reservada;
        this.finalidade = finalidade;
        this.sala_id = sala_id;
        this.matricula_id = matricula_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getDia_inicial() {
        return dia_inicial;
    }

    public void setDia_inicial(java.util.Date dia_inicial) {
        this.dia_inicial = dia_inicial;
    }

    public java.util.Date getDia_termino() {
        return dia_termino;
    }

    public void setDia_termino(java.util.Date dia_termino) {
        this.dia_termino = dia_termino;
    }

    public java.util.Date getHora_inicial() {
        return hora_inicial;
    }

    public void setHora_inicial(java.util.Date hora_inicial) {
        this.hora_inicial = hora_inicial;
    }

    public java.util.Date getHora_termino() {
        return hora_termino;
    }

    public void setHora_termino(java.util.Date hora_termino) {
        this.hora_termino = hora_termino;
    }

    public Integer getQuantidade_reservada() {
        return quantidade_reservada;
    }

    public void setQuantidade_reservada(Integer quantidade_reservada) {
        this.quantidade_reservada = quantidade_reservada;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public String getSala_id() {
        return sala_id;
    }

    public void setSala_id(String sala_id) {
        this.sala_id = sala_id;
    }

    public String getMatricula_id() {
        return matricula_id;
    }

    public void setMatricula_id(String matricula_id) {
        this.matricula_id = matricula_id;
    }

}