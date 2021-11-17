package com.example.tabbedtienda.ui.datos;

import com.example.tabbedtienda.ui.models.Cliente;
import com.example.tabbedtienda.ui.models.Plataforma;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetroFittLlamadas {
    @GET("plataformas/stock")
    Call<List<Plataforma>> getPlataformas();

    @POST("user/edit")
    Call<Cliente> setUser(@Field("usuario") String first, @Field("contrasena") String last);
}
