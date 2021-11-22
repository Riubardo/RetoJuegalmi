package com.example.tabbedtienda.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tabbedtienda.LogedDialogFragment;
import com.example.tabbedtienda.LoginDialogFragment;
import com.example.tabbedtienda.MainActivity;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.Llamadas.Login;
import com.example.tabbedtienda.ui.models.ModeloDispositivo;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.example.tabbedtienda.ui.models.ResultadoBuscada;
import com.example.tabbedtienda.ui.models.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

	// RecyclerView
	RecyclerView recyclerView;
	RecyclerView.Adapter rvAdapter;
	RecyclerView.LayoutManager rvLayoutManger;
	List<Plataforma> listaPlataformas;
	ImageButton userButton;
	Context context;
	public FragmentManager fragmentManager;

	private SearchView buscador;
	ResultadoBuscada resultadoBusqueda = new ResultadoBuscada();


	private LoginDialogFragment dialog = null;
	private HomeViewModel homeViewModel;


	public FragmentManager getHomeFM(){
		return fragmentManager;
	}

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

		View view = inflater.inflate(R.layout.fragment_home, null);

		// RecyclerView Categoria Setup
		recyclerView = (RecyclerView) view.findViewById(R.id.recyclerHome);
		rvLayoutManger = new LinearLayoutManager(getActivity());
		recyclerView.setLayoutManager(rvLayoutManger);


		//listaPlataformas = new ArrayList<>();
		homeViewModel.homeFragment = this;
		homeViewModel.devuelveLista();

		buscador = (SearchView) view.findViewById(R.id.searchView);
		buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
			@Override
			public boolean onQueryTextSubmit(String s) {

				buscar(s);

				return false;
			}

			@Override
			public boolean onQueryTextChange(String s) {

				return false;
			}
		});

		userButton = (ImageButton) view.findViewById(R.id.userButton);
		userButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (MainActivity.mainActivity.getLogeado() == null){
					dialog = new LoginDialogFragment();
					dialog.show(fragmentManager, "login");
				}else {
					LogedDialogFragment loged = new LogedDialogFragment();
					loged.show(fragmentManager,"loged");
				}

			}
		});


		return view;

	}

	public void setAdapter(){
		rvAdapter = new AdaptadorPlataforma(this, listaPlataformas);
		recyclerView.setAdapter(rvAdapter);
	}
	@Override
	public void onAttach(@NonNull Context context) {
		super.onAttach(context);
		this.context=context;
		fragmentManager = getChildFragmentManager();
	}



	public void buscar(String s){

		Gson gson = new GsonBuilder()
				.setLenient()
				.create();
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://arkadio.duckdns.org/ws/")
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();
		RetroFittLlamadas retroFittLlamadas = retrofit.create(RetroFittLlamadas.class);
		Call<ResultadoBuscada> call = retroFittLlamadas.getBusqueda(s);
		call.enqueue(new Callback<ResultadoBuscada>() {
			@Override
			public void onResponse(Call<ResultadoBuscada> call, Response<ResultadoBuscada> response) {
				//if(response.isSuccessful()) {
					resultadoBusqueda = response.body();
//				assert resultadoBusqueda != null;
     			Log.d("algo2", resultadoBusqueda.toString());

				//} else {
					//System.out.println(response.errorBody());
					//Log.d("algo1", "mal"+response.errorBody());
				//}
			}

			@Override
			public void onFailure(Call<ResultadoBuscada> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

}