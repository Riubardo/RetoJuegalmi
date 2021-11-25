package com.example.tabbedtienda.ui.datos;

import com.example.tabbedtienda.ui.models.Cliente;
import com.example.tabbedtienda.ui.models.Direccion;
import com.example.tabbedtienda.ui.models.Dispositivo;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaBusqueda;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaDeleteDirection;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaDireccion;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaDispositivo;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaLocation;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaVenta;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaVideojuego;
import com.example.tabbedtienda.ui.models.Llamadas.Login;
import com.example.tabbedtienda.ui.models.Llamadas.PlataformasModeloJuego;
import com.example.tabbedtienda.ui.models.Llamadas.Respuesta;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;
import com.example.tabbedtienda.ui.models.PeticionMarcas;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.example.tabbedtienda.ui.models.ResultadoBuscada;
import com.example.tabbedtienda.ui.models.Tiene;
import com.example.tabbedtienda.ui.models.Usuario;
import com.example.tabbedtienda.ui.models.Videojuego;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetroFittLlamadas {
    @GET("plataformas/stock")
    Call<List<Plataforma>> getPlataformas();

    @GET("marcas/stock/telefonia")
    Call<List<PeticionMarcas>> getTelefonia();

    @GET("marcas/stock/consolas")
    Call<List<PeticionMarcas>> getConsolas();

    @POST("login")
    Call<Usuario> getLogin(@Body Login login);

    @POST("plataformas/modeloJuego")
    Call<List<Plataforma>> getPlataformasModeloJuego(@Body PlataformasModeloJuego plataformasModeloJuego);

    @POST("videojuego")
    Call<List<Videojuego>> getVideojuego(@Body LlamadaVideojuego llamadaVideojuego);

    @POST("dispositivo")
    Call<List<Dispositivo>> getDispositivo(@Body LlamadaDispositivo llamadaDispositivo);

    @POST("direcciones/usuario")
    Call<List<Direccion>> getDirecciones(@Body LlamadaDireccion llamadaDireccion);

    @POST("busqueda")
    Call<ResultadoBuscada> getBuscador(@Body LlamadaBusqueda llamadaBusqueda);

    @POST("insertar/venta")
    Call<Respuesta> setVenta(@Body LlamadaVenta llamadaVenta);

    @POST("tiene")
    Call<Tiene> getTiene(@Body LlamadaDeleteDirection llamadaDeleteDirection);

    @PUT("update/cliente")
    Call<Respuesta> updateLocalizacion(@Body LlamadaLocation llamadaLocation);

    @DELETE("delete/tiene/{idCliente}/{idDireccion}")
    Call<Respuesta> deleteItem(@Path("idCliente") int itemId, @Path("idDireccion") int item);
}
