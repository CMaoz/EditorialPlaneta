package com.example.maoz1.editorialplaneta;

/**
 * Created by Maoz1 on 1/11/2017.
 */

public class User {
    private String id,nombredl,nombreda,nombreqp, numtel;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombredl() {
        return nombredl;
    }

    public void setNombredl(String nombredl) {
        this.nombredl = nombredl;
    }

    public String getNombreda() {
        return nombreda;
    }

    public void setNombreda(String nombreda) {
        this.nombreda = nombreda;
    }

    public String getNombreqp() {
        return nombreqp;
    }

    public void setNombreqp(String nombreqp) {
        this.nombreqp = nombreqp;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }


    public User(String id, String nombredl, String nombreda, String nombreqp, String numtel) {
        this.id = id;
        this.nombredl = nombredl;
        this.nombreda = nombreda;
        this.nombreqp = nombreqp;
        this.numtel = numtel;
    }
}
