package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Plataforma implements Serializable{
	@SerializedName("id")
	private int id;
	@SerializedName("plataforma")
	private String plataforma;
	@SerializedName("juego")
	private ArrayList<ModeloVideojuego> juego;

	public Plataforma(String plataforma, ArrayList<ModeloVideojuego> juego){
		this.plataforma = plataforma;
		this.juego = juego;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getPlataforma() { return plataforma; }
	public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

	public ArrayList<ModeloVideojuego> getListaVideojuegos() { return juego; }
	public void setListaVideojuegos(ArrayList<ModeloVideojuego> listaJuegos) { this.juego = listaJuegos; }
}
