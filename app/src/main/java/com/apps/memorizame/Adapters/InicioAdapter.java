package com.apps.memorizame.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.memorizame.Entitys.InicioEntity;
import com.apps.memorizame.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class InicioAdapter extends RecyclerView.Adapter<InicioHolder> {

    //declaracion de variables
    private ArrayList<InicioEntity> entities = new ArrayList<>();
    private Context context;

    public InicioAdapter(ArrayList<InicioEntity> entities, Context context){
        //setear datos desde el constructor
        this.entities = entities;
        this.context = context;
    }

    @NonNull
    @Override
    public InicioHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflar las vistas del cardview
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inicio_frg_cv_categorias,viewGroup, false);
        return new InicioHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InicioHolder holder, int i) {
        //dato exacto
        InicioEntity data = entities.get(i);

        //setear datos de cada elemento del card
        holder.imagen.setBackgroundResource(data.getImagen());
        holder.nombre.setText(data.getNombre());
    }

    @Override
    public int getItemCount() { return entities.size(); }
}
