package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

public class Videojuego {
    @SerializedName("id")
    private int id;
    @SerializedName("codigo")
    private String codigo;
    @SerializedName("idModeloVideojuego")
    private ModeloVideojuego id_modelo_videojuego;
    @SerializedName("idVenta")
    private Venta id_venta;
    @SerializedName("idPlataforma")
    private Plataforma id_plataforma;
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

    public ModeloVideojuego getId_modelo_videojuego() {
        return id_modelo_videojuego;
    }

    public void setId_modelo_videojuego(ModeloVideojuego id_modelo_videojuego) {
        this.id_modelo_videojuego = id_modelo_videojuego;
    }

    public Venta getId_venta() {
        return id_venta;
    }

    public void setId_venta(Venta id_venta) {
        this.id_venta = id_venta;
    }

    public Plataforma getId_plataforma() {
        return id_plataforma;
    }

    public void setId_plataforma(Plataforma id_plataforma) {
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
