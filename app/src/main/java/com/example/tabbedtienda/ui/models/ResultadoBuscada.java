package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import retrofit2.Callback;

public class ResultadoBuscada {
    @SerializedName("videojuegos")
    ArrayList<ModeloVideojuego> arrayModeloVideojuego;
    @SerializedName("dispositivos")
    ArrayList<ModeloDispositivo> arrayModeloDispositivo;

    public ResultadoBuscada() {
    }

    public ArrayList<ModeloVideojuego> getArrayModeloVideojuego() {
        return arrayModeloVideojuego;
    }

    public void setArrayModeloVideojuego(ArrayList<ModeloVideojuego> arrayModeloVideojuego) {
        this.arrayModeloVideojuego = arrayModeloVideojuego;
    }

    public ArrayList<ModeloDispositivo> getArrayModeloDispositivo() {
        return arrayModeloDispositivo;
    }

    public void setArrayModeloDispositivo(ArrayList<ModeloDispositivo> arrayModeloDispositivo) {
        this.arrayModeloDispositivo = arrayModeloDispositivo;
    }


}
