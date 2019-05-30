package com.apps.memorizame.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.memorizame.Entitys.SubCategoriasEntity;
import com.apps.memorizame.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class subCategoriasAdapter extends RecyclerView.Adapter<subCategoriasHolder> {

    //declaracion de variables
    private Context context;
    private ArrayList<SubCategoriasEntity> entities;

    public subCategoriasAdapter(ArrayList<SubCategoriasEntity> entities, Context context){
        //setear datos por los parametros
        this.entities = entities;
        this.context = context;
    }

    @NonNull
    @Override
    public subCategoriasHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflar las vistas del cardview
        View view = LayoutInflater.from(context).inflate(R.layout.inicio_frg_sub_categorias_cv, viewGroup, false);
        return new subCategoriasHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull subCategoriasHolder holder, int i) {
        SubCategoriasEntity data = entities.get(i);

        holder.nombre.setText(data.getNombreSub());
    }

    @Override
    public int getItemCount() { return entities.size(); }
}
