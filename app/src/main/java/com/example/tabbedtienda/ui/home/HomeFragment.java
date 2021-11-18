package com.example.tabbedtienda.ui.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabbedtienda.LogedDialogFragment;
import com.example.tabbedtienda.LoginDialogFragment;
import com.example.tabbedtienda.MainActivity;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.databinding.FragmentHomeBinding;
import com.example.tabbedtienda.ui.datos.ModelajeJSON;
import com.example.tabbedtienda.ui.models.Plataforma;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;




public class HomeFragment extends Fragment {

	// RecyclerView
	RecyclerView recyclerView;
	RecyclerView.Adapter rvAdapter;
	RecyclerView.LayoutManager rvLayoutManger;
	List<Plataforma> listaPlataformas;
	ImageButton userButton;
	Context context;
	public FragmentManager fragmentManager;

	private SearchView buscador;
	public static final int VOZ = 1;
	private EditText etTexto;

	private LoginDialogFragment dialog = null;
	private HomeViewModel homeViewModel;
	private FragmentHomeBinding binding;

	public FragmentManager getHomeFM(){
		return fragmentManager;
	}

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);


		View view = inflater.inflate(R.layout.fragment_home, null);

		// RecyclerView Categoria Setup
		recyclerView = (RecyclerView) view.findViewById(R.id.recyclerHome);
		rvLayoutManger = new LinearLayoutManager(getActivity());
		recyclerView.setLayoutManager(rvLayoutManger);


		//listaPlataformas = new ArrayList<>();
		homeViewModel.homeFragment = this;
		homeViewModel.devuelveLista();

		buscador = (SearchView) view.findViewById(R.id.searchView) ;
		buscador.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent abrir = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				abrir.putExtra(RecognizerIntent.EXTRA_PROMPT, "Ahora puedes hablar...");

				//Para que reconozca el idioma
				abrir.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
				startActivityForResult(abrir, VOZ);
			}
		});



		userButton = (ImageButton) view.findViewById(R.id.userButton);
		userButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (MainActivity.mainActivity.getLogeado() == null){
					dialog = new LoginDialogFragment();
					dialog.show(fragmentManager, "login");
				}else {
					LogedDialogFragment loged = new LogedDialogFragment();
					loged.show(fragmentManager,"loged");
				}

			}
		});



		//loadPlataformas(); <- vacio, mas adelante cargar datos acá

		return view;

	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		ArrayList<String> arrayResultado;
		if (requestCode == VOZ){
			if (resultCode == RESULT_OK){
				if (data != null){
					arrayResultado = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
					etTexto.setText(arrayResultado.get(0));
				}
			}
		}
	}

	//Para buscar las palabras en google
	private void realizarAcciones(String s){
		try {
			String palabraBuscar = URLEncoder.encode(s, "UTF-8");

			//uri es una direccion de internet
			Uri uri = Uri.parse("https://www.google.com/search?q=" + palabraBuscar);

			Intent abrir = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(abrir);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}


	public void setAdapter(){
		rvAdapter = new AdaptadorPlataforma(this, listaPlataformas);
		recyclerView.setAdapter(rvAdapter);
	}
	@Override
	public void onAttach(@NonNull Context context) {
		super.onAttach(context);
		this.context=context;
		fragmentManager = getChildFragmentManager();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}

}