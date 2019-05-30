package com.apps.memorizame;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.memorizame.Entitys.CategoriasEntity;
import com.apps.memorizame.Entitys.PreguntasEntity;
import com.apps.memorizame.SQLite.CategoriasCRUD;
import com.apps.memorizame.SQLite.PreguntasCRUD;
import com.apps.memorizame.Tools.Constans;

public class Preguntas extends AppCompatActivity {

    private TextView txtValor;
    private Integer valor;
    private ScrollView mImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        PreguntasEntity preguntasEntity = new PreguntasEntity("", 1);
        PreguntasCRUD preguntasCRUD = new PreguntasCRUD(getApplicationContext());

        Cursor resultx = preguntasCRUD.readPreguntas(preguntasEntity);
        while (resultx.moveToNext()){
            Toast.makeText(this, resultx.getString(Constans.dbColumCatego_name_index), Toast.LENGTH_SHORT).show();
        }



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
