package com.apps.memorizame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.apps.memorizame.Tools.Constans;

public class InicioFrgSubCategorias extends Fragment {

    //deracaracion de variables
    private View view;
    private int mParam1=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(Constans.dbColumCatego_id);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.inicio_frg_sub_categorias, container, false);

        //inicio de los metodos
        Toast.makeText(getContext(), "idCategoria: "+mParam1, Toast.LENGTH_SHORT).show();

        return view;
    }

}
