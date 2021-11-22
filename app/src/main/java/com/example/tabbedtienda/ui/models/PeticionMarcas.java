package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class PeticionMarcas implements Serializable{

	@SerializedName("id")
	private int id;
	@SerializedName("marca")
	private String nombre;
	@SerializedName("dispositivo")
	private ArrayList<ModeloDispositivo> dispositivo;

	public PeticionMarcas(int id, String plataforma, ArrayList<ModeloVideojuego> juego){
		this.id = id;
		this.nombre = nombre;
		this.dispositivo = dispositivo;
	}

	public PeticionMarcas(){ }

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public ArrayList<ModeloDispositivo> getDispositivo() { return dispositivo; }
	public void setDispositivo(ArrayList<ModeloDispositivo> dispositivo) { this.dispositivo = dispositivo; }
}
