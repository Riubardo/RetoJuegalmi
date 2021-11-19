package com.example.tabbedtienda;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tabbedtienda.ui.notifications.GaleriaFotos;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.AdaptadorRecyclerViewHolder> {
    private Context contexto = null;
    private ArrayList<GaleriaFotos> arrayGaleria = llenarArray();


    public AdaptadorRecycler(Context contexto) {
        this.contexto = contexto;
    }

    public class AdaptadorRecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGaleria;

        public AdaptadorRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGaleria = (ImageView) itemView.findViewById(R.id.imgInteriorExterior);
        }
    }



    @NonNull
    @Override
    public AdaptadorRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adaptador_recycler, null, false);

        return new AdaptadorRecyclerViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerViewHolder holder, int position) {
        Log.d("algo", " "+arrayGaleria.get(position));
        Glide.with(contexto).load(arrayGaleria.get(position).getFoto()).centerCrop().into(holder.imgGaleria);
    }

    @Override
    public int getItemCount() {
        return arrayGaleria.size();
    }


    public ArrayList<GaleriaFotos> llenarArray() {
        ArrayList<GaleriaFotos> arrayGaleria = new ArrayList<GaleriaFotos>();
        arrayGaleria.add(new GaleriaFotos("https://almi.eus/wp-content/uploads/2017/05/IMG-20170516-WA0000.jpg"));
        arrayGaleria.add(new GaleriaFotos("https://almi.eus/wp-content/uploads/2016/09/03-Entrada-Almi-1024x576.jpg"));
        arrayGaleria.add(new GaleriaFotos("https://static2.elcorreo.com/www/multimedia/202105/17/media/cortadas/almi3-kxcH--1459x900@El%20Correo.jpg"));
        arrayGaleria.add(new GaleriaFotos("https://almi.eus/wp-content/uploads/2021/06/premio-piko-pala-tknika.jpg"));


        return arrayGaleria;
    }

}
