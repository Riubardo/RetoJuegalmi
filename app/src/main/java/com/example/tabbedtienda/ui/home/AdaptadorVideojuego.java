package com.example.tabbedtienda.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;

import java.util.ArrayList;

public class AdaptadorVideojuego extends RecyclerView.Adapter<AdaptadorVideojuego.ViewHolder> {

	private ArrayList<ModeloVideojuego> listaModeloVideojuegos;

	// -----> CLASE VIEWHOLDER
	public static class ViewHolder extends RecyclerView.ViewHolder {

		private final TextView nombreVideojuego;
		private Context context;
		public ViewHolder(View view, Context context){
			super(view);

			nombreVideojuego = (TextView) view.findViewById(R.id.nombreVideojuego);
			this.context = context;
		}

		public TextView getTvNombre() { return nombreVideojuego; }
	}

	// -----> CONSTRUCTOR ADAPTADOR: PIDE ARRAYLIST DE PLATAFORMAS
	public AdaptadorVideojuego(Context context, ArrayList<ModeloVideojuego> dataSet) {
		listaModeloVideojuegos = dataSet;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
		// Create a new view, which defines the UI of the list item
		View view = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.recycler_videojuego, viewGroup, false);

		return new ViewHolder(view, view.getContext());
	}

	// ----->> RELLENAR VISTAS CON LOS DATOS
	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
		//viewHolder.getTvNombre().setText(listaVideojuegos.get(position).getNombreJuego() + "(" + position+1 + "/" + this.getItemCount() +")");
		viewHolder.getTvNombre().setText(listaModeloVideojuegos.get(position).getNombre());
	}

	@Override
	public int getItemCount() {
		return listaModeloVideojuegos.size();
	}

}
