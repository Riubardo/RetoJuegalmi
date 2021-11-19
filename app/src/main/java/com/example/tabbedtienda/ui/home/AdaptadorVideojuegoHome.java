package com.example.tabbedtienda.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;

import java.util.ArrayList;

public class AdaptadorVideojuegoHome extends RecyclerView.Adapter<AdaptadorVideojuegoHome.ViewHolder> {

	private ArrayList<ModeloVideojuego> listaModeloVideojuegos;
	private String tipoVista;
	private Fragment fragment;

	// -----> CLASE VIEWHOLDER
	public static class ViewHolder extends RecyclerView.ViewHolder {

		private final TextView nombreVideojuego;
		private Context context;
		private ImageView image;
		private CardView card;

		public ViewHolder(View view, Context context){
			super(view);

			// Define click listener for the ViewHolder's View -> ???
			nombreVideojuego = (TextView) view.findViewById(R.id.nombreVideojuego);
			//idVideojuego = (TextView) view.findViewById(R.id.idVideojuego);
			image = (ImageView) view.findViewById(R.id.itemImage);
			card = (CardView) view.findViewById(R.id.cardVideojuego);
			this.context = context;
		}

		public TextView getTvNombre() { return nombreVideojuego; }
		//public TextView getTvId() { return idVideojuego; }
		public ImageView getImage() { return image; }
		public CardView getCard() { return card; }
	}

	// -----> CONSTRUCTOR ADAPTADOR: PIDE ARRAYLIST DE PLATAFORMAS
	public AdaptadorVideojuegoHome(Fragment fragment, ArrayList<ModeloVideojuego> dataSet) {
		listaModeloVideojuegos = dataSet;
		this.fragment = fragment;
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
		//viewHolder.getTvId().setText("ID: " + listaVideojuegos.get(position).getId());
		Glide.with(viewHolder.context).load(listaModeloVideojuegos.get(position).getImagen()).centerCrop().into(viewHolder.getImage());

		final ProductoDialog dialog = new ProductoDialog(fragment, (ModeloVideojuego) listaModeloVideojuegos.get(position));

		viewHolder.getCard().setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.show( fragment.getChildFragmentManager(), "Ver Producto");
			}
		});

	}

	@Override
	public int getItemCount() {
		return listaModeloVideojuegos.size();
	}

}
