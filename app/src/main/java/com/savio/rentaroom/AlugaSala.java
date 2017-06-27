package com.savio.rentaroom;

/**
 * Created by savio on 15/11/16.
 */

public class AlugaSala {

    private String nomeSala;
    private String uso;
    private String quantidade;

    public AlugaSala(String nomeSala, String uso, String quantidade){

        this.nomeSala = nomeSala;
        this.uso = uso;
        this.quantidade = quantidade;
    }


    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
