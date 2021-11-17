package com.example.tabbedtienda.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.example.tabbedtienda.R;

public class GridPer extends AppCompatActivity {
    private GridView grid = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_per);

        grid = (GridView) findViewById(R.id.gridFotos);

        grid.setAdapter(new GaleriaImagenesAdapter(getApplicationContext(), getResources().obtainTypedArray(R.array.paisajes)));


    }
}