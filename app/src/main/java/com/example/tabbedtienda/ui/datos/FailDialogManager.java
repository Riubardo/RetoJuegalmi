package com.example.tabbedtienda.ui.datos;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.tabbedtienda.R;

public class FailDialogManager {

	Activity activity;
	AlertDialog dialog;

	public FailDialogManager(Activity miActividad){
		activity = miActividad;
	}

	public void abrirDialogo(){
		AlertDialog.Builder builder = new AlertDialog.Builder(activity);

		LayoutInflater inflater = activity.getLayoutInflater();
		builder.setView(inflater.inflate(R.layout.dialogo_cargando_fail, null));
		builder.setCancelable(false);

		dialog = builder.create();
		dialog.show();
	}

	public void cerrarDialogo(){
		dialog.dismiss();
	}
}
