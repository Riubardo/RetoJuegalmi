package com.example.tabbedtienda.ui.home;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaBusqueda;
import com.example.tabbedtienda.ui.models.ResultadoBuscada;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VentanaBusqueda extends DialogFragment {
    private RecyclerView recycler;
    private ImageButton flechaAtras;
    AdaptadorResultadosBusqueda adaptadorResultadosBusqueda ;
    ResultadoBuscada resultadoBuscada = new ResultadoBuscada();
    String s;

    public VentanaBusqueda(String s) {
        this.s = s;
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
        buscar(s);
        flechaAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialogo_busqueda, null);
        adaptadorResultadosBusqueda = new AdaptadorResultadosBusqueda(getContext(), resultadoBuscada);

        recycler = view.findViewById(R.id.videojuegosBusqueda);
        recycler.setAdapter(adaptadorResultadosBusqueda);

        resultadoBuscada.setArrayModeloDispositivo(new ArrayList<>());
        resultadoBuscada.setArrayModeloVideojuego(new ArrayList<>());
        return view;

    }

    private void buscar(String s) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://arkadio.duckdns.org/ws/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetroFittLlamadas retroFittLlamadas = retrofit.create(RetroFittLlamadas.class);
        Call<ResultadoBuscada> call = retroFittLlamadas.getBuscador(new LlamadaBusqueda(s));

        call.enqueue(new Callback<ResultadoBuscada>() {
            @Override
            public void onResponse(Call<ResultadoBuscada> call, Response<ResultadoBuscada> response) {
                resultadoBuscada = response.body();
                adaptadorResultadosBusqueda.setListaResultadoBusqueda(resultadoBuscada);
                Toast.makeText(getContext(),"Buscando",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<ResultadoBuscada> call, Throwable t) {
                Toast.makeText(getContext(),"Error en la Busqueda",Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
}
