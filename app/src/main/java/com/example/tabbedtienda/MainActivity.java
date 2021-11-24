package com.example.tabbedtienda;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.tabbedtienda.databinding.ActivityMainBinding;
import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.Dispositivo;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaBusqueda;
import com.example.tabbedtienda.ui.models.Llamadas.LlamadaLocation;
import com.example.tabbedtienda.ui.models.Llamadas.Respuesta;
import com.example.tabbedtienda.ui.models.ResultadoBuscada;
import com.example.tabbedtienda.ui.models.Usuario;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;
import com.example.tabbedtienda.ui.models.Videojuego;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity{
	public static MainActivity mainActivity;
	private ActivityMainBinding binding;
	private Usuario logeado = null;
	private ArrayList<Integer> videojuegos = new ArrayList<Integer>();
	private ArrayList<Integer> dispositivos = new ArrayList<Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mainActivity = this;
		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

		BottomNavigationView navView = findViewById(R.id.nav_view);
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
				R.id.navigation_home,
				R.id.navigation_dashboard,
				R.id.navigation_notifications,
				R.id.navigation_support,
				R.id.navigation_cart)
				.build();
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
		NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
		NavigationUI.setupWithNavController(binding.navView, navController);
	}
	public void localizar(){
		Log.d("pasa","eh");
		if (logeado !=null && logeado.getCliente() != null){
			while (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
				ActivityCompat.requestPermissions((Activity) this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PackageManager.PERMISSION_GRANTED);
			}
			while (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
				ActivityCompat.requestPermissions((Activity) this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},PackageManager.PERMISSION_GRANTED);
			}
			LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
			String provider = locationManager.getBestProvider(new Criteria(), true);
			locationManager.requestLocationUpdates(provider, 10000, 1, new LocationListener() {
				@Override
				public void onLocationChanged(@NonNull Location location) {
					if (logeado !=null && logeado.getCliente() != null){
						LlamadaLocation llamadaLocation = new LlamadaLocation(logeado.getCliente().getId(),location.getLatitude(), location.getLongitude());
						Gson gson = new GsonBuilder()
								.setLenient()
								.create();
						Retrofit retrofit = new Retrofit.Builder()
								.baseUrl("https://arkadio.duckdns.org/ws/")
								.addConverterFactory(GsonConverterFactory.create(gson))
								.build();
						RetroFittLlamadas retroFittLlamadas = retrofit.create(RetroFittLlamadas.class);
						Call<Respuesta> call = retroFittLlamadas.updateLocalizacion(llamadaLocation);
						call.enqueue(new Callback<Respuesta>() {
							@Override
							public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
								Log.d("pasa", response.body().getStatus());
							}
							@Override
							public void onFailure(Call<Respuesta> call, Throwable t) {
								Log.d("pasa","error");
								t.printStackTrace();
							}
						});
					}
				}
			});
		}
	}
	public ArrayList<Integer> getVideojuegos() {
		return videojuegos;
	}

	public void setVideojuegos(ArrayList<Integer> videojuegos) {
		this.videojuegos = videojuegos;
	}

	public ArrayList<Integer> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(ArrayList<Integer> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public Usuario getLogeado() {
		return logeado;
	}

	public void setLogeado(Usuario logeado) {
		this.logeado = logeado;
		localizar();
	}
}