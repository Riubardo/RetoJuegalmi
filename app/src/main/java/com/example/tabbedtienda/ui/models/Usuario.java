package com.example.tabbedtienda.ui.models;

import java.io.Serializable;

public class Usuario implements Serializable {
    private Cliente cliente;
    private Trabajador trabajador;
    private boolean admin;

    public Usuario(Cliente cliente, Trabajador trabajador, boolean admin){
        this.cliente=cliente;
        this.trabajador=trabajador;
        this.admin=admin;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
