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
import com.example.tabbedtienda.ui.models.Plataforma;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPlataforma extends RecyclerView.Adapter<AdaptadorPlataforma.ViewHolder> {

	private List<Plataforma> listaPlataformas;

	RecyclerView recyclerViewVideojuego;
	RecyclerView.Adapter rvAdapterVideojuego;
	RecyclerView.LayoutManager rvLayoutMangerVideojuego;
	Fragment fragment;


	// -----> CLASE VIEWHOLDER
	public static class ViewHolder extends RecyclerView.ViewHolder {


		private final TextView nombrePlataforma;
		private RecyclerView rvCategoria;
		private Context context;
		public ViewHolder(View view, Context context){
			super(view);

			// Define click listener for the ViewHolder's View -> ???
			nombrePlataforma = (TextView) view.findViewById(R.id.nombrePlataforma);
			//idPlataforma = (TextView) view.findViewById(R.id.idPlataforma);
			//cantidadPlataforma = (TextView) view.findViewById(R.id.cantidadPlataforma);
			rvCategoria =(RecyclerView) view.findViewById(R.id.rvCategoria);
			this.context = context;
		}

		public TextView getTvNombre() { return nombrePlataforma; }
		//public TextView getTvId() { return idPlataforma; }
		//public TextView getTvCantidad() { return cantidadPlataforma; }
		public Context getContext() { return context; }
		public RecyclerView getRecyclerCategoria() { return rvCategoria; }
	}

	// -----> CONSTRUCTOR ADAPTADOR: PIDE ARRAYLIST DE PLATAFORMAS
	public AdaptadorPlataforma(Fragment fragmento, List<Plataforma> dataSet) {
		listaPlataformas = dataSet;
		this.fragment = fragmento;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
		// Create a new view, which defines the UI of the list item
		View view = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.recycler_categoria, viewGroup, false);


		// RecyclerView Categoria Setup
		recyclerViewVideojuego = (RecyclerView)view.findViewById(R.id.rvCategoria);
		rvLayoutMangerVideojuego = new LinearLayoutManager(view.getContext());
		recyclerViewVideojuego.setLayoutManager(rvLayoutMangerVideojuego);

		return new ViewHolder(view, view.getContext());
	}

	// ----->> RELLENAR VISTAS CON LOS DATOS
	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
		//viewHolder.getTvNombre().setText(listaPlataformas.get(position).getPlataforma() + " (" + listaPlataformas.get(position).getListaVideojuegos().size() +" juegos) ->");
		viewHolder.getTvNombre().setText(listaPlataformas.get(position).getPlataforma() + ":");

		final CategoriaDialog dialog = new CategoriaDialog((Plataforma)listaPlataformas.get(position));
		viewHolder.getTvNombre().setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.show( fragment.getChildFragmentManager(), "Ver Categoria");

			}
		});

		//viewHolder.getTvId().setText("ID: " + listaPlataformas.get(position).getId());


		ArrayList<ModeloVideojuego> listaModeloVideojuegos = listaPlataformas.get(position).getListaVideojuegos();
		rvAdapterVideojuego = new AdaptadorVideojuegoHome(fragment , listaModeloVideojuegos);

		LinearLayoutManager layoutManager = new LinearLayoutManager(viewHolder.getContext(), LinearLayoutManager.HORIZONTAL, false);
		viewHolder.getRecyclerCategoria().setLayoutManager(layoutManager);
		viewHolder.getRecyclerCategoria().setAdapter(rvAdapterVideojuego);

	}

	@Override
	public int getItemCount() {
		return listaPlataformas.size();
	}

}
