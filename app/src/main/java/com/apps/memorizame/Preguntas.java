package com.apps.memorizame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class Preguntas extends AppCompatActivity {

    private TextView txtValor;
    private Integer valor;
    private ScrollView mImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        /*Bundle parametros = this.getIntent().getExtras();
        if(parametros != null){
            valor = parametros.getInt("id");
            if ( valor == 0){
                txtValor.setText("no obtuvo nada");
            }else{
                txtValor.setText(valor.toString());
            }

        }*/
    }
}
