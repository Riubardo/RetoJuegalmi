package com.example.tabbedtienda.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.models.ModeloDispositivo;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;
import com.example.tabbedtienda.ui.models.PeticionMarcas;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorMarca extends RecyclerView.Adapter<AdaptadorMarca.ViewHolder> {

	private List<PeticionMarcas> listaMarcas;

	RecyclerView recyclerViewDispositivo;
	RecyclerView.Adapter rvAdapterVideojuego;
	RecyclerView.LayoutManager rvLayoutManagerDispositivo;
	Fragment fragment;


	// -----> CLASE VIEWHOLDER
	public static class ViewHolder extends RecyclerView.ViewHolder {


		private final TextView nombreMarca;
		private RecyclerView rvDispositivos;
		private Context context;
		public ViewHolder(View view, Context context){
			super(view);

			// Define click listener for the ViewHolder's View -> ???
			nombreMarca = (TextView) view.findViewById(R.id.nombreMarca);
			rvDispositivos =(RecyclerView) view.findViewById(R.id.rvDispositivos);
			this.context = context;
		}

		public TextView getTvNombre() { return nombreMarca; }
		public Context getContext() { return context; }
		public RecyclerView getRecyclerCategoria() { return rvDispositivos; }
	}

	// -----> CONSTRUCTOR ADAPTADOR: PIDE ARRAYLIST DE PLATAFORMAS
	public AdaptadorMarca(Fragment fragmento, List<PeticionMarcas> dataSet) {
		listaMarcas = dataSet;
		this.fragment = fragmento;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
		// Create a new view, which defines the UI of the list item
		View view = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.recycler_marca, viewGroup, false);


		// RecyclerView Categoria Setup
		recyclerViewDispositivo = (RecyclerView)view.findViewById(R.id.rvDispositivos);
		rvLayoutManagerDispositivo = new LinearLayoutManager(view.getContext());
		recyclerViewDispositivo.setLayoutManager(rvLayoutManagerDispositivo);

		return new ViewHolder(view, view.getContext());
	}

	// ----->> RELLENAR VISTAS CON LOS DATOS
	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
		//viewHolder.getTvNombre().setText(listaPlataformas.get(position).getPlataforma() + " (" + listaPlataformas.get(position).getListaVideojuegos().size() +" juegos) ->");
		viewHolder.getTvNombre().setText(listaMarcas.get(position).getNombre() + ":");

		final MarcaDialog dialog = new MarcaDialog((PeticionMarcas) listaMarcas.get(position));
		viewHolder.getTvNombre().setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.show( fragment.getChildFragmentManager(), "Ver Marca");

			}
		});

		//viewHolder.getTvId().setText("ID: " + listaPlataformas.get(position).getId());


		ArrayList<ModeloDispositivo> listaDispositivos = listaMarcas.get(position).getDispositivo();
		rvAdapterVideojuego = new AdaptadorDispositivo(fragment , listaDispositivos);

		LinearLayoutManager layoutManager = new LinearLayoutManager(viewHolder.getContext(), LinearLayoutManager.HORIZONTAL, false);
		viewHolder.getRecyclerCategoria().setLayoutManager(layoutManager);
		viewHolder.getRecyclerCategoria().setAdapter(rvAdapterVideojuego);

	}

	@Override
	public int getItemCount() {
		return listaMarcas.size();
	}

}
