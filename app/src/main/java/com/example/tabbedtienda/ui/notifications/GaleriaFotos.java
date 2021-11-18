package com.example.tabbedtienda.ui.notifications;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Imagenes")
public class GaleriaFotos {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String foto;

    public GaleriaFotos() {

    }

    public GaleriaFotos(String foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
