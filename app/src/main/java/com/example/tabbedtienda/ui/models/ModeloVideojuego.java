package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ModeloVideojuego{
	@SerializedName("id")
	private int id;
	@SerializedName("nombre")
	private String nombre;
	@SerializedName("descripcion")
	private String descripcion;
	@SerializedName("pegi")
	private int pegi;
	@SerializedName("desarrolladora")
	private String nombreDesarrolladora;
	@SerializedName("precio_venta")
	private float precioVenta;
	@SerializedName("precio_alquiler")
	private float precioAlquiler;
	@SerializedName("imagen")
	private String imagen;

	public ModeloVideojuego(String nombre, String descripcion, int pegi, String nombreDesarrolladora, float precioVenta, float precioAlquiler, String imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pegi = pegi;
		this.nombreDesarrolladora = nombreDesarrolladora;
		this.precioVenta = precioVenta;
		this.precioAlquiler = precioAlquiler;
		this.imagen = imagen;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

	public int getPegi() { return pegi; }
	public void setPegi(int pegi) { this.pegi = pegi; }

	public String getNombreDesarrolladora() { return nombreDesarrolladora; }
	public void setNombreDesarrolladora(String nombreDesarrolladora) { this.nombreDesarrolladora = nombreDesarrolladora; }

	public float getPrecioVenta() { return precioVenta; }
	public void setPrecioVenta(float precioVenta) { this.precioVenta = precioVenta; }

	public float getPrecioAlquiler() { return precioAlquiler; }
	public void setPrecioAlquiler(float precioAlquiler) { this.precioAlquiler = precioAlquiler; }

	public String getImagen() { return imagen; }
	public void setImagen(String utlImagenGoogle) { this.imagen = utlImagenGoogle; }
}
