package com.example.tabbedtienda.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.transition.TransitionInflater;

import com.example.tabbedtienda.R;
import com.example.tabbedtienda.databinding.FragmentDashboardBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DashboardFragment extends SupportMapFragment implements OnMapReadyCallback {

	private DashboardViewModel mViewModel;

	public static DashboardFragment newInstance() {
		return new DashboardFragment();
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
		LatLng almi = new LatLng(43.27181843815825, -2.948787459806573);

		float zoom = 20;

		map.moveCamera(CameraUpdateFactory.newLatLngZoom(almi, zoom));

		map.addMarker(new MarkerOptions().position(almi));
	}


	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
		// TODO: Use the ViewModel
	}


}