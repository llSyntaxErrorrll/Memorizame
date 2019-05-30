package com.apps.memorizame;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.memorizame.Entitys.CategoriasEntity;
import com.apps.memorizame.Entitys.PreguntasEntity;
import com.apps.memorizame.Entitys.RespuestasEntity;
import com.apps.memorizame.SQLite.CategoriasCRUD;
import com.apps.memorizame.SQLite.PreguntasCRUD;
import com.apps.memorizame.SQLite.RespuestasCRUD;
import com.apps.memorizame.Tools.Constans;

import java.util.ArrayList;

public class Preguntas extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5,
    radioButton6,radioButton7, radioButton8, radioButton9, radioButton10, radioButton11,
    radioButton12,radioButton13, radioButton14, radioButton15, radioButton16, radioButton17, radioButton18;
    TextView txtPregunta1,txtPregunta2, txtPregunta3, txtPregunta4, txtPregunta5, txtPregunta6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        PreguntasEntity preguntasEntity = new PreguntasEntity("", 1);
        PreguntasCRUD preguntasCRUD = new PreguntasCRUD(getApplicationContext());
        RespuestasCRUD respuestasCRUD = new RespuestasCRUD(getApplicationContext());

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


        RespuestasEntity respuestasEntity1 =
                new RespuestasEntity("", entityArrayList.get(0).getIdPregunta(),"");
        ArrayList<RespuestasEntity> entityArrayListResP1 = new ArrayList<>();
        Cursor resultx2 = respuestasCRUD.readRespuestas(respuestasEntity1);
        while (resultx2.moveToNext()){
            RespuestasEntity entityRes = new RespuestasEntity(
                    resultx2.getString(Constans.dbColumRespues_nombre_index),
                    resultx2.getInt(Constans.dbColumRespues_pre_index),
                    resultx2.getString(Constans.dbColumRespues_respuestaCorret_index)
            );
            entityArrayListResP1.add(entityRes);
        }

        RespuestasEntity respuestasEntity2 =
                new RespuestasEntity("", entityArrayList.get(1).getIdPregunta(),"");
        ArrayList<RespuestasEntity> entityArrayListResP2 = new ArrayList<>();
        Cursor resultx3 = respuestasCRUD.readRespuestas(respuestasEntity2);
        while (resultx3.moveToNext()){
            RespuestasEntity entityRes1 = new RespuestasEntity(
                    resultx3.getString(Constans.dbColumRespues_nombre_index),
                    resultx3.getInt(Constans.dbColumRespues_pre_index),
                    resultx3.getString(Constans.dbColumRespues_respuestaCorret_index)
            );
            entityArrayListResP2.add(entityRes1);
        }

        RespuestasEntity respuestasEntity3 =
                new RespuestasEntity("", entityArrayList.get(2).getIdPregunta(),"");
        ArrayList<RespuestasEntity> entityArrayListResP3 = new ArrayList<>();
        Cursor resultx4 = respuestasCRUD.readRespuestas(respuestasEntity3);
        while (resultx.moveToNext()){
            RespuestasEntity entityRes2 = new RespuestasEntity(
                    resultx4.getString(Constans.dbColumRespues_nombre_index),
                    resultx4.getInt(Constans.dbColumRespues_pre_index),
                    resultx4.getString(Constans.dbColumRespues_respuestaCorret_index)
            );
            entityArrayListResP3.add(entityRes2);
        }

        RespuestasEntity respuestasEntity4 =
                new RespuestasEntity("", entityArrayList.get(3).getIdPregunta(),"");
        ArrayList<RespuestasEntity> entityArrayListResP4 = new ArrayList<>();
        Cursor resultx5 = respuestasCRUD.readRespuestas(respuestasEntity4);
        while (resultx5.moveToNext()){
            RespuestasEntity entityRes3 = new RespuestasEntity(
                    resultx5.getString(Constans.dbColumRespues_nombre_index),
                    resultx5.getInt(Constans.dbColumRespues_pre_index),
                    resultx5.getString(Constans.dbColumRespues_respuestaCorret_index)
            );
            entityArrayListResP4.add(entityRes3);
        }

        RespuestasEntity respuestasEntity5 =
                new RespuestasEntity("", entityArrayList.get(4).getIdPregunta(),"");
        ArrayList<RespuestasEntity> entityArrayListResP5 = new ArrayList<>();
        Cursor resultx6 = respuestasCRUD.readRespuestas(respuestasEntity5);
        while (resultx6.moveToNext()){
            RespuestasEntity entityRes4 = new RespuestasEntity(
                    resultx6.getString(Constans.dbColumRespues_nombre_index),
                    resultx6.getInt(Constans.dbColumRespues_pre_index),
                    resultx6.getString(Constans.dbColumRespues_respuestaCorret_index)
            );
            entityArrayListResP5.add(entityRes4);
        }

        RespuestasEntity respuestasEntity6 =
                new RespuestasEntity("", entityArrayList.get(5).getIdPregunta(),"");
        ArrayList<RespuestasEntity> entityArrayListResP6 = new ArrayList<>();
        Cursor resultx7 = respuestasCRUD.readRespuestas(respuestasEntity6);
        while (resultx.moveToNext()){
            RespuestasEntity entityRes5 = new RespuestasEntity(
                    resultx7.getString(Constans.dbColumRespues_nombre_index),
                    resultx7.getInt(Constans.dbColumRespues_pre_index),
                    resultx7.getString(Constans.dbColumRespues_respuestaCorret_index)
            );
            entityArrayListResP6.add(entityRes5);
        }

        //setear  el valor a los radioButton
        radioButton1.setText(entityArrayListResP1.get(0).getRespuesta());
        radioButton2.setText(entityArrayListResP1.get(1).getRespuesta());
        radioButton3.setText(entityArrayListResP1.get(2).getRespuesta());

        radioButton4.setText(entityArrayListResP2.get(0).getRespuesta());
        radioButton5.setText(entityArrayListResP2.get(1).getRespuesta());
        radioButton6.setText(entityArrayListResP2.get(2).getRespuesta());

        radioButton7.setText(entityArrayListResP3.get(0).getRespuesta());
        radioButton8.setText(entityArrayListResP3.get(1).getRespuesta());
        radioButton9.setText(entityArrayListResP3.get(2).getRespuesta());

        radioButton10.setText(entityArrayListResP4.get(0).getRespuesta());
        radioButton11.setText(entityArrayListResP4.get(1).getRespuesta());
        radioButton12.setText(entityArrayListResP4.get(2).getRespuesta());

        radioButton13.setText(entityArrayListResP5.get(0).getRespuesta());
        radioButton14.setText(entityArrayListResP5.get(1).getRespuesta());
        radioButton15.setText(entityArrayListResP5.get(2).getRespuesta());

        radioButton16.setText(entityArrayListResP6.get(0).getRespuesta());
        radioButton17.setText(entityArrayListResP6.get(1).getRespuesta());
        radioButton18.setText(entityArrayListResP6.get(2).getRespuesta());

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
        //radio Button
        radioButton1 = (RadioButton) findViewById(R.id.rbUno);
        radioButton2 = (RadioButton) findViewById(R.id.rbDos);
        radioButton3 = (RadioButton) findViewById(R.id.rbTres);
        radioButton4 = (RadioButton) findViewById(R.id.rbCuatro);
        radioButton5 = (RadioButton) findViewById(R.id.rbCinco);
        radioButton6 = (RadioButton) findViewById(R.id.rbSeis);
        radioButton7 = (RadioButton) findViewById(R.id.rbSiete);
        radioButton8 = (RadioButton) findViewById(R.id.rbOcho);
        radioButton9 = (RadioButton) findViewById(R.id.rbNueve);
        radioButton10 = (RadioButton) findViewById(R.id.rbDiez);
        radioButton11 = (RadioButton) findViewById(R.id.rbOnce);
        radioButton12 = (RadioButton) findViewById(R.id.rbDoce);
        radioButton13 = (RadioButton) findViewById(R.id.rbTrece);
        radioButton14 = (RadioButton) findViewById(R.id.rbCatorce);
        radioButton15 = (RadioButton) findViewById(R.id.rbQuince);
        radioButton16 = (RadioButton) findViewById(R.id.rbDiezySeis);
        radioButton17 = (RadioButton) findViewById(R.id.rbDiezysiete);
        radioButton18 = (RadioButton) findViewById(R.id.rbDiezyocho);
    }
}
