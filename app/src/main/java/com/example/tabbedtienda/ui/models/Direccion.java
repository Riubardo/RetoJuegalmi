package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

public class Direccion {
    @SerializedName("id")
    private int id;
    @SerializedName("calle")
    private String calle;
    @SerializedName("portal")
    private String portal;
    @SerializedName("piso")
    private String piso;
    @SerializedName("codigopostal")
    private int codigopostal;
    @SerializedName("idCiudad")
    private Ciudad id_ciudad;

    public Direccion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public int getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(int codigopostal) {
        this.codigopostal = codigopostal;
    }

    public Ciudad getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Ciudad id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
}
