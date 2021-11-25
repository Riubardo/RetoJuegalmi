package com.example.tabbedtienda.ui.datos;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.example.tabbedtienda.R;

public class LoadingDialogManager {

	Activity activity;
	AlertDialog dialog;

	public LoadingDialogManager (Activity miActividad){
		activity = miActividad;
	}

	public void cargarDialogo(){

		//-----> SI ESTÁ ABIERTO, CERRARLO
		if((dialog!=null)&&(dialog.isShowing())){
			dialog.dismiss();
		}

		//-----> MOSTRAR DIALOGO
		AlertDialog.Builder builder = new AlertDialog.Builder(activity);

		LayoutInflater inflater = activity.getLayoutInflater();
		builder.setView(inflater.inflate(R.layout.dialogo_cargando, null));
		builder.setCancelable(false);

		/*
		ImageView loadingImage = (ImageView) activity.findViewById(R.id.loadingIV);
		loadingImage.setBackgroundResource(R.drawable.animacioncarga);

		Drawable loadingAnimation = loadingImage.getBackground();
		if (loadingAnimation instanceof Animatable) {
			((Animatable)loadingAnimation).start();
		}
		*/
		dialog = builder.create();
		dialog.show();
	}

	public void cerrarDialogo(){
		dialog.dismiss();
	}
}
