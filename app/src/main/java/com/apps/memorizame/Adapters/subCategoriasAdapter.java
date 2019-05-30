package com.apps.memorizame.Adapters;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.apps.memorizame.Entitys.SubCategoriasEntity;
import com.apps.memorizame.R;
import java.util.ArrayList;

public class subCategoriasAdapter extends RecyclerView.Adapter<subCategoriasHolder> {

    //declaracion de variables
    private Context context;
    private ArrayList<SubCategoriasEntity> entities;
    private OnItemCLickListener clickItem;

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
        //dato exacto
        final SubCategoriasEntity data = entities.get(i);

        //obtener imagen por el nombre
        @DrawableRes
        int res = context.getResources().getIdentifier(data.getImagenSub(), "drawable", context.getPackageName());
        holder.imagen.setBackgroundResource(res);

        holder.nombre.setText(data.getNombreSub());

        //si es igual a 1 que es completo, oculta el candado
        if(data.getIdEstado() == 1){
            holder.bloqueo.setVisibility(View.GONE);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //habilita el click
                    clickItem.OnClickItem(data.getIdSubCategoria());
                }
            });
        }else{
            holder.bloqueo.setVisibility(View.VISIBLE);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Elemento bloqueado.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    //sirve para enviar los datos al fragmento
    public interface OnItemCLickListener{
        void OnClickItem(int position);
    }
    public void setClickItem(subCategoriasAdapter.OnItemCLickListener clickItem){ this.clickItem = clickItem; }

    @Override
    public int getItemCount() { return entities.size(); }
}
