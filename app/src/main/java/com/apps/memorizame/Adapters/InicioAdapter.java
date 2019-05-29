package com.apps.memorizame.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.apps.memorizame.Entitys.CategoriasEntity;
import com.apps.memorizame.R;
import java.util.ArrayList;

public class InicioAdapter extends RecyclerView.Adapter<InicioHolder> {

    //declaracion de variables
    private ArrayList<CategoriasEntity> entities = new ArrayList<>();
    private Context context;

    public InicioAdapter(ArrayList<CategoriasEntity> entities, Context context){
        //setear datos desde el constructor
        this.entities = entities;
        this.context = context;
    }

    @NonNull
    @Override
    public InicioHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflar las vistas del cardview
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inicio_frg_categorias_cv,viewGroup, false);
        return new InicioHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InicioHolder holder, int i) {
        //dato exacto
        CategoriasEntity data = entities.get(i);

        //setear datos de cada elemento del card
        holder.imagen.setBackgroundResource(Integer.valueOf(data.getImagen()));
        holder.nombre.setText(data.getNombre());

        //1 = completado, 0 = incompletado
        if(data.getIdEstado() == 1){
            holder.bloqueo.setVisibility(View.GONE);
        }else{
            holder.bloqueo.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() { return entities.size(); }
}
