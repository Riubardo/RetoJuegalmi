package com.example.tabbedtienda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tabbedtienda.ui.notifications.GaleriaFotos;
import com.example.tabbedtienda.ui.notifications.LasFotos;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.AdaptadorRecyclerViewHolder> {
   // private List<GaleriaFotos> arrayGaleria;
    private Context contexto = null;
    private FragmentManager fragmentmanager;
    private ArrayList<LasFotos> arrayGaleria = new ArrayList<>();


    public AdaptadorRecycler(ArrayList<LasFotos> arrayGaleria, Context contexto, FragmentManager fragmentmanager) {
        this.arrayGaleria = arrayGaleria;
        this.contexto = contexto;
        this.fragmentmanager = fragmentmanager;
    }

    public class AdaptadorRecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGaleria;

        public AdaptadorRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGaleria = (ImageView) itemView.findViewById(R.id.imgInteriorExterior);
        }
    }

    public AdaptadorRecycler(FragmentManager fragmentmanager) {
        this.fragmentmanager = fragmentmanager;
    }

    @NonNull
    @Override
    public AdaptadorRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adaptador_recycler, null, false);
        return new AdaptadorRecyclerViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerViewHolder holder, int position) {
        LasFotos imagen = arrayGaleria.get(position);
        Glide.with(contexto).load(imagen.getFoto()).centerCrop().into(holder.imgGaleria);
    }

    @Override
    public int getItemCount() {
        return arrayGaleria.size();
    }

}
