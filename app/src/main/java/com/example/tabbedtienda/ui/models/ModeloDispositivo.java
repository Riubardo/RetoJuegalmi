package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

public class ModeloDispositivo {
    @SerializedName("id")
    private int id;
    @SerializedName("id_tipo")
    private Tipo idTipo;
    @SerializedName("id_marca")
    private Marca idMarca;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("descripcion")
    private String descripcion;
    @SerializedName("precio")
    private float precio;
    @SerializedName("garantia")
    private float garantia;
    @SerializedName("imagen")
    private String imagen;

    public ModeloDispositivo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getGarantia() {
        return garantia;
    }

    public void setGarantia(float garantia) {
        this.garantia = garantia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
