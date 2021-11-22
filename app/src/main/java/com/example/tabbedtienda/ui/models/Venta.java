package com.example.tabbedtienda.ui.models;

import com.google.gson.annotations.SerializedName;

public class Venta {
    @SerializedName("id")
    private int id;
    @SerializedName("idCliente")
    private Cliente id_cliente;
    @SerializedName("idEmpleado")
    private Trabajador id_empleado;
    @SerializedName("fechacompra")
    private String fechacompra;
    @SerializedName("idDireccion")
    private Direccion id_direccion;

    public Venta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Trabajador getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Trabajador id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(String fechacompra) {
        this.fechacompra = fechacompra;
    }

    public Direccion getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Direccion id_direccion) {
        this.id_direccion = id_direccion;
    }
}
