package com.example.tabbedtienda.ui.datos;

import com.example.tabbedtienda.ui.models.Llamadas.Login;
import com.example.tabbedtienda.ui.models.Llamadas.PlataformasModeloJuego;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.example.tabbedtienda.ui.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetroFittLlamadas {
    @GET("plataformas/stock")
    Call<List<Plataforma>> getPlataformas();

    @POST("login")
    Call<Usuario> getLogin(@Body Login login);

    @POST("plataformas/modeloJuego")
    Call<List<Plataforma>> getPlataformasModeloJuego(@Body PlataformasModeloJuego plataformasModeloJuego);
}
