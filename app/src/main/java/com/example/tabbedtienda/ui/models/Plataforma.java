package com.example.tabbedtienda.ui.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Plataforma implements Serializable{

	private int id;
	private String plataforma;
	private ArrayList<Videojuego> juego;

	public Plataforma(int id, String plataforma, ArrayList<Videojuego> juego){
		this.id = id;
		this.plataforma = plataforma;
		this.juego = juego;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getPlataforma() { return plataforma; }
	public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

	public ArrayList<Videojuego> getListaVideojuegos() { return juego; }
	public void setListaVideojuegos(ArrayList<Videojuego> listaJuegos) { this.juego = listaJuegos; }
}
