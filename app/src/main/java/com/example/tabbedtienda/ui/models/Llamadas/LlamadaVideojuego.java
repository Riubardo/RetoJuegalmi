package com.example.tabbedtienda.ui.models.Llamadas;

import java.util.Date;

public class LlamadaVideojuego {
    private Integer id_modelo_videojuego;
    private Integer id_plataforma;
    private boolean alquilable;
    private String fecha;

    public LlamadaVideojuego(Integer id_modelo_videojuego, Integer id_plataforma, boolean alquilable, String fecha) {
        this.id_modelo_videojuego = id_modelo_videojuego;
        this.id_plataforma = id_plataforma;
        this.alquilable = alquilable;
        this.fecha = fecha;
    }

    public Integer getId_modelo_videojuego() {
        return id_modelo_videojuego;
    }

    public void setId_modelo_videojuego(Integer id_modelo_videojuego) {
        this.id_modelo_videojuego = id_modelo_videojuego;
    }

    public Integer getId_plataforma() {
        return id_plataforma;
    }

    public void setId_plataforma(Integer id_plataforma) {
        this.id_plataforma = id_plataforma;
    }

    public boolean isAlquilable() {
        return alquilable;
    }

    public void setAlquilable(boolean alquilable) {
        this.alquilable = alquilable;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
