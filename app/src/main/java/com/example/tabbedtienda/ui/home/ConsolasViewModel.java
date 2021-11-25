package com.example.tabbedtienda.ui.home;

import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tabbedtienda.MainActivity;
import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.PeticionMarcas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConsolasViewModel extends ViewModel implements Callback<List<PeticionMarcas>> {

	private List<PeticionMarcas> listaMarcas;
	private MutableLiveData<String> mText;
	public ConsolasFragment consolasFragment;

	public ConsolasViewModel() {
		mText = new MutableLiveData<>();
		mText.setValue("This is Consolas fragment");
	}
	public void devuelveLista(){
		/*
		AsyncTaskClass async = new AsynTaskManager().getInstance(consolasFragment.getContext());
		async.setConsolasFragment(this.consolasFragment);
		async.execute();
		*/

		//-----> MOSTRAR DIALOGO
		//MainActivity.dialogoCargando.cargarDialogo();
		Gson gson = new GsonBuilder()
				.setLenient()
				.create();
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://arkadio.duckdns.org/ws/")
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();
		RetroFittLlamadas retroFittLlamadas = retrofit.create(RetroFittLlamadas.class);
		Call<List<PeticionMarcas>> call = retroFittLlamadas.getConsolas();
		call.enqueue(this);


	}
	public LiveData<String> getText() {
		return mText;
	}

	public List<PeticionMarcas> getListaMarcas() {
		return listaMarcas;
	}

	public void setListaMarcas(List<PeticionMarcas> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}

	@Override
	public void onResponse(Call<List<PeticionMarcas>> call, Response<List<PeticionMarcas>> response) {
		if(response.isSuccessful()) {
			consolasFragment.listaMarcas = response.body();
			Log.e("", ""+consolasFragment.listaMarcas.size());
			consolasFragment.setAdapter();

			//-----> CERRAR DIALOGO
			//MainActivity.dialogoCargando.cerrarDialogo();
		} else {
			System.out.println(response.errorBody());
		}
	}
	@Override
	public void onFailure(Call<List<PeticionMarcas>> call, Throwable t) {

		//-----> CERRAR DIALOGO
		MainActivity.dialogoCargando.cerrarDialogo();
		t.printStackTrace();
	}
}