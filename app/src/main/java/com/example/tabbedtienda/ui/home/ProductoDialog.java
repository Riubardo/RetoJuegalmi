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
import com.example.tabbedtienda.ui.models.ModeloVideojuego;

import java.util.ArrayList;

public class ProductoDialog extends DialogFragment {

	//-----> Cosas de la Interfaz
	private ImageButton flechaAtras;
	private TextView tvNombreProducto;
	private ImageView ivImagenProducto;
	private TextView tvDescripcionProducto;
	private ArrayList<ModeloVideojuego> listaModeloVideojuegos;
	private ModeloVideojuego modeloVideojuego;

	//-----> Cosas del Recycler
	RecyclerView recyclerViewVideojuego;
	RecyclerView.Adapter rvAdapterVideojuego;
	RecyclerView.LayoutManager rvLayoutMangerVideojuego;
	Fragment fragment;

	public ProductoDialog(Fragment fragment, ModeloVideojuego modeloVideojuego){
		super();
		this.fragment = fragment;
		this.modeloVideojuego = modeloVideojuego;
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
		View vista = (View) inflater.inflate(R.layout.dialog_ver_producto, container, false);

		flechaAtras = (ImageButton) vista.findViewById(R.id.flechaAtras);
		tvNombreProducto = (TextView) vista.findViewById(R.id.nombreProducto);
		ivImagenProducto = (ImageView) vista.findViewById(R.id.imagenProducto);
		tvDescripcionProducto = (TextView) vista.findViewById(R.id.descripcionProducto);

		//-----> DATOS VIDEOJUEGO
		tvNombreProducto.setText(modeloVideojuego.getNombre());
		Glide.with(fragment.getContext()).load(modeloVideojuego.getImagen()).centerCrop().into(ivImagenProducto);
		tvDescripcionProducto.setText(modeloVideojuego.getDescripcion());


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
