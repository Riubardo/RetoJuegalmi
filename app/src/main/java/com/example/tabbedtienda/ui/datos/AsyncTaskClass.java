package com.example.tabbedtienda.ui.datos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

import androidx.annotation.ColorInt;

import com.example.tabbedtienda.R;
import com.example.tabbedtienda.ui.home.ConsolasFragment;
import com.example.tabbedtienda.ui.models.PeticionMarcas;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/*
public class AsyncTaskClass extends AsyncTask<Void, Void, Void> {

	Context context;
	private LoadingDialogManager dialog;

	//-----> CONSTRUCTOR
	public AsyncTaskClass(Context context){

	}

	//-----> PRE EXECUTE: Mostrar Carga
	//@Override
	protected void onPreExecute() {
		super.onPreExecute();

	}


	//-----> DO IN BACKGROUND: GET <EXAMPLE>
	@Override
	protected void doInBackground(String... strings){

	}

	//-----> POST EXECUTE: Finalizar Carga
	//@Override
	protected void onPostExecute(String s) {

	};

}
*/