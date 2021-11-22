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
import com.example.tabbedtienda.ui.models.ModeloDispositivo;
import com.example.tabbedtienda.ui.models.PeticionMarcas;
import com.example.tabbedtienda.ui.models.Plataforma;

import java.util.List;

public class DispositivosFragment extends Fragment {

	// RecyclerView
	RecyclerView recyclerView;
	RecyclerView.Adapter rvAdapter;
	RecyclerView.LayoutManager rvLayoutManger;
	List<PeticionMarcas> listaMarcas;
	Context context;
	public FragmentManager fragmentManager;
	private DispositivosViewModel dispositivosViewModel;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		dispositivosViewModel = new ViewModelProvider(this).get(DispositivosViewModel.class);


		View view = inflater.inflate(R.layout.new_fragment_dispositivo, null);

		// RecyclerView Categoria Setup
		recyclerView = (RecyclerView) view.findViewById(R.id.recyclerMarcas);
		rvLayoutManger = new LinearLayoutManager(getActivity());
		recyclerView.setLayoutManager(rvLayoutManger);


		//listaPlataformas = new ArrayList<>();
		dispositivosViewModel.dispositivosFragment = this;
		dispositivosViewModel.devuelveLista();

		return view;
	}

	public void setAdapter(){
		rvAdapter = new AdaptadorMarca(this, listaMarcas);
		recyclerView.setAdapter(rvAdapter);
	}


}
