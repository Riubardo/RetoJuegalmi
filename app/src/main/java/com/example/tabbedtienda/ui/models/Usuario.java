package com.example.tabbedtienda.ui.models;

import java.io.Serializable;

public class Usuario implements Serializable {
    private Cliente usuario;
    private boolean admin;

    public Usuario(Cliente usuario, boolean admin) {
        this.usuario = usuario;
        this.admin = admin;
    }

    public Object getUsuario() {
        return usuario;
    }

    public void setUsuario(Cliente usuario) {
        this.usuario = usuario;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
