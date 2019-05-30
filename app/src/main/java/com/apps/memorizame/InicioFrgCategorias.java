package com.apps.memorizame;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.memorizame.Adapters.categoriasAdapter;
import com.apps.memorizame.Entitys.CategoriasEntity;
import com.apps.memorizame.SQLite.CategoriasCRUD;
import com.apps.memorizame.Tools.Constans;
import com.apps.memorizame.Tools.TheInterface;
import java.util.ArrayList;

public class InicioFrgCategorias extends Fragment {

    //deracaracion de variables
    private View view;
    private RecyclerView recycler;
    private TheInterface communicatorx;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.inicio_frg_categorias, container, false);

        //inicar metodos
        asignarIDs();
        iniciarRecycler();

        return view;
    }

    private void iniciarRecycler(){
        //lista de entidades
        ArrayList<CategoriasEntity> entities = new ArrayList<>();

        //lectura de los datos de db
        CategoriasCRUD crud = new CategoriasCRUD(getContext());
        Cursor rs = crud.read();

        //recorrer datos
        while (rs.moveToNext()){
            //entidad temporal
            CategoriasEntity entity = new CategoriasEntity(
                    rs.getString(Constans.dbColumCatego_name_index),
                    rs.getString(Constans.dbColumCatego_imag_index),
                    rs.getInt(Constans.dbColumCatego_esta_index)
            );
            entity.setIdCategoria(rs.getInt(Constans.dbColumCatego_id_index));

            entities.add(entity);
        }

        //adaptador con onclick
        categoriasAdapter adapter = new categoriasAdapter(entities, getContext());
        adapter.setClickItem(new categoriasAdapter.OnItemCLickListener() {
            @Override
            public void OnClickItem(int position) {
                communicatorx.comunicador(position);
            }
        });

        //propiedades del recycler y adaptador
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setHasFixedSize(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicatorx = (TheInterface) context;
    }

    private void asignarIDs(){
        //metodo para encontrar ids de cada elemento
        recycler = view.findViewById(R.id.inicio_frg_categorias_rv);
    }
}
