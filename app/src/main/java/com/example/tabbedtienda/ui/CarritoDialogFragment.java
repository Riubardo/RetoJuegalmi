package com.example.tabbedtienda.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.tabbedtienda.MainActivity;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.Llamadas.Login;
import com.example.tabbedtienda.ui.models.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarritoDialogFragment extends DialogFragment {
    private Button botonVerificar = null;
    private Button botonCancelar = null;
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
    public void cargarDatos(String nomb, String contra){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://arkadio.duckdns.org/ws/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetroFittLlamadas retroFittLlamadas = retrofit.create(RetroFittLlamadas.class);
        Login login = new Login(nomb, contra);
        Call<Usuario> call = retroFittLlamadas.getLogin(login);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()) {
                    Usuario usuario = response.body();
                    if (usuario.getCliente() != null || usuario.getTrabajador() != null)
                        MainActivity.mainActivity.setLogeado(usuario);
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    //Crear la vista (instancias etc)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View vista = (View)inflater.inflate(R.layout.dialog_carrito, container,false);
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

                dismiss();
            }
        });

    }
}
