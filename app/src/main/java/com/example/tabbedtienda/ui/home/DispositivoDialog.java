package com.example.tabbedtienda.ui.home;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.models.ModeloDispositivo;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;

import java.util.ArrayList;

public class DispositivoDialog extends DialogFragment {

	//-----> Cosas de la Interfaz
	private ImageButton flechaAtras;
	private TextView tvNombreDispositivo;
	private ImageView ivImagenDispositivo;
	private TextView tvDescripcionDispositivo;
	private ArrayList<ModeloDispositivo> listaModeloDispositivos;
	private ModeloDispositivo modeloDispositivo;

	//-----> Cosas del Recycler
	RecyclerView recyclerViewDispositivo;
	RecyclerView.Adapter rvAdapterDispositivo;
	RecyclerView.LayoutManager rvLayoutMangerDispositivo;
	Fragment fragment;

	public DispositivoDialog(Fragment fragment, ModeloDispositivo modeloDispositivo){
		super();
		this.fragment = fragment;
		this.modeloDispositivo = modeloDispositivo;
	}

	@Override
	public void onCancel(DialogInterface dialog) { super.onCancel(dialog); }

	@Override
	public void onDetach() { super.onDetach(); }

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		Dialog dialog = super.onCreateDialog(savedInstanceState);
		dialog.setTitle("Ver Producto");
		return dialog;
	}
	//Crear la vista (instancias etc)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View vista = (View) inflater.inflate(R.layout.dialog_ver_dispositivo, container, false);

		flechaAtras = (ImageButton) vista.findViewById(R.id.flechaAtras);
		tvNombreDispositivo = (TextView) vista.findViewById(R.id.nombreDispositivo);
		ivImagenDispositivo = (ImageView) vista.findViewById(R.id.imagenDispositivo);
		tvDescripcionDispositivo = (TextView) vista.findViewById(R.id.descripcionDispositivo);

		//-----> DATOS VIDEOJUEGO
		tvNombreDispositivo.setText(modeloDispositivo.getNombre());
		Glide.with(fragment.getContext()).load(modeloDispositivo.getImagen()).centerCrop().into(ivImagenDispositivo);
		tvDescripcionDispositivo.setText(modeloDispositivo.getDescripcion());


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





	}
}
