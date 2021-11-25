package com.example.tabbedtienda.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tabbedtienda.LogedDialogFragment;
import com.example.tabbedtienda.LoginDialogFragment;
import com.example.tabbedtienda.MainActivity;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.databinding.FragmentCartBinding;
import com.example.tabbedtienda.databinding.FragmentSupportBinding;

public class CartFragment extends Fragment {

	private CartViewModel cartViewModel;
	private FragmentCartBinding binding;
	private TextView tvTituloHistoria;

	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {
		cartViewModel =
				new ViewModelProvider(this).get(CartViewModel.class);

		binding = FragmentCartBinding.inflate(inflater, container, false);
		View view = binding.getRoot();

		tvTituloHistoria = (TextView) view.findViewById(R.id.tvTituloHistoria);
		tvTituloHistoria.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AnimacionTitulo animacionTitulo = new AnimacionTitulo(tvTituloHistoria);
				animacionTitulo.execute();
			}
		});

		return view;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}