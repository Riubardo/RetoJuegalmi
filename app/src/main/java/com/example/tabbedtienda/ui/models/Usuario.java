package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

public class Usuario{
    @SerializedName("cliente")
    private Cliente cliente;
    @SerializedName("trabajador")
    private Trabajador trabajador;
    @SerializedName("admin")
    private boolean admin;

    public Usuario(Cliente cliente, Trabajador trabajador, boolean admin) {
        this.cliente = cliente;
        this.trabajador = trabajador;
        this.admin = admin;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
