package com.example.tabbedtienda.ui.models;

import java.util.ArrayList;

public class ResultadoBuscada {
    ArrayList<ModeloVideojuego> arrayModeloVideojuego;
    ArrayList<ModeloDispositivo> arrayModeloDispositivo;

    public ResultadoBuscada(ArrayList<ModeloVideojuego> arrayModeloVideojuego, ArrayList<ModeloDispositivo> arrayModeloDispositivo) {
        this.arrayModeloVideojuego = arrayModeloVideojuego;
        this.arrayModeloDispositivo = arrayModeloDispositivo;
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
