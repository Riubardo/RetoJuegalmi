package com.example.tabbedtienda.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.models.ResultadoBuscada;

public class AdaptadorResultadosBusqueda extends RecyclerView.Adapter<AdaptadorResultadosBusqueda.ViewHolder>{
    private ResultadoBuscada listaResultadoBusqueda;

    public AdaptadorResultadosBusqueda(Context context, ResultadoBuscada dataSet) {
        listaResultadoBusqueda = dataSet;
    }

    // -----> CLASE VIEWHOLDER
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView nombreBusqueda;
        private Context context;
        public ViewHolder(View view, Context context){
            super(view);

            nombreBusqueda = (TextView) view.findViewById(R.id.nombreBusqueda);
            this.context = context;
        }

        public TextView getTvNombre() { return nombreBusqueda; }
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

        }else{
            viewHolder.getTvNombre().setText(listaResultadoBusqueda.getArrayModeloDispositivo().get(position-listaResultadoBusqueda.getArrayModeloVideojuego().size()).getNombre());
        }

    }

    @Override
    public int getItemCount() {
        int tamano = listaResultadoBusqueda.getArrayModeloVideojuego().size() + listaResultadoBusqueda.getArrayModeloDispositivo().size();
        return tamano;
    }

}
