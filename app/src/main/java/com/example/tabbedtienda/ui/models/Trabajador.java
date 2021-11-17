package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Trabajador {
    @SerializedName("id")
    private int id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("apellido1")
    private String apellido1;
    @SerializedName("apellido2")
    private String apellido2;
    @SerializedName("dni")
    private String dni;
    @SerializedName("telefono")
    private int telefono;
    @SerializedName("email")
    private String email;
    @SerializedName("contrasena")
    private String contrasena;
    @SerializedName("admin")
    private boolean admin;

    public Trabajador(String nombre, String apellido1, String apellido2, String dni, int telefono, String email, String contrasena, boolean admin){
        this.id=id;
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.dni=dni;
        this.telefono=telefono;
        this.email=email;
        this.contrasena=contrasena;
        this.admin=admin;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
