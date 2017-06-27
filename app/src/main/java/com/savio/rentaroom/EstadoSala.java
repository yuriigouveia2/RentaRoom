package com.savio.rentaroom;

/**
 * Created by savio on 15/11/16.
 */

public class EstadoSala {

    private String nomeSala;
    private String estadoSala;

    public EstadoSala(String nomeSala, String estadoSala){

        this.nomeSala = nomeSala;
        this.estadoSala = estadoSala;
    }


    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public String getEstadoSala() {
        return estadoSala;
    }

    public void setEstadoSala(String estadoSala) {
        this.estadoSala = estadoSala;
    }
}
