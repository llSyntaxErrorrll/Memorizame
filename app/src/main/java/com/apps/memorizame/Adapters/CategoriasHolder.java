package com.apps.memorizame.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.apps.memorizame.R;
import com.jgabrielfreitas.core.BlurImageView;

public class CategoriasHolder extends RecyclerView.ViewHolder {

    //elementos que estan en el layout
    protected ImageView bloqueo;
    protected BlurImageView imagen;
    protected TextView nombre;

    public CategoriasHolder(@NonNull View itemView) {
        super(itemView);

        //encontrar cada elemento
        imagen = itemView.findViewById(R.id.inicio_categorias_cv_imagen);
        nombre = itemView.findViewById(R.id.inicio_categorias_cv_nombre);
        bloqueo = itemView.findViewById(R.id.inicio_categorias_cv_bloqueo);
    }
}
