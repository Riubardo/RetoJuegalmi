package com.example.tabbedtienda.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.PeticionMarcas;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DispositivosViewModel extends ViewModel implements Callback<List<PeticionMarcas>> {

	private List<PeticionMarcas> listaMarcas;
	private MutableLiveData<String> mText;
	public DispositivosFragment dispositivosFragment;

	public DispositivosViewModel() {
		mText = new MutableLiveData<>();
		mText.setValue("This is Dispositivos fragment");
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
		Call<List<PeticionMarcas>> call = retroFittLlamadas.getTelefonia();
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
			dispositivosFragment.listaMarcas = response.body();
			Log.e("", ""+dispositivosFragment.listaMarcas.size());
			dispositivosFragment.setAdapter();
		} else {
			System.out.println(response.errorBody());
		}
	}
	@Override
	public void onFailure(Call<List<PeticionMarcas>> call, Throwable t) {
		t.printStackTrace();
	}
}