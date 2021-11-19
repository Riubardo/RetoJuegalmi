package com.example.tabbedtienda.ui.home;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.tabbedtienda.MainActivity;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.Llamadas.Login;
import com.example.tabbedtienda.ui.models.Llamadas.PlataformasModeloJuego;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.example.tabbedtienda.ui.models.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SelectPlataformaDialog extends DialogFragment {
    private  int idJuego;
    private boolean alquilable;
    private List<Plataforma> plataformas = new ArrayList<>();
    private Context context;
    private Spinner spPlataformas;
    private AdaptadorListaPlataformas adaptador;

    public SelectPlataformaDialog() {
        super();
    }
    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle("Plataforma");
        return dialog;
    }
    private void CargarContenido(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://arkadio.duckdns.org/ws/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        PlataformasModeloJuego plataformasModeloJuego = new PlataformasModeloJuego();
        plataformasModeloJuego.setId_juego(idJuego);
        RetroFittLlamadas retroFittLlamadas = retrofit.create(RetroFittLlamadas.class);
        Call<List<Plataforma>> call = retroFittLlamadas.getPlataformasModeloJuego(plataformasModeloJuego);
        call.enqueue(new Callback<List<Plataforma>>() {
            @Override
            public void onResponse(Call<List<Plataforma>> call, Response<List<Plataforma>> response) {
                    plataformas = response.body();
                    adaptador.setPlataformas(plataformas);
            }
            @Override
            public void onFailure(Call<List<Plataforma>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    @Override
    public void onCancel(DialogInterface dialog)
    {
        super.onCancel(dialog);
    }
    @Override
    public void onDetach()
    {
        super.onDetach();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View vista = (View)inflater.inflate(R.layout.select_plataforma_dialog, container,false);
        spPlataformas = vista.findViewById(R.id.spDialogPlataforma);
        adaptador=new AdaptadorListaPlataformas(context, R.layout.texto_adapter, plataformas);
        spPlataformas.setAdapter(adaptador);
        CargarContenido();
        return vista;
    }


}
