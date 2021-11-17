package com.example.tabbedtienda.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.transition.TransitionInflater;

import com.example.tabbedtienda.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaFragment extends SupportMapFragment implements OnMapReadyCallback {

	public static MapaFragment newInstance() {
		return new MapaFragment();
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TransitionInflater inflater = TransitionInflater.from(getContext());
		setEnterTransition(inflater.inflateTransition(R.transition.explode));
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {

		View vista = super.onCreateView(inflater, container, savedInstanceState);
		getMapAsync(this);

		return vista;
	}

	@Override
	public void onMapReady(GoogleMap map) {
		//Añadimos la latitud y longitud de almi
		LatLng almi = new LatLng(43.27181843815825, -2.948787459806573);

		//Zoom del mapa, cuanto mayor sea el numero mas cerca del punto de almi esta
		float zoom = 20;

		map.moveCamera(CameraUpdateFactory.newLatLngZoom(almi, zoom));

		// Colocar un marcador en la misma posición
		map.addMarker(new MarkerOptions().position(almi));
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//mViewModel = new ViewModelProvider(this).get(MapaViewModel.class);
	}

}