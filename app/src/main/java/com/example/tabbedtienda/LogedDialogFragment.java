package com.example.tabbedtienda;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.example.tabbedtienda.ui.models.Usuario;

public class LogedDialogFragment  extends DialogFragment {
    @Override
    public void onCancel(DialogInterface dialog)
    {
        super.onCancel(dialog);
    }
    @Override
    public void onDetach()
    {
        super.onDetach();
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.dialog_loged, container, false);
        Usuario usu = MainActivity.mainActivity.getLogeado();
        if (usu.isAdmin()){
            ((TextView)view.findViewById(R.id.txtLogedNombre)).setText(usu.getTrabajador().getNombre());
            ((TextView)view.findViewById(R.id.txtLogedCorreo)).setText(usu.getTrabajador().getEmail());
        }
        else {
            ((TextView)view.findViewById(R.id.txtLogedNombre)).setText(usu.getCliente().getNombre());
            ((TextView)view.findViewById(R.id.txtLogedCorreo)).setText(usu.getCliente().getEmail());
            byte[] bytesImage = Base64.decode(usu.getCliente().getImagen(), Base64.DEFAULT);
            Log.d("img",bytesImage.length + "");
            Glide.with(this).asBitmap().load(bytesImage).into((ImageView) view.findViewById(R.id.imgLogedPerfil));
           // Glide.with(this).load(usu.getCliente().getImagen()).into((ImageView)view.findViewById(R.id.imgLogedPerfil));
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((Button) view.findViewById(R.id.btnLogedCancelar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        ((Button) view.findViewById(R.id.btnLogedDeslogear)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainActivity.setLogeado(null);
                dismiss();
            }
        });
    }
}
