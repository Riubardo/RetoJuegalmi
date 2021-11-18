package com.example.tabbedtienda.ui.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabbedtienda.AdaptadorRecycler;
import com.example.tabbedtienda.R;

import java.util.ArrayList;

public class LasFotos extends Fragment {

    private ArrayList<GaleriaFotos> arrayGaleria = new ArrayList<>();

    public LasFotos() {
        llenarArray();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.activity_adaptador_recycler, container, false);

        llenarArray();

        return vista;
    }

    private void llenarArray() {

        arrayGaleria.add(new GaleriaFotos("https://almi.eus/wp-content/uploads/2019/11/IMG_20191125_084551.jpg"));
        arrayGaleria.add(new GaleriaFotos("https://almi.eus/wp-content/uploads/2019/11/IMG_20191125_084551.jpg"));
        arrayGaleria.add(new GaleriaFotos("https://almi.eus/wp-content/uploads/2019/11/IMG_20191125_084551.jpg"));
        arrayGaleria.add(new GaleriaFotos("https://almi.eus/wp-content/uploads/2019/11/IMG_20191125_084551.jpg"));
        arrayGaleria.add(new GaleriaFotos("https://almi.eus/wp-content/uploads/2019/11/IMG_20191125_084551.jpg"));
        arrayGaleria.add(new GaleriaFotos("https://almi.eus/wp-content/uploads/2019/11/IMG_20191125_084551.jpg"));
        arrayGaleria.add(new GaleriaFotos("https://almi.eus/wp-content/uploads/2019/11/IMG_20191125_084551.jpg"));
        arrayGaleria.add(new GaleriaFotos("https://almi.eus/wp-content/uploads/2019/11/IMG_20191125_084551.jpg"));
        arrayGaleria.add(new GaleriaFotos("https://almi.eus/wp-content/uploads/2019/11/IMG_20191125_084551.jpg"));


    }
}
