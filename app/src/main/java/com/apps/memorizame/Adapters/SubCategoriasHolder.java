package com.apps.memorizame.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.memorizame.R;
import com.jgabrielfreitas.core.BlurImageView;

public class SubCategoriasHolder extends RecyclerView.ViewHolder {

    //elementos del laoyur
    protected ImageView bloqueo;
    protected BlurImageView imagen;
    protected TextView nombre,califi;

    public SubCategoriasHolder(@NonNull View itemView) {
        super(itemView);

        //encontrar id de cada elemneto del layour
        //encontrar cada elemento
        imagen = itemView.findViewById(R.id.inicio_sub_categorias_cv_imagen);
        nombre = itemView.findViewById(R.id.inicio_sub_categorias_cv_nombre);
        califi = itemView.findViewById(R.id.inicio_sub_categorias_cv_califi);
        bloqueo = itemView.findViewById(R.id.inicio_sub_categorias_cv_bloqueo);
    }
}