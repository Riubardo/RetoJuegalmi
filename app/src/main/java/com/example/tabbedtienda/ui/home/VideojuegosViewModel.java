package com.example.tabbedtienda.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideojuegosViewModel extends ViewModel implements Callback<List<Plataforma>> {

	private List<Plataforma> listaPlataformas;
	private MutableLiveData<String> mText;
	public VideojuegosFragment videojuegosFragment;

	public VideojuegosViewModel() {
		mText = new MutableLiveData<>();
		mText.setValue("This is Videojuegos fragment");
	}
	public void devuelveLista(){
		Gson gson = new GsonBuilder()
				.setLenient()
				.create();
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://arkadio.duckdns.org/ws/")
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();
		RetroFittLlamadas retroFittLlamadas = retrofit.create(RetroFittLlamadas.class);
		Call<List<Plataforma>> call = retroFittLlamadas.getPlataformas();
		call.enqueue(this);

	}
	public LiveData<String> getText() {
		return mText;
	}

	public List<Plataforma> getListaPlataformas() {
		return listaPlataformas;
	}

	public void setListaPlataformas(List<Plataforma> listaPlataformas) {
		this.listaPlataformas = listaPlataformas;
	}

	@Override
	public void onResponse(Call<List<Plataforma>> call, Response<List<Plataforma>> response) {
		if(response.isSuccessful()) {
			videojuegosFragment.listaPlataformas = response.body();
			Log.e("", ""+videojuegosFragment.listaPlataformas.size());
			videojuegosFragment.setAdapter();
		} else {
			System.out.println(response.errorBody());
		}
	}
	@Override
	public void onFailure(Call<List<Plataforma>> call, Throwable t) {
		t.printStackTrace();
	}
}