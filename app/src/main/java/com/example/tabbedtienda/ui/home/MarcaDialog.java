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
import com.example.tabbedtienda.ui.models.ModeloDispositivo;
import com.example.tabbedtienda.ui.models.PeticionMarcas;

import java.util.ArrayList;

public class MarcaDialog extends DialogFragment {

	//-----> Cosas de la Interfaz
	private ImageButton flechaAtras;
	private TextView tvNombreMarca;
	private AdaptadorVideojuegoHome adaptadorDispositivo;
	private ArrayList<ModeloDispositivo> listaModeloDispositivos;
	private PeticionMarcas marca;

	//-----> Cosas del Recycler
	RecyclerView recyclerViewDispositivo;
	RecyclerView.Adapter rvAdapterDispositivo;
	RecyclerView.LayoutManager rvLayoutManagerDispositivo;
	Fragment fragment;

	public MarcaDialog(PeticionMarcas marca){
		super();
		this.marca = marca;
		this.listaModeloDispositivos = marca.getDispositivo();
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
		View vista = (View) inflater.inflate(R.layout.dialog_ver_marca, container, false);

		flechaAtras = (ImageButton) vista.findViewById(R.id.flechaAtras);
		tvNombreMarca = (TextView) vista.findViewById(R.id.tvNombreMarca);
		recyclerViewDispositivo = (RecyclerView) vista.findViewById(R.id.rvDispositivoVerMarca);
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
		tvNombreMarca.setText(marca.getNombre());


		//-----> RELLENAR RECYCLER VIEW
		rvAdapterDispositivo = new AdaptadorDispositivo(this, listaModeloDispositivos);

		LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
		recyclerViewDispositivo.setLayoutManager(layoutManager);
		recyclerViewDispositivo.setAdapter(rvAdapterDispositivo);


	}
}
