package com.example.tabbedtienda.ui.datos;

import android.util.Log;

import com.example.tabbedtienda.ui.models.Plataforma;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ModelajeJSON {

	//----->> FUNCIÓN: PLATAFORMAS/STOCK
	//Coge la respuesta de PLATAFORMAS/STOCK y devuelve un array de Objetos Plataforma, que tienen ID y array de Videojuegos
	public static ArrayList<Plataforma> plataformasStockParser(String responseJSON){

		ArrayList<Plataforma> listaPlataformas = new ArrayList<Plataforma>();

		try {
			JSONArray jsonArrayPlataformas = new JSONArray(responseJSON);
			for (int i = 0; i < jsonArrayPlataformas.length(); i++) {
				JSONObject miJsonPlataforma = jsonArrayPlataformas.getJSONObject(i);

				Log.e("", "Plataforma: " + miJsonPlataforma.getString("plataforma"));
					int miId = miJsonPlataforma.getInt("id");
					String miNombre = miJsonPlataforma.getString("plataforma");
					JSONArray miJsonVideojuegos = miJsonPlataforma.getJSONArray("juego");
					ArrayList<ModeloVideojuego> miListaModeloVideojuegos = new ArrayList<ModeloVideojuego>();
					for (int j = 0; j < miJsonVideojuegos.length(); j++){
						JSONObject miJsonVideojuego = miJsonVideojuegos.getJSONObject(j);
						miListaModeloVideojuegos.add(new ModeloVideojuego(
								miJsonVideojuego.getString("nombre"),
								miJsonVideojuego.getString("descripcion"),
								miJsonVideojuego.getInt("pegi"),
								miJsonVideojuego.getString("desarrolladora"),
								(float)miJsonVideojuego.getLong("precioVenta"),
								(float)miJsonVideojuego.getLong("precioAlquiler"),
								miJsonVideojuego.getString("imagen")
						));
					}

				Plataforma miPlataforma = new Plataforma(
						miJsonPlataforma.getString("plataforma"),
						miListaModeloVideojuegos
				);

				listaPlataformas.add(miPlataforma);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return listaPlataformas;
	}
}
