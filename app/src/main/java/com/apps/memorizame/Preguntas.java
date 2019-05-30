package com.apps.memorizame;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.apps.memorizame.Entitys.PreguntasEntity;
import com.apps.memorizame.SQLite.PreguntasCRUD;
import com.apps.memorizame.Tools.Constans;

import java.util.ArrayList;

public class Preguntas extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5,
    radioButton6,radioButton7, radioButton8, radioButton9, radioButton10, radioButton11,
    radioButton12,radioButton13, radioButton14, radioButton15, radioButton16, radioButton17, radioButton18;
    TextView txtPregunta1,txtPregunta2, txtPregunta3, txtPregunta4, txtPregunta5, txtPregunta6;
    int idSubCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        //obtiene el id ed la subcategoria
        idSubCategoria = getIntent().getExtras().getInt("id");

        PreguntasEntity preguntasEntity = new PreguntasEntity("", idSubCategoria,
                "","","","");
        PreguntasCRUD preguntasCRUD = new PreguntasCRUD(getApplicationContext());

        ArrayList<PreguntasEntity> entityArrayList = new ArrayList<>();
        Cursor resultx = preguntasCRUD.readPreguntas(preguntasEntity);

        while (resultx.moveToNext()){
            PreguntasEntity entity1 = new PreguntasEntity(
                    resultx.getString(Constans.dbColumPregunt_nombre_index),
                    resultx.getInt(Constans.dbColumPregunt_subcate_index),
                    resultx.getString(Constans.dbColumPregunt_Respuesta1_index),
                    resultx.getString(Constans.dbColumPregunt_Respuesta2_index),
                    resultx.getString(Constans.dbColumPregunt_Respuesta3_index),
                    resultx.getString(Constans.dbColumPregunt_RespuestaCorrrecta_index)
            );
            entity1.setIdPregunta(resultx.getInt(Constans.dbColumPregunt_id_index));
            entityArrayList.add(entity1);
        }

        referenciar();

        txtPregunta1.setText(entityArrayList.get(0).getNombrePregunta());
        txtPregunta2.setText(entityArrayList.get(1).getNombrePregunta());
        txtPregunta3.setText(entityArrayList.get(2).getNombrePregunta());
        txtPregunta4.setText(entityArrayList.get(3).getNombrePregunta());
        txtPregunta5.setText(entityArrayList.get(4).getNombrePregunta());
        txtPregunta6.setText(entityArrayList.get(5).getNombrePregunta());




        //setear  el valor a los radioButton
        radioButton1.setText(entityArrayList.get(0).getRespuesta1());
        radioButton2.setText(entityArrayList.get(0).getRespuesta2());
        radioButton3.setText(entityArrayList.get(0).getRespuesta3());

        radioButton4.setText(entityArrayList.get(1).getRespuesta1());
        radioButton5.setText(entityArrayList.get(1).getRespuesta2());
        radioButton6.setText(entityArrayList.get(1).getRespuesta3());

        radioButton7.setText(entityArrayList.get(2).getRespuesta1());
        radioButton8.setText(entityArrayList.get(2).getRespuesta2());
        radioButton9.setText(entityArrayList.get(2).getRespuesta3());

        radioButton10.setText(entityArrayList.get(3).getRespuesta1());
        radioButton11.setText(entityArrayList.get(3).getRespuesta2());
        radioButton12.setText(entityArrayList.get(3).getRespuesta3());

        radioButton13.setText(entityArrayList.get(4).getRespuesta1());
        radioButton14.setText(entityArrayList.get(4).getRespuesta2());
        radioButton15.setText(entityArrayList.get(4).getRespuesta3());

        radioButton16.setText(entityArrayList.get(5).getRespuesta1());
        radioButton17.setText(entityArrayList.get(5).getRespuesta2());
        radioButton18.setText(entityArrayList.get(5).getRespuesta3());
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
