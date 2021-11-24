package com.example.tabbedtienda.ui.models.Llamadas;

import com.google.gson.annotations.SerializedName;

public class Respuesta {
    @SerializedName("status")
    private String status;

    public Respuesta() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatuss(String statuss) {
        this.status = statuss;
    }
}
