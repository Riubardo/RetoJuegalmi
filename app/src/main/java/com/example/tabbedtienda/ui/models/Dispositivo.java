package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Dispositivo implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("codigo")
    private String codigo;
    @SerializedName("idModeloVideojuego")
    private int id_modelo_dispositivo;
    @SerializedName("idVenta")
    private int id_venta;

    public Dispositivo() {

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

    public int getId_modelo_dispositivo() {
        return id_modelo_dispositivo;
    }

    public void setId_modelo_dispositivo(int id_modelo_dispositivo) {
        this.id_modelo_dispositivo = id_modelo_dispositivo;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }
}
