package com.example.tabbedtienda.ui.cart;

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

import com.example.tabbedtienda.databinding.FragmentCartBinding;
import com.example.tabbedtienda.databinding.FragmentSupportBinding;

public class CartFragment extends Fragment {

	private CartViewModel cartViewModel;
	private FragmentCartBinding binding;

	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {
		cartViewModel =
				new ViewModelProvider(this).get(CartViewModel.class);

		binding = FragmentCartBinding.inflate(inflater, container, false);
		View root = binding.getRoot();


		return root;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}