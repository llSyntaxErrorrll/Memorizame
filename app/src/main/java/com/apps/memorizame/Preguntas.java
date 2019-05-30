package com.apps.memorizame;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.memorizame.Entitys.PreguntasEntity;
import com.apps.memorizame.SQLite.PreguntasCRUD;
import com.apps.memorizame.Tools.Constans;

import java.util.ArrayList;

public class Preguntas extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5,
    radioButton6,radioButton7, radioButton8, radioButton9, radioButton10, radioButton11,
    radioButton12,radioButton13, radioButton14, radioButton15, radioButton16, radioButton17, radioButton18;
    TextView txtPregunta1,txtPregunta2, txtPregunta3, txtPregunta4, txtPregunta5, txtPregunta6, txttotal;
    Button btnTermionarPregunta;
    int idSubCategoria;
    String respuestCorecct1,respuestCorecct2,respuestCorecct3,respuestCorecct4,respuestCorecct5,respuestCorecct6;
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

        //respuestas
        respuestCorecct1 = entityArrayList.get(0).getRespuestaCorrect();
        respuestCorecct2 = entityArrayList.get(1).getRespuestaCorrect();
        respuestCorecct3 = entityArrayList.get(2).getRespuestaCorrect();
        respuestCorecct4 = entityArrayList.get(3).getRespuestaCorrect();
        respuestCorecct5 = entityArrayList.get(4).getRespuestaCorrect();
        respuestCorecct6 = entityArrayList.get(5).getRespuestaCorrect();

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

        respuestasCorrectas();
        //boton

    }

    private void rdioButtonRojos() {

        radioButton1.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton2.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton3.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton4.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton5.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton6.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton7.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton8.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton9.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton10.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton11.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton12.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton13.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton14.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton15.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton16.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton17.setTextColor(getResources().getColor(R.color.RojoOscuro));
        radioButton18.setTextColor(getResources().getColor(R.color.RojoOscuro));
    }

    private void respuestasCorrectas() {

        btnTermionarPregunta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (radioGroup1.getCheckedRadioButtonId() == -1){

                }else if (radioGroup2.getCheckedRadioButtonId() == -1){

                }else if (radioGroup3.getCheckedRadioButtonId() == -1){

                }else if(radioGroup4.getCheckedRadioButtonId() == -1){

                }else if(radioGroup5.getCheckedRadioButtonId() == -1){

                }else if(radioGroup6.getCheckedRadioButtonId() == -1) {
                    // no radio buttons are checked
                } else {

                    int total = 0;
                    rdioButtonRojos();

                // one of the radio buttons is checked
                    int radioButtonId = radioGroup1.getCheckedRadioButtonId();
                    View radioButton = radioGroup1.findViewById(radioButtonId);
                    int indice = radioGroup1.indexOfChild(radioButton);
                    RadioButton rb = (RadioButton)  radioGroup1.getChildAt(indice);
                    String texto = rb.getText().toString();
                    if (texto == texto){
                        rb.setTextColor(getResources().getColor(R.color.VerdeClaroOscuro));
                        total += 1;
                    }

                    int radioButtonId2 = radioGroup2.getCheckedRadioButtonId();
                    View radioButton2 = radioGroup2.findViewById(radioButtonId2);
                    int indice2 = radioGroup2.indexOfChild(radioButton2);
                    RadioButton rb2 = (RadioButton)  radioGroup2.getChildAt(indice2);
                    String texto2 = rb2.getText().toString();
                    if (texto2 == texto2){
                        rb2.setTextColor(getResources().getColor(R.color.VerdeClaroOscuro));
                        total += 1;
                    }

                    int radioButtonId3 = radioGroup3.getCheckedRadioButtonId();
                    View radioButton3 = radioGroup3.findViewById(radioButtonId3);
                    int indice3 = radioGroup3.indexOfChild(radioButton3);
                    RadioButton rb3 = (RadioButton)  radioGroup1.getChildAt(indice3);
                    String texto3 = rb3.getText().toString();
                    if (texto3 == texto3){
                        rb3.setTextColor(getResources().getColor(R.color.VerdeClaroOscuro));
                        total += 1;
                    }

                    int radioButtonId4 = radioGroup4.getCheckedRadioButtonId();
                    View radioButton4 = radioGroup4.findViewById(radioButtonId4);
                    int indice4= radioGroup4.indexOfChild(radioButton4);
                    RadioButton rb4 = (RadioButton)  radioGroup4.getChildAt(indice4);
                    String texto4 = rb4.getText().toString();
                    if (texto4 == texto4){
                        rb4.setTextColor(getResources().getColor(R.color.VerdeClaroOscuro));
                        total += 1;
                    }

                    int radioButtonId5 = radioGroup5.getCheckedRadioButtonId();
                    View radioButton5 = radioGroup5.findViewById(radioButtonId5);
                    int indice5 = radioGroup5.indexOfChild(radioButton5);
                    RadioButton rb5 = (RadioButton)  radioGroup5.getChildAt(indice5);
                    String texto5 = rb5.getText().toString();
                    if (texto5 == texto5){
                        rb5.setTextColor(getResources().getColor(R.color.VerdeClaroOscuro));
                        total += 1;
                    }

                    int radioButtonId6 = radioGroup6.getCheckedRadioButtonId();
                    View radioButton6 = radioGroup6.findViewById(radioButtonId6);
                    int indice6 = radioGroup6.indexOfChild(radioButton6);
                    RadioButton rb6 = (RadioButton)  radioGroup6.getChildAt(indice6);
                    String texto6 = rb6.getText().toString();
                    if (texto6 == texto6){
                        rb6.setTextColor(getResources().getColor(R.color.VerdeClaroOscuro));
                        total += 1;
                    }
                    String tot = String.valueOf(total);
                    txttotal.setText(tot+"/6");
                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Preguntas.this);
                    dialogo1.setTitle("Genial!!!");
                    dialogo1.setMessage("        Tu puntaje es de "+tot+"/6");
                    dialogo1.setCancelable(false);
                    dialogo1.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            aceptar();
                        }
                    });
                    dialogo1.setNegativeButton("Reintentar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            cancelar();
                        }
                    });
                    dialogo1.show();
                }
            }
        });
    }

    private void aceptar(){

        Intent inte = new Intent(Preguntas.this, Inicio.class);
        inte.putExtra(Constans.dbColumSubCatego_id,idSubCategoria);
        startActivity(inte);
    }
    private void cancelar(){
        Intent inte = new Intent(Preguntas.this, MemorizaImagen.class);
        inte.putExtra(Constans.dbColumSubCatego_id,idSubCategoria);
        startActivity(inte);
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
        txttotal = (TextView) findViewById(R.id.txtTotal);
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
        //botones
        btnTermionarPregunta = (Button) findViewById(R.id.btnterminarPregu);
    }
}
