package com.example.tabbedtienda.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;
import com.example.tabbedtienda.ui.models.Plataforma;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorListaPlataformas extends ArrayAdapter<Plataforma> {
    private List<Plataforma> plataformas;
    private Context contexto;


    public AdaptadorListaPlataformas(@NonNull Context context, int resource, List<Plataforma> objects) {
        super(context, resource, objects);
        this.contexto = context;
        this.plataformas = objects;
    }
    @Override
    public int getCount() {
        return plataformas.size();
    }

    @Nullable
    @Override
    public Plataforma getItem(int position) {
        return plataformas.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(contexto);
        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.texto_adapter, parent, false);
        TextView tvAdaptador = view.findViewById(R.id.txtAdaptador);
        tvAdaptador.setText(plataformas.get(position).getPlataforma());
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<Plataforma> plataformas) {
        this.plataformas = plataformas;
        notifyDataSetChanged();
    }
}
