package com.example.tabbedtienda.ui.home;

import android.content.Context;
import android.util.Log;
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
import com.example.tabbedtienda.ui.models.ModeloDispositivo;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;

import java.util.ArrayList;

public class AdaptadorDispositivo extends RecyclerView.Adapter<AdaptadorDispositivo.ViewHolder> {

	private ArrayList<ModeloDispositivo> listaModeloDispositivos;
	private Fragment fragment;

	// -----> CLASE VIEWHOLDER
	public static class ViewHolder extends RecyclerView.ViewHolder {

		private final TextView nombreDispositivo;
		private ImageView image;
		private Context context;
		private CardView card;

		public ViewHolder(View view, Context context){
			super(view);
			this.context = context;
			image = (ImageView) view.findViewById(R.id.itemImage);
			nombreDispositivo = (TextView) view.findViewById(R.id.nombreDispositivo);
			card = (CardView) view.findViewById(R.id.cardDispositivo);
			this.context = context;
		}

		public TextView getTvNombre() { return nombreDispositivo; }
		public ImageView getImage() { return image; }
		public CardView getCard() { return card; }
	}

	// -----> CONSTRUCTOR ADAPTADOR: PIDE ARRAYLIST DE PLATAFORMAS
	public AdaptadorDispositivo(Fragment fragment, ArrayList<ModeloDispositivo> dataSet) {
		listaModeloDispositivos = dataSet;
		this.fragment = fragment;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
		// Create a new view, which defines the UI of the list item
		View view = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.recycler_dispositivo, viewGroup, false);

		return new ViewHolder(view, view.getContext());
	}

	// ----->> RELLENAR VISTAS CON LOS DATOS
	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
		//viewHolder.getTvNombre().setText(listaVideojuegos.get(position).getNombreJuego() + "(" + position+1 + "/" + this.getItemCount() +")");
		viewHolder.getTvNombre().setText(listaModeloDispositivos.get(position).getNombre());
		Log.e("oli","Imagen: "+listaModeloDispositivos.get(position).getImagen());
		Glide.with(viewHolder.context).load(listaModeloDispositivos.get(position).getImagen()).centerCrop().into(viewHolder.getImage());

		final DispositivoDialog dialog = new DispositivoDialog(fragment, (ModeloDispositivo) listaModeloDispositivos.get(position));

		viewHolder.getCard().setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.show( fragment.getChildFragmentManager(), "Ver Producto");
			}
		});

	}

	@Override
	public int getItemCount() {
		return listaModeloDispositivos.size();
	}

}
