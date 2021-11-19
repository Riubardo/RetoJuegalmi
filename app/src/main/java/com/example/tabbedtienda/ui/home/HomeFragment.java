package com.example.tabbedtienda.ui.home;

import static android.app.appsearch.AppSearchResult.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabbedtienda.LogedDialogFragment;
import com.example.tabbedtienda.LoginDialogFragment;
import com.example.tabbedtienda.MainActivity;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.databinding.FragmentHomeBinding;
import com.example.tabbedtienda.ui.datos.ModelajeJSON;
import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.Login;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.example.tabbedtienda.ui.models.Usuario;
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
	ArrayList<Plataforma> array = new ArrayList<>();
	ArrayList<Plataforma> filteredarray = new ArrayList<>();


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
				return false;
			}

			@Override
			public boolean onQueryTextChange(String s) {
				getFilter().filter(s);
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

	public Filter getFilter(){
		return new Filter(){

			@Override
			protected FilterResults performFiltering(CharSequence charSequence) {
				String searhString = charSequence.toString();

				if(searhString.isEmpty()){

					filteredarray = array;
				}else{
					ArrayList<Plataforma> tempFilteredList = new ArrayList<>();

					for (Plataforma plataforma : array){

						if(plataforma.getListaVideojuegos().contains(searhString)){
							tempFilteredList.add(plataforma);
						}
					}
					filteredarray = tempFilteredList;
				}
				FilterResults filterResults = new FilterResults();
				filterResults.values = filteredarray;
				return filterResults;
			}

			@Override
			protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
				filteredarray = (ArrayList<Plataforma>) filterResults.values;
				rvAdapter.notifyDataSetChanged();
			}
		};
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

}