package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

public class Tiene {
    @SerializedName("id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}