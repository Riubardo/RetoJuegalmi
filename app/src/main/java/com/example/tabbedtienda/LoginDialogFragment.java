package com.example.tabbedtienda;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.Cliente;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.example.tabbedtienda.ui.models.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginDialogFragment extends DialogFragment implements Callback<Usuario>
{
	private EditText editUsuario = null;
	private EditText editPassword = null;
	private Button botonVerificar = null;
	private Button botonCancelar = null;

	public LoginDialogFragment()
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
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		Dialog dialog =
				super.onCreateDialog(savedInstanceState);
		dialog.setTitle("Login");
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
		Call<Usuario> call = retroFittLlamadas.getLogin(nomb, contra);
		call.enqueue(this);
	}
	//Crear la vista (instancias etc)
	@Override
	public View onCreateView(LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState)
	{
		View vista = (View)
				inflater.inflate(R.layout.dialog_login, container,
						false);
		editUsuario = (EditText) vista.findViewById(R.id.editUsuario);
		editPassword = (EditText) vista.findViewById(R.id.editPassword);
		botonVerificar = (Button) vista.findViewById(R.id.botonVerificar);
		botonCancelar= (Button) vista.findViewById(R.id.botonCancelar);
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
				String usuario = editUsuario.getText().toString();
				String password = editPassword.getText().toString();
				cargarDatos(usuario, password);
				dismiss();
			}
		});

	}

	@Override
	public void onResponse(Call<Usuario> call, Response<Usuario> response) {
		if(response.isSuccessful()) {
			Log.d("usu",response.body().getUsuario().toString());
		} else {
			Log.d("usu","error1");
			System.out.println(response.errorBody());
		}
	}

	@Override
	public void onFailure(Call<Usuario> call, Throwable t) {
		Log.d("usu","error2");
		t.printStackTrace();
	}
}
