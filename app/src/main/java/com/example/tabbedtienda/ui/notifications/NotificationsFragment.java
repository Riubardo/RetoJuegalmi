package com.example.tabbedtienda.ui.notifications;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionInflater;

import com.example.tabbedtienda.AdaptadorRecycler;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

	private NotificationsViewModel notificationsViewModel;
	RecyclerView recyclerView;
	private Context context;

	public static NotificationsFragment newInstance() {
		return new NotificationsFragment();
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {
		View vista = inflater.inflate(R.layout.fragment_notifications, container, false);
		recyclerView=vista.findViewById(R.id.recycler);
		recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false));
		AdaptadorRecycler adaptadorGaleria = new AdaptadorRecycler(getActivity());
		recyclerView.setAdapter(adaptadorGaleria);


		return vista;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TransitionInflater inflater = TransitionInflater.from(getContext());
		setEnterTransition(inflater.inflateTransition(R.transition.explode));
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);
		// TODO: Use the ViewModel
	}

}