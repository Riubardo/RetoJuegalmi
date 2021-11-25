package com.example.tabbedtienda.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tabbedtienda.MainActivity;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.models.ModeloDispositivo;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;
import com.example.tabbedtienda.ui.models.ResultadoBuscada;

public class AdaptadorResultadosBusqueda extends RecyclerView.Adapter<AdaptadorResultadosBusqueda.ViewHolder>{
    private ResultadoBuscada listaResultadoBusqueda;
    private Fragment  fragment;
    private DialogFragment dialogFragment;

    public AdaptadorResultadosBusqueda(DialogFragment dia, ResultadoBuscada dataSet) {
        listaResultadoBusqueda = dataSet;
        dialogFragment=dia;
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

        private CardView card;

        public ViewHolder(View view, Context context){
            super(view);
            imagen = (ImageView) view.findViewById(R.id.itemImage);
            nombreBusqueda = (TextView) view.findViewById(R.id.nombreBusqueda);
            card = (CardView) view.findViewById(R.id.cardVideojuego);
            this.context = context;



        }

        public Context getContext() {
            return context;
        }

        public void setContext(Context context) {
            this.context = context;
        }

        public TextView getTvNombre() { return nombreBusqueda; }
        public ImageView getImagen() { return imagen; }
        public CardView getCard() { return card; }
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
    public void onBindViewHolder(@NonNull AdaptadorResultadosBusqueda.ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        if (position < listaResultadoBusqueda.getArrayModeloVideojuego().size() ){
            viewHolder.getTvNombre().setText(listaResultadoBusqueda.getArrayModeloVideojuego().get(position).getNombre());
            Glide.with(viewHolder.context).load(listaResultadoBusqueda.getArrayModeloVideojuego().get(position).getImagen()).centerCrop().into(viewHolder.getImagen());

            final ProductoDialog dialog = new ProductoDialog(fragment,(ModeloVideojuego) listaResultadoBusqueda.getArrayModeloVideojuego().get(position));

            viewHolder.getCard().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("algo",listaResultadoBusqueda.getArrayModeloVideojuego().get(position).getNombre()+"");
                    dialog.show(dialogFragment.getChildFragmentManager(), "Ver Producto");
                }
            });

        }else{
            viewHolder.getTvNombre().setText(listaResultadoBusqueda.getArrayModeloDispositivo().get(position-listaResultadoBusqueda.getArrayModeloVideojuego().size()).getNombre());
            Glide.with(viewHolder.context).load(listaResultadoBusqueda.getArrayModeloDispositivo().get(position-listaResultadoBusqueda.getArrayModeloVideojuego().size()).getImagen()).centerCrop().into(viewHolder.getImagen());
            //final ProductoDialog dialog = new ProductoDialog(viewHolder.context, (ModeloDispositivo) listaResultadoBusqueda.getArrayModeloDispositivo().get(position-listaResultadoBusqueda.getArrayModeloVideojuego().size()));

        }

    }

    @Override
    public int getItemCount() {
        int tamano = listaResultadoBusqueda.getArrayModeloVideojuego().size() + listaResultadoBusqueda.getArrayModeloDispositivo().size();
        return tamano;
    }

}
