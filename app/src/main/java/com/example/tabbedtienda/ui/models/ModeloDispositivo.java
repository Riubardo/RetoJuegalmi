package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

public class ModeloDispositivo {
	private int id;
	private String nombre;
	private String descripcion;
	private Float precio;
	private int garantia;
	private String imagen;
	private Tipo tipo;
	private Marca marca;

	public ModeloDispositivo(int id, String nombre, String descripcion, Float precio, int garantia, String imagen, Tipo tipo, Marca marca) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.garantia = garantia;
		this.imagen = imagen;
		this.tipo = tipo;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public int getGarantia() {
		return garantia;
	}

	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String urlImagen) {
		this.imagen = urlImagen;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
}
