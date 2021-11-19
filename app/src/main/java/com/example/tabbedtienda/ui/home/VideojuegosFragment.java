package com.example.tabbedtienda.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.models.Plataforma;

import java.util.List;

public class VideojuegosFragment extends Fragment {

	// RecyclerView
	RecyclerView recyclerView;
	RecyclerView.Adapter rvAdapter;
	RecyclerView.LayoutManager rvLayoutManger;
	List<Plataforma> listaPlataformas;
	ImageButton userButton;
	Context context;
	public FragmentManager fragmentManager;
	private VideojuegosViewModel videojuegosViewModel;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		videojuegosViewModel = new ViewModelProvider(this).get(VideojuegosViewModel.class);


		View view = inflater.inflate(R.layout.new_fragment_videojuego, null);

		// RecyclerView Categoria Setup
		recyclerView = (RecyclerView) view.findViewById(R.id.recyclerHome);
		rvLayoutManger = new LinearLayoutManager(getActivity());
		recyclerView.setLayoutManager(rvLayoutManger);


		//listaPlataformas = new ArrayList<>();
		videojuegosViewModel.videojuegosFragment = this;
		videojuegosViewModel.devuelveLista();

		return view;
	}

	public void setAdapter(){
		rvAdapter = new AdaptadorPlataforma(this, listaPlataformas);
		recyclerView.setAdapter(rvAdapter);
	}


}
