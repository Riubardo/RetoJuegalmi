package com.example.tabbedtienda.ui.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int telefono;
    private String email;
    private String contrasena;
    private String imagen;
    private double latitud;
    private double longitud;

    public Cliente(int id, String nombre, String apellido1,String apellido2,int telefono,String email,String contrasena,String imagen,double latitud,double longitud){
        this.id = id;
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.telefono=telefono;
        this.email= email;
        this.contrasena=contrasena;
        this.imagen=imagen;
        this.latitud=latitud;
        this.longitud=longitud;
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

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
