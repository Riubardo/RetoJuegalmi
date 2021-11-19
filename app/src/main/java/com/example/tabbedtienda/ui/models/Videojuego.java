package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

public class Videojuego {
    @SerializedName("id")
    private int id;
    @SerializedName("codigo")
    private String codigo;
    @SerializedName("idModeloVideojuego")
    private int id_modelo_videojuego;
    @SerializedName("idVenta")
    private int id_venta;
    @SerializedName("idPlataforma")
    private int id_plataforma;
    @SerializedName("fisico")
    private boolean fisico;
    @SerializedName("alquilable")
    private boolean alquilable;

    public Videojuego() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId_modelo_videojuego() {
        return id_modelo_videojuego;
    }

    public void setId_modelo_videojuego(int id_modelo_videojuego) {
        this.id_modelo_videojuego = id_modelo_videojuego;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_plataforma() {
        return id_plataforma;
    }

    public void setId_plataforma(int id_plataforma) {
        this.id_plataforma = id_plataforma;
    }

    public boolean isFisico() {
        return fisico;
    }

    public void setFisico(boolean fisico) {
        this.fisico = fisico;
    }

    public boolean isAlquilable() {
        return alquilable;
    }

    public void setAlquilable(boolean alquilable) {
        this.alquilable = alquilable;
    }
}
