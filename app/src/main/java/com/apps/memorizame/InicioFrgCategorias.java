package com.apps.memorizame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.memorizame.Adapters.InicioAdapter;
import com.apps.memorizame.Entitys.InicioEntity;

import java.util.ArrayList;

public class InicioFrgCategorias extends Fragment {

    //deracaracion de variables
    private View view;
    private RecyclerView recycler;

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
        //entidades quemadas
        InicioEntity casas = new InicioEntity(R.drawable.cat_casas,"Casas");
        InicioEntity animal = new InicioEntity(R.drawable.cat_animales,"Animales");
        InicioEntity calles = new InicioEntity(R.drawable.cat_calle,"Calles");

        //lista de entidades
        ArrayList<InicioEntity> entities = new ArrayList<>();
        entities.add(casas);
        entities.add(animal);
        entities.add(calles);

        //adaptador
        InicioAdapter adapter = new InicioAdapter(entities, getContext());

        //propiedades del recycler y adaptador
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setHasFixedSize(true);
    }

    private void asignarIDs(){
        //metodo para encontrar ids de cada elemento
        recycler = view.findViewById(R.id.inicio_frg_categorias_rv);
    }
}
