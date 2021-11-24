package com.example.tabbedtienda.ui.home;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.models.ResultadoBuscada;

public class VentanaBusqueda extends Fragment {
    private RecyclerView recycler;
    private ImageButton flechaAtras;
    AdaptadorResultadosBusqueda adaptadorResultadosBusqueda ;
    ResultadoBuscada resultadoBuscada;

    public VentanaBusqueda() {
    }

    public static VentanaBusqueda newInstance(ResultadoBuscada someInt) {
        VentanaBusqueda myFragment = new VentanaBusqueda();

        Bundle args = new Bundle();
        args.putSerializable("busqueda", someInt);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.videojuegosBusqueda);
        flechaAtras = (ImageButton) view.findViewById(R.id.flechaAtrass);

        if (getArguments() != null) {
            //Añadir al final quitando resultadoBuscada el resultadoBuscada de HomeFragment
            adaptadorResultadosBusqueda = new AdaptadorResultadosBusqueda(getContext(), (ResultadoBuscada) getArguments().getSerializable("busqueda"));
            recycler.setAdapter(adaptadorResultadosBusqueda);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialogo_busqueda, null);
        return view;

    }
}
