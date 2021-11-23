package com.example.tabbedtienda.ui.home;

import static android.app.appsearch.AppSearchResult.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.tabbedtienda.LogedDialogFragment;
import com.example.tabbedtienda.LoginDialogFragment;
import com.example.tabbedtienda.MainActivity;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.databinding.FragmentHomeBinding;
import com.example.tabbedtienda.ui.datos.ModelajeJSON;
import com.example.tabbedtienda.databinding.FragmentHomeBinding;
import com.example.tabbedtienda.ui.datos.ModelajeJSON;
import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.PeticionMarcas;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.example.tabbedtienda.ui.models.ResultadoBuscada;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
	ResultadoBuscada resultadoBuscada = new ResultadoBuscada();


	private LoginDialogFragment dialog = null;
	private HomeViewModel homeViewModel;
	private FragmentHomeBinding binding;

	TabLayout tabLayout;
	ViewPager viewPager;

	public FragmentManager getHomeFM(){
		return fragmentManager;
	}

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.new_fragment_home, null);

		buscador = (SearchView) view.findViewById(R.id.searchView) ;
		buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
			@Override
			public boolean onQueryTextSubmit(String s) {
				buscar(s);
				return false;
			}

			private void buscar(String s) {
				Gson gson = new GsonBuilder()
						.setLenient()
						.create();
				Retrofit retrofit = new Retrofit.Builder()
						.baseUrl("https://arkadio.duckdns.org/ws/")
						.addConverterFactory(GsonConverterFactory.create(gson))
						.build();
				RetroFittLlamadas retroFittLlamadas = retrofit.create(RetroFittLlamadas.class);
				Call<ResultadoBuscada> call = retroFittLlamadas.getBuscador(s);

				call.enqueue(new RespuestaBusqueda());
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

	class RespuestaBusqueda implements Callback<ResultadoBuscada> {

		@Override
		public void onResponse(Call<ResultadoBuscada> call, Response<ResultadoBuscada> response) {
			resultadoBuscada = response.body();
			//Log.d("algo", resultadoBuscada.getArrayModeloVideojuego().get(0).getDescripcion());
		}

		@Override
		public void onFailure(Call<ResultadoBuscada> call, Throwable t) {
			Toast.makeText(getContext(), "Algo ha fallado, por favor vuelva a intentarlo en otro momento.", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		AdaptadorViewPager adaptadorTienda = new AdaptadorViewPager(getChildFragmentManager());
		viewPager=view.findViewById(R.id.viewPager);
		tabLayout=view.findViewById(R.id.tabLayout);
		viewPager.setAdapter(adaptadorTienda);
		tabLayout.setupWithViewPager(viewPager);

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


	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}

}