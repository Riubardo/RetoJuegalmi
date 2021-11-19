package com.example.tabbedtienda.ui.datos;

import com.example.tabbedtienda.ui.models.Cliente;
import com.example.tabbedtienda.ui.models.Login;
import com.example.tabbedtienda.ui.models.PeticionMarcas;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.example.tabbedtienda.ui.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetroFittLlamadas {
    @GET("plataformas/stock")
    Call<List<Plataforma>> getPlataformas();

    @POST("login")
    Call<Usuario> getLogin(@Body Login login);

    @GET("marcas/stock/telefonia")
    Call<List<PeticionMarcas>> getTelefonia();

    @GET("marcas/stock/consolas")
    Call<List<PeticionMarcas>> getConsolas();
}
