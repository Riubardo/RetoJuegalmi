package com.example.tabbedtienda.ui.notifications;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.tabbedtienda.R;

import java.util.ArrayList;

public class GaleriaImagenesAdapter extends BaseAdapter {

    private Context contexto;
    private TypedArray imagenes = null;

    public GaleriaImagenesAdapter(Context contexto, TypedArray imagenes)
    {
        this.contexto = contexto;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return imagenes.length();
    }

    @Override
    public Object getItem(int position) {
        return imagenes.getResourceId(position, -1);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return this.getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.contexto);
        View vistaImagen = inflater.inflate(R.layout.adaptador_grid,parent, false);

        ImageView imagen = (ImageView) vistaImagen.findViewById(R.id.imgFoto);
        Glide.with(contexto).load(this.imagenes.getResourceId(position, -1)).into(imagen);

        return vistaImagen;
    }
}
