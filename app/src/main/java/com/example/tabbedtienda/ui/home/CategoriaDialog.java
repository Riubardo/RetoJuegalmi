package com.example.tabbedtienda.ui.home;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.example.tabbedtienda.ui.models.Videojuego;

import java.util.ArrayList;

public class CategoriaDialog extends DialogFragment {

	//-----> Cosas de la Interfaz
	private ImageButton flechaAtras;
	private TextView tvNombreCategoria;
	private AdaptadorVideojuegoHome adaptadorVideojuegoHome;
	private ArrayList<Videojuego> listaVideojuegos;
	private Plataforma categoria;

	//-----> Cosas del Recycler
	RecyclerView recyclerViewVideojuego;
	RecyclerView.Adapter rvAdapterVideojuego;
	RecyclerView.LayoutManager rvLayoutMangerVideojuego;
	Fragment fragment;

	public CategoriaDialog(Plataforma categoria){
		super();
		this.categoria = categoria;
		this.listaVideojuegos = categoria.getListaVideojuegos();
	}

	@Override
	public void onCancel(DialogInterface dialog) { super.onCancel(dialog); }

	@Override
	public void onDetach() { super.onDetach(); }

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		Dialog dialog = super.onCreateDialog(savedInstanceState);
		dialog.setTitle("Ver Categoria");
		return dialog;
	}
	//Crear la vista (instancias etc)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View vista = (View) inflater.inflate(R.layout.dialog_ver_categoria, container, false);

		flechaAtras = (ImageButton) vista.findViewById(R.id.flechaAtras);
		tvNombreCategoria = (TextView) vista.findViewById(R.id.tvNombreCategoria);
		recyclerViewVideojuego = (RecyclerView) vista.findViewById(R.id.rvVideojuegoVerCategoria);
		return vista;
	}
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		//-----> HABILICAR BOTON ATRAS
		flechaAtras.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				dismiss();
			}
		});

		//-----> NOMBRE CATEGORIA
		tvNombreCategoria.setText(categoria.getPlataforma());


		//-----> RELLENAR RECYCLER VIEW
		rvAdapterVideojuego = new AdaptadorVideojuegoHome(this, listaVideojuegos);

		LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
		recyclerViewVideojuego.setLayoutManager(layoutManager);
		recyclerViewVideojuego.setAdapter(rvAdapterVideojuego);


	}
}
