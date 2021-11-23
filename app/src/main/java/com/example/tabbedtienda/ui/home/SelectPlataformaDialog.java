package com.example.tabbedtienda.ui.home;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.tabbedtienda.MainActivity;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaVideojuego;
import com.example.tabbedtienda.ui.models.Llamadas.Login;
import com.example.tabbedtienda.ui.models.Llamadas.PlataformasModeloJuego;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.example.tabbedtienda.ui.models.Usuario;
import com.example.tabbedtienda.ui.models.Videojuego;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SelectPlataformaDialog extends DialogFragment {
    private int idJuego;
    private boolean alquilable;
    private List<Plataforma> plataformas = new ArrayList<>();
    private Context context;
    private Spinner spPlataformas;
    private AdaptadorListaPlataformas adaptador;

    public SelectPlataformaDialog() {
        super();
    }

    public boolean isAlquilable() {
        return alquilable;
    }

    public void setAlquilable(boolean alquilable) {
        this.alquilable = alquilable;
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
        plataformasModeloJuego.setAlquilable(alquilable);
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
        Button btnAceptar = vista.findViewById(R.id.btnPlataformaAceptar);
        Button btnCancelar = vista.findViewById(R.id.btnPlataformaCancelar);
        btnAceptar.setEnabled(false);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://arkadio.duckdns.org/ws/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                String fecha = fmt.format(Calendar.getInstance().getTime());
                LlamadaVideojuego llamadaVideojuego = new LlamadaVideojuego(idJuego, plataformas.get(spPlataformas.getSelectedItemPosition()).getId(),alquilable, fecha);
                RetroFittLlamadas retroFittLlamadas = retrofit.create(RetroFittLlamadas.class);
                Call<List<Videojuego>> call = retroFittLlamadas.getVideojuego(llamadaVideojuego);
                call.enqueue(new Callback<List<Videojuego>>() {
                    @Override
                    public void onResponse(Call<List<Videojuego>> call, Response<List<Videojuego>> response) {
                        ArrayList<Integer> videojuegos = MainActivity.mainActivity.getVideojuegos();
                        int t = videojuegos.size();
                        for (Videojuego videojuego: response.body()) {
                            boolean esta = false;
                            for (int v: videojuegos)
                                if (v == videojuego.getId()){
                                    esta = true;
                                    break;
                                }
                            if (!esta){
                                Toast.makeText(getContext(),"Producto Añadido al Carrito",Toast.LENGTH_SHORT).show();
                                videojuegos.add(videojuego.getId());
                                break;
                            }
                        }
                        if (t < videojuegos.size())
                            MainActivity.mainActivity.setVideojuegos(videojuegos);
                        else
                            Toast.makeText(getContext(),"Sin mas Existencias",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<List<Videojuego>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        spPlataformas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                btnAceptar.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        CargarContenido();
        return vista;
    }


}
