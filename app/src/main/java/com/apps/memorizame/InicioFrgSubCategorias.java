package com.apps.memorizame;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.apps.memorizame.Adapters.SubCategoriasAdapter;
import com.apps.memorizame.Entitys.SubCategoriasEntity;
import com.apps.memorizame.SQLite.SubCategoriasCRUD;
import com.apps.memorizame.Tools.Constans;
import java.util.ArrayList;

public class InicioFrgSubCategorias extends Fragment {

    //deracaracion de variables
    private RecyclerView recycler;
    private View view;
    private int idCategorias=0;
    private ClickSubCategorias clickSubCategorias;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idCategorias = getArguments().getInt(Constans.dbColumCatego_id);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.inicio_frg_sub_categorias, container, false);

        //inicar metodos
        asignarIDs();
        iniciarRecycler();

        return view;
    }

    private void iniciarRecycler(){
        //lista de entidades
        ArrayList<SubCategoriasEntity> entities = new ArrayList<>();

        SubCategoriasEntity args = new SubCategoriasEntity(null,null,idCategorias,0,null);

        //lectura de los datos de db
        SubCategoriasCRUD crud = new SubCategoriasCRUD(getContext());
        Cursor rs = crud.read(args);

        //recorrer datos
        while (rs.moveToNext()){
            //entidad temporal
            SubCategoriasEntity entity = new SubCategoriasEntity(
                    rs.getString(Constans.dbColumSubCatego_name_index),
                    rs.getString(Constans.dbColumSubCatego_imag_index),
                    rs.getInt(Constans.dbColumSubCatego_cate_index),
                    rs.getInt(Constans.dbColumSubCatego_esta_index),
                    rs.getString(Constans.dbColumSubCatego_cali_index)
            );
            entity.setIdSubCategoria(rs.getInt(Constans.dbColumSubCatego_id_index));
            entities.add(entity);
        }

        //adaptador con onclick
        SubCategoriasAdapter adapter = new SubCategoriasAdapter(entities, getContext());
        adapter.setClickItem(new SubCategoriasAdapter.OnItemCLickListener() {
            @Override
            public void OnClickItem(int position) {
                clickSubCategorias.ClickSubCategorias(position);
            }
        });

        //propiedades del recycler y adaptador
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        recycler.setHasFixedSize(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        clickSubCategorias = (ClickSubCategorias) context;
    }

    public interface ClickSubCategorias{
        void ClickSubCategorias(int position);
    }

    private void asignarIDs(){
        recycler = view.findViewById(R.id.inicio_frg_sub_categorias_rv);
    }

}
