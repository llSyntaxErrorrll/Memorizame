package com.apps.memorizame.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.memorizame.R;

public class InicioHolder extends RecyclerView.ViewHolder {

    ImageView imagen,bloqueo;
    TextView nombre;

    public InicioHolder(@NonNull View itemView) {
        super(itemView);
        //encontrar cada elemento
        imagen = itemView.findViewById(R.id.inicio_cv_categorias_imagen);
        nombre = itemView.findViewById(R.id.inicio_cv_categorias_nombre);
        bloqueo = itemView.findViewById(R.id.inicio_cv_categorias_bloqueo);
    }
}
