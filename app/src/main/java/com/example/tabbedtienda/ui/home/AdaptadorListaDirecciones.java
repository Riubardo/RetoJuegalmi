package com.example.tabbedtienda.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.models.Direccion;

import java.util.List;

public class AdaptadorListaDirecciones extends ArrayAdapter<Direccion> {
    private List<Direccion> direcciones;
    private Context contexto;

    public AdaptadorListaDirecciones(@NonNull Context context, int resource, List<Direccion> objects) {
        super(context, resource, objects);
        this.contexto = context;
        this.direcciones = objects;
    }
    @Override
    public int getCount() {
        return direcciones.size();
    }

    @Nullable
    @Override
    public Direccion getItem(int position) {
        return direcciones.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(contexto);
        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.texto_adapter, parent, false);
        TextView tvAdaptador = view.findViewById(R.id.txtAdaptador);
        tvAdaptador.setText(direcciones.get(position).getCalle());
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
        notifyDataSetChanged();
    }
}
