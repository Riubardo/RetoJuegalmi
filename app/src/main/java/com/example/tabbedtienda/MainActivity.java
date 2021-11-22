package com.example.tabbedtienda;

import android.os.Bundle;

import com.example.tabbedtienda.databinding.ActivityMainBinding;
import com.example.tabbedtienda.ui.models.Dispositivo;
import com.example.tabbedtienda.ui.models.Usuario;
import com.example.tabbedtienda.ui.models.ModeloVideojuego;
import com.example.tabbedtienda.ui.models.Videojuego;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{
	public static MainActivity mainActivity;
	private ActivityMainBinding binding;
	private Usuario logeado = null;
	private ArrayList<Videojuego> modeloVideojuegos = new ArrayList<Videojuego>();
	private ArrayList<Dispositivo> dispositivos = new ArrayList<Dispositivo>();

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

	public Usuario getLogeado() {
		return logeado;
	}

	public void setLogeado(Usuario logeado) {
		this.logeado = logeado;
	}
}