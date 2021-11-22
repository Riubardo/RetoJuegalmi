package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

public class Marca {
    @SerializedName("id")
    private int id;

    @SerializedName("nombre")
    private String nombre;

    public Marca(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
