package com.example.tabbedtienda.ui.home;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tabbedtienda.R;

public class VentanaBusqueda extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private RecyclerView recycler;
    private ImageButton flechaAtras;
    AdaptadorResultadosBusqueda adaptadorResultadosBusqueda ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogo_busqueda);
        recycler = findViewById(R.id.videojuegosBusqueda);

        flechaAtras = (ImageButton) findViewById(R.id.flechaAtrass);

        recycler.setAdapter(adaptadorResultadosBusqueda);

        flechaAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
