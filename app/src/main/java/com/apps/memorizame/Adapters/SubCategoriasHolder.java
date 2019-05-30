package com.apps.memorizame.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.memorizame.R;

public class SubCategoriasHolder extends RecyclerView.ViewHolder {

    //elementos del laoyur
    protected ImageView imagen,bloqueo;
    protected TextView nombre;

    public SubCategoriasHolder(@NonNull View itemView) {
        super(itemView);

        //encontrar id de cada elemneto del layour
        //encontrar cada elemento
        imagen = itemView.findViewById(R.id.inicio_sub_categorias_cv_imagen);
        nombre = itemView.findViewById(R.id.inicio_sub_categorias_cv_nombre);
        bloqueo = itemView.findViewById(R.id.inicio_sub_categorias_cv_bloqueo);
    }
}