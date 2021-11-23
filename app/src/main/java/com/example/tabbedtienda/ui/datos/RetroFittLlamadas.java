package com.example.tabbedtienda.ui.datos;

import com.example.tabbedtienda.ui.models.Dispositivo;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaDispositivo;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaVideojuego;
import com.example.tabbedtienda.ui.models.Llamadas.Login;
import com.example.tabbedtienda.ui.models.Llamadas.PlataformasModeloJuego;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;
import com.example.tabbedtienda.ui.models.PeticionMarcas;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.example.tabbedtienda.ui.models.ResultadoBuscada;
import com.example.tabbedtienda.ui.models.Usuario;
import com.example.tabbedtienda.ui.models.Videojuego;

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

    @POST("videojuego")
    Call<List<Videojuego>> getVideojuego(@Body LlamadaVideojuego llamadaVideojuego);

    @POST("dispositivo")
    Call<List<Dispositivo>> getDispositivo(@Body LlamadaDispositivo llamadaDispositivo);

    @GET("marcas/stock/telefonia")
    Call<List<PeticionMarcas>> getTelefonia();

    @GET("marcas/stock/consolas")
    Call<List<PeticionMarcas>> getConsolas();

    @POST("busqueda")
    Call<ResultadoBuscada> getBuscador(@Body String s);
}
