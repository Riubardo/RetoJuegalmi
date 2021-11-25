package com.example.tabbedtienda.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.models.ResultadoBuscada;

public class AdaptadorResultadosBusqueda extends RecyclerView.Adapter<AdaptadorResultadosBusqueda.ViewHolder>{
    private ResultadoBuscada listaResultadoBusqueda;

    public AdaptadorResultadosBusqueda(Context context, ResultadoBuscada dataSet) {
        listaResultadoBusqueda = dataSet;
    }

    public void setListaResultadoBusqueda(ResultadoBuscada listaResultadoBusqueda) {
        this.listaResultadoBusqueda = listaResultadoBusqueda;
        notifyDataSetChanged();
    }

    // -----> CLASE VIEWHOLDER
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView nombreBusqueda;
        private final ImageView imagen;
        private Context context;
        public ViewHolder(View view, Context context){
            super(view);
            imagen = (ImageView) view.findViewById(R.id.itemImage);
            nombreBusqueda = (TextView) view.findViewById(R.id.nombreBusqueda);

            this.context = context;
        }

        public TextView getTvNombre() { return nombreBusqueda; }
        public ImageView getImagen() { return imagen; }
    }


    @NonNull
    @Override
    public AdaptadorResultadosBusqueda.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_busqueda, viewGroup, false);

        return new AdaptadorResultadosBusqueda.ViewHolder(view, view.getContext());
    }

    // ----->> RELLENAR VISTAS CON LOS DATOS
    @Override
    public void onBindViewHolder(@NonNull AdaptadorResultadosBusqueda.ViewHolder viewHolder, int position) {
        //viewHolder.getTvNombre().setText(listaVideojuegos.get(position).getNombreJuego() + "(" + position+1 + "/" + this.getItemCount() +")");
        if (position < listaResultadoBusqueda.getArrayModeloVideojuego().size() ){
            viewHolder.getTvNombre().setText(listaResultadoBusqueda.getArrayModeloVideojuego().get(position).getNombre());
            Glide.with(viewHolder.context).load(listaResultadoBusqueda.getArrayModeloVideojuego().get(position).getImagen()).centerCrop().into(viewHolder.getImagen());

        }else{
            viewHolder.getTvNombre().setText(listaResultadoBusqueda.getArrayModeloDispositivo().get(position-listaResultadoBusqueda.getArrayModeloVideojuego().size()).getNombre());
            Glide.with(viewHolder.context).load(listaResultadoBusqueda.getArrayModeloDispositivo().get(position-listaResultadoBusqueda.getArrayModeloVideojuego().size()).getImagen()).centerCrop().into(viewHolder.getImagen());
        }

    }

    @Override
    public int getItemCount() {
        int tamano = listaResultadoBusqueda.getArrayModeloVideojuego().size() + listaResultadoBusqueda.getArrayModeloDispositivo().size();
        return tamano;
    }

}
