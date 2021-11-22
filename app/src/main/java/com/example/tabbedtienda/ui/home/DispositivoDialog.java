package com.example.tabbedtienda.ui.home;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tabbedtienda.MainActivity;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.Dispositivo;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaDispositivo;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaVideojuego;
import com.example.tabbedtienda.ui.models.ModeloDispositivo;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;
import com.example.tabbedtienda.ui.models.Videojuego;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
		View vista = (View) inflater.inflate(R.layout.dialog_ver_producto, container, false);
		flechaAtras = (ImageButton) vista.findViewById(R.id.flechaAtras);
		tvNombreDispositivo = (TextView) vista.findViewById(R.id.nombreProducto);
		ivImagenDispositivo = (ImageView) vista.findViewById(R.id.imagenProducto);
		tvDescripcionDispositivo = (TextView) vista.findViewById(R.id.descripcionProducto);
		Button btnAlquilar = vista.findViewById(R.id.btnProductoAlquilar);
		btnAlquilar.setWidth(0);
		((Button) vista.findViewById(R.id.btnProductoComprar)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Gson gson = new GsonBuilder()
						.setLenient()
						.create();
				Retrofit retrofit = new Retrofit.Builder()
						.baseUrl("https://arkadio.duckdns.org/ws/")
						.addConverterFactory(GsonConverterFactory.create(gson))
						.build();
				SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
				String fecha = fmt.format(Calendar.getInstance().getTime());
				LlamadaDispositivo llamadaDispositivo = new LlamadaDispositivo(modeloDispositivo.getId());
				RetroFittLlamadas retroFittLlamadas = retrofit.create(RetroFittLlamadas.class);
				Call<List<Dispositivo>> call = retroFittLlamadas.getDispositivo(llamadaDispositivo);
				call.enqueue(new Callback<List<Dispositivo>>() {
					@Override
					public void onResponse(Call<List<Dispositivo>> call, Response<List<Dispositivo>> response) {
						ArrayList<Dispositivo> dispositivos = MainActivity.mainActivity.getDispositivos();
						for (Dispositivo dispositivo: response.body()) {
							Log.d("pasa", "aqui");
							boolean esta = false;
							for (Dispositivo d: dispositivos)
								if (d.getId() == dispositivo.getId()){
									esta = true;
									break;
								}
								if (!esta) {
									Log.d("pasa", dispositivo.getId() + "");
									dispositivos.add(dispositivo);
									break;
								}
						}
						MainActivity.mainActivity.setDispositivos(dispositivos);
					}
					@Override
					public void onFailure(Call<List<Dispositivo>> call, Throwable t) {
						Log.d("pasa", "error");
						t.printStackTrace();
					}
				});
			}
		});
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
