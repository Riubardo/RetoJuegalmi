package com.example.tabbedtienda.ui.models.Llamadas;

public class LlamadaDeleteDirection {
    private int id_usuario, id_direccion;

    public LlamadaDeleteDirection(int id_usuario, int id_direccion) {
        this.id_usuario = id_usuario;
        this.id_direccion = id_direccion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }
}
