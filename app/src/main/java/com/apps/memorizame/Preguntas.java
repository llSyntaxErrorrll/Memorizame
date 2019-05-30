package com.apps.memorizame;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.memorizame.Entitys.CategoriasEntity;
import com.apps.memorizame.Entitys.PreguntasEntity;
import com.apps.memorizame.SQLite.CategoriasCRUD;
import com.apps.memorizame.SQLite.PreguntasCRUD;
import com.apps.memorizame.Tools.Constans;

import java.util.ArrayList;

public class Preguntas extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6;
    TextView txtPregunta1,txtPregunta2, txtPregunta3, txtPregunta4, txtPregunta5, txtPregunta6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        PreguntasEntity preguntasEntity = new PreguntasEntity("", 1);
        PreguntasCRUD preguntasCRUD = new PreguntasCRUD(getApplicationContext());

        ArrayList<PreguntasEntity> entityArrayList = new ArrayList<>();
        Cursor resultx = preguntasCRUD.readPreguntas(preguntasEntity);

        while (resultx.moveToNext()){
            PreguntasEntity entity1 = new PreguntasEntity(
                    resultx.getString(Constans.dbColumPregunt_nombre_index),
                    resultx.getInt(Constans.dbColumPregunt_subcate_index)
            );
            entityArrayList.add(entity1);
        }

        referenciar();

        txtPregunta1.setText(entityArrayList.get(0).getNombrePregunta());
        txtPregunta2.setText(entityArrayList.get(1).getNombrePregunta());
        txtPregunta3.setText(entityArrayList.get(2).getNombrePregunta());
        txtPregunta4.setText(entityArrayList.get(3).getNombrePregunta());
        txtPregunta5.setText(entityArrayList.get(4).getNombrePregunta());
        txtPregunta6.setText(entityArrayList.get(5).getNombrePregunta());

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

    private void referenciar() {
        radioGroup1 = (RadioGroup) findViewById(R.id.rgUno);
        radioGroup2 = (RadioGroup) findViewById(R.id.rgDos);
        radioGroup3 = (RadioGroup) findViewById(R.id.rgTres);
        radioGroup4 = (RadioGroup) findViewById(R.id.rgCuatro);
        radioGroup5 = (RadioGroup) findViewById(R.id.rgCinco);
        radioGroup6 = (RadioGroup) findViewById(R.id.rgSeis);
        //Text View
        txtPregunta1 = (TextView) findViewById(R.id.txtPreguntaUno);
        txtPregunta2 = (TextView) findViewById(R.id.txtPreguntaDos);
        txtPregunta3 = (TextView) findViewById(R.id.txtPreguntaTres);
        txtPregunta4 = (TextView) findViewById(R.id.txtPreguntaCuatro);
        txtPregunta5 = (TextView) findViewById(R.id.txtPreguntaCinco);
        txtPregunta6 = (TextView) findViewById(R.id.txtPreguntaSeis);
    }
}
