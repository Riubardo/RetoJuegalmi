package com.example.tabbedtienda.ui.models.Llamadas;

import com.example.tabbedtienda.ui.models.Videojuego;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LlamadaVenta {
    private int id_cliente, id_empleado, id_direccion;
    private String fechacompra, fechafin;
    private ArrayList<Integer> videojuegos, dispositivos;

    public LlamadaVenta(int id_cliente, int id_direccion, String fechacompra, String fechafin, ArrayList<Integer> videojuegos, ArrayList<Integer> dispositivos) {
        this.id_cliente = id_cliente;
        this.id_direccion = id_direccion;
        this.fechacompra = fechacompra;
        this.fechafin = fechafin;
        this.videojuegos = videojuegos;
        this.dispositivos = dispositivos;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(String fechacompra) {
        this.fechacompra = fechacompra;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public ArrayList<Integer> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(ArrayList<Integer> videojuegos) {
        this.videojuegos = videojuegos;
    }

    public ArrayList<Integer> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(ArrayList<Integer> dispositivos) {
        this.dispositivos = dispositivos;
    }
}
