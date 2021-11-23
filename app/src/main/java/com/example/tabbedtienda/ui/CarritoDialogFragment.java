package com.example.tabbedtienda.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.tabbedtienda.MainActivity;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.home.AdaptadorListaDirecciones;
import com.example.tabbedtienda.ui.models.Direccion;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaVenta;
import com.example.tabbedtienda.ui.models.Llamadas.Respuesta;
import com.example.tabbedtienda.ui.models.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarritoDialogFragment extends DialogFragment {
    private Button botonVerificar = null;
    private Button botonCancelar = null;
    private Spinner spDirecciones = null;
    private Context context;
    private List<Direccion> direcciones  = new ArrayList<>();
    private AdaptadorListaDirecciones adaptador;

    public CarritoDialogFragment()
    {
        super();
    }

    @Override
    public void onCancel(DialogInterface dialog)
    {
        super.onCancel(dialog);
    }
    //Cierre del dialog
    @Override
    public void onDetach()
    {
        super.onDetach();
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Dialog dialog =
                super.onCreateDialog(savedInstanceState);
        dialog.setTitle("Carrito");
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
        RetroFittLlamadas retroFittLlamadas = retrofit.create(RetroFittLlamadas.class);
        Call<List<Direccion>> call = retroFittLlamadas.getDirecciones(MainActivity.mainActivity.getLogeado().getCliente());
        call.enqueue(new Callback<List<Direccion>>() {
            @Override
            public void onResponse(Call<List<Direccion>> call, Response<List<Direccion>> response) {
                Log.d("pasa", "aqui");
                direcciones = response.body();
                adaptador.setDirecciones(direcciones);
            }
            @Override
            public void onFailure(Call<List<Direccion>> call, Throwable t) {
                Log.d("pasa", "error");
                t.printStackTrace();
            }
        });
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }
    //Crear la vista (instancias etc)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View vista = (View)inflater.inflate(R.layout.dialog_carrito, container,false);
        spDirecciones = vista.findViewById(R.id.spCarritoDirecciones);
        adaptador=new AdaptadorListaDirecciones(context, R.layout.texto_adapter, direcciones);
        spDirecciones.setAdapter(adaptador);
        botonCancelar = vista.findViewById(R.id.btnCarritoCancelar);
        botonVerificar = vista.findViewById(R.id.btnCarritoAceptar);
        CargarContenido();
        return vista;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {

        //-----> CANCELAR
        botonCancelar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dismiss();
            }
        });

        //-----> VERIFICAR
        botonVerificar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://arkadio.duckdns.org/ws/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
                RetroFittLlamadas retroFittLlamadas = retrofit.create(RetroFittLlamadas.class);
                Usuario logeado = MainActivity.mainActivity.getLogeado();
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                Calendar c = Calendar.getInstance();
                String fecha = fmt.format(c.getTime());
                c.add(Calendar.DATE, 3);
                String fechafin = fmt.format(c.getTime());
                LlamadaVenta llamadaVenta = new LlamadaVenta(logeado.getCliente().getId(), 1, fecha, fechafin, MainActivity.mainActivity.getVideojuegos(), MainActivity.mainActivity.getDispositivos());
                Call<Respuesta> call = retroFittLlamadas.setVenta(llamadaVenta);
                call.enqueue(new Callback<Respuesta>() {
                    @Override
                    public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                        Toast.makeText(getContext(),"Compra Realizada",Toast.LENGTH_SHORT).show();
                        MainActivity.mainActivity.setVideojuegos(new ArrayList<>());
                        MainActivity.mainActivity.setDispositivos(new ArrayList<>());
                    }
                    @Override
                    public void onFailure(Call<Respuesta> call, Throwable t) {
                        Toast.makeText(getContext(),"Error en la Compra",Toast.LENGTH_SHORT).show();
                        t.printStackTrace();
                    }
                });
                dismiss();
            }
        });

    }
}
