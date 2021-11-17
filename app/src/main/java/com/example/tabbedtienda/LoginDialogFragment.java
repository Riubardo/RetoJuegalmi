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

public class LoginDialogFragment extends DialogFragment
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

				if(((usuario.equals("Admin"))||(usuario.equals("Ruben")))&&(password.equals("Almi123"))){

					//-----> Guardar usuario en el Bundle

					Toast.makeText(getContext(), "Login Correcto", Toast.LENGTH_LONG).show();
					Log.e("Login", "Login Correcto");
					Log.i("Login", "Usuario: "+usuario);
					Log.i("Login", "Password: "+password);
					dismiss();
				}else{Toast.makeText(getContext(), "Login Incorrecto", Toast.LENGTH_LONG).show();
					Log.e("Login", "Login Incorrecto");
					Log.i("Login", "Usuario: "+usuario);
					Log.i("Login", "Password: "+password);
					dismiss();
					dismiss();
				}

				dismiss();
			}
		});

	}
}
