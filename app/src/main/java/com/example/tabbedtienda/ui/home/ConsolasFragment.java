package com.example.tabbedtienda.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.models.PeticionMarcas;

import java.util.List;

public class ConsolasFragment extends Fragment {

	// RecyclerView
	RecyclerView recyclerView;
	RecyclerView.Adapter rvAdapter;
	RecyclerView.LayoutManager rvLayoutManger;
	List<PeticionMarcas> listaMarcas;
	Context context;
	public FragmentManager fragmentManager;
	private ConsolasViewModel consolasViewModel;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		consolasViewModel = new ViewModelProvider(this).get(ConsolasViewModel.class);


		View view = inflater.inflate(R.layout.new_fragment_videojuego, null);

		// RecyclerView Categoria Setup
		recyclerView = (RecyclerView) view.findViewById(R.id.recyclerHome);
		rvLayoutManger = new LinearLayoutManager(getActivity());
		recyclerView.setLayoutManager(rvLayoutManger);


		//listaPlataformas = new ArrayList<>();
		consolasViewModel.consolasFragment = this;
		consolasViewModel.devuelveLista();

		return view;
	}

	public void setAdapter(){
		rvAdapter = new AdaptadorMarca(this, listaMarcas);
		recyclerView.setAdapter(rvAdapter);
	}


}
