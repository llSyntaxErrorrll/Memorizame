package com.apps.memorizame.ui.main;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.apps.memorizame.Inicio;
import com.apps.memorizame.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tercer_fragment extends Fragment {

    //declaracion de vairables
    private View view;
    private Button finalizar;
    private CLickFinalizar cLickFinalizar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.l_tercer_fragmento,container, false);

        finalizar = view.findViewById(R.id.finalizar);
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cLickFinalizar.cLickFinalizar();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        cLickFinalizar = (CLickFinalizar) context;
    }

    public interface CLickFinalizar{
        void cLickFinalizar();
    }

}
