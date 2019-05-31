package com.apps.memorizame;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.apps.memorizame.Entitys.PreguntasEntity;
import com.apps.memorizame.Entitys.SubCategoriasEntity;
import com.apps.memorizame.SQLite.PreguntasCRUD;
import com.apps.memorizame.SQLite.SubCategoriasCRUD;
import com.apps.memorizame.Tools.Constans;

import java.util.ArrayList;

public class InicioFrgPreguntas extends Fragment {

    //declaracion de variables
    private ClickPreguntas clickPreguntas;
    private RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5,
            radioButton6,radioButton7, radioButton8, radioButton9, radioButton10, radioButton11,
            radioButton12,radioButton13, radioButton14, radioButton15, radioButton16, radioButton17, radioButton18;
    private TextView txtPregunta1,txtPregunta2, txtPregunta3, txtPregunta4, txtPregunta5, txtPregunta6;
    private Button btnTermionarPregunta;
    private int idSubCategoria,idCategoria;
    private String respuestCorecct1,respuestCorecct2,respuestCorecct3,respuestCorecct4,respuestCorecct5,respuestCorecct6;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            idCategoria = getArguments().getInt(Constans.dbColumCatego_id);
            idSubCategoria = getArguments().getInt(Constans.dbColumSubCatego_id);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.inicio_frg_preguntas, container, false);

        //metodos
        PreguntasEntity preguntasEntity = new PreguntasEntity("", idSubCategoria,
                "","","","");
        PreguntasCRUD preguntasCRUD = new PreguntasCRUD(view.getContext());

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

        return view;
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

                    // one of the radio buttons is checked
                    int radioButtonId = radioGroup1.getCheckedRadioButtonId();
                    View radioButton = radioGroup1.findViewById(radioButtonId);
                    int indice = radioGroup1.indexOfChild(radioButton);
                    RadioButton rb = (RadioButton)  radioGroup1.getChildAt(indice);
                    String texto = rb.getText().toString();
                    if (texto.equals(respuestCorecct1)){
                        total += 1;
                    }

                    int radioButtonId2 = radioGroup2.getCheckedRadioButtonId();
                    View radioButton2 = radioGroup2.findViewById(radioButtonId2);
                    int indice2 = radioGroup2.indexOfChild(radioButton2);
                    RadioButton rb2 = (RadioButton)  radioGroup2.getChildAt(indice2);
                    String texto2 = rb2.getText().toString();
                    if (texto2.equals(respuestCorecct2)){
                        total += 1;
                    }

                    int radioButtonId3 = radioGroup3.getCheckedRadioButtonId();
                    View radioButton3 = radioGroup3.findViewById(radioButtonId3);
                    int indice3 = radioGroup3.indexOfChild(radioButton3);
                    RadioButton rb3 = (RadioButton)  radioGroup1.getChildAt(indice3);
                    String texto3 = rb3.getText().toString();
                    if (texto3.equals(respuestCorecct3)){
                        total += 1;
                    }

                    int radioButtonId4 = radioGroup4.getCheckedRadioButtonId();
                    View radioButton4 = radioGroup4.findViewById(radioButtonId4);
                    int indice4= radioGroup4.indexOfChild(radioButton4);
                    RadioButton rb4 = (RadioButton)  radioGroup4.getChildAt(indice4);
                    String texto4 = rb4.getText().toString();
                    if (texto4.equals(respuestCorecct4)){
                        total += 1;
                    }

                    int radioButtonId5 = radioGroup5.getCheckedRadioButtonId();
                    View radioButton5 = radioGroup5.findViewById(radioButtonId5);
                    int indice5 = radioGroup5.indexOfChild(radioButton5);
                    RadioButton rb5 = (RadioButton)  radioGroup5.getChildAt(indice5);
                    String texto5 = rb5.getText().toString();
                    if (texto5.equals(respuestCorecct5)){
                        total += 1;
                    }

                    int radioButtonId6 = radioGroup6.getCheckedRadioButtonId();
                    View radioButton6 = radioGroup6.findViewById(radioButtonId6);
                    int indice6 = radioGroup6.indexOfChild(radioButton6);
                    RadioButton rb6 = (RadioButton)  radioGroup6.getChildAt(indice6);
                    String texto6 = rb6.getText().toString();
                    if (texto6.equals(respuestCorecct6)){
                        total += 1;
                    }
                    String tot = String.valueOf(total);

                    //entidad que tiene la calificacion y el id actual
                    SubCategoriasEntity entity = new SubCategoriasEntity(null,null,idCategoria,0,total);
                    entity.setIdSubCategoria(idSubCategoria);

                    //actualiza en DB la calificacion, y actualiza el estado del siguiente registro
                    //si supera todu el reto bien
                    SubCategoriasCRUD categoriasCRUD = new SubCategoriasCRUD(view.getContext());
                    categoriasCRUD.update(entity);

                    //imprime resultados
                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(view.getContext());
                    dialogo1.setTitle("Genial!!!");
                    dialogo1.setMessage("Tu puntaje es de: "+tot+" / 6");
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
        //llamada callback para continuar
        clickPreguntas.ClickPreguntasContinuar();
    }
    private void cancelar(){
        //llamada callback para reintentar
        clickPreguntas.ClickPreguntasReintentar();
    }
    private void referenciar() {
        radioGroup1 = (RadioGroup) view.findViewById(R.id.rgUno);
        radioGroup2 = (RadioGroup) view.findViewById(R.id.rgDos);
        radioGroup3 = (RadioGroup) view.findViewById(R.id.rgTres);
        radioGroup4 = (RadioGroup) view.findViewById(R.id.rgCuatro);
        radioGroup5 = (RadioGroup) view.findViewById(R.id.rgCinco);
        radioGroup6 = (RadioGroup) view.findViewById(R.id.rgSeis);
        //Text View
        txtPregunta1 = (TextView) view.findViewById(R.id.txtPreguntaUno);
        txtPregunta2 = (TextView) view.findViewById(R.id.txtPreguntaDos);
        txtPregunta3 = (TextView) view.findViewById(R.id.txtPreguntaTres);
        txtPregunta4 = (TextView) view.findViewById(R.id.txtPreguntaCuatro);
        txtPregunta5 = (TextView) view.findViewById(R.id.txtPreguntaCinco);
        txtPregunta6 = (TextView) view.findViewById(R.id.txtPreguntaSeis);
        //radio Button
        radioButton1 = (RadioButton) view.findViewById(R.id.rbUno);
        radioButton2 = (RadioButton) view.findViewById(R.id.rbDos);
        radioButton3 = (RadioButton) view.findViewById(R.id.rbTres);
        radioButton4 = (RadioButton) view.findViewById(R.id.rbCuatro);
        radioButton5 = (RadioButton) view.findViewById(R.id.rbCinco);
        radioButton6 = (RadioButton) view.findViewById(R.id.rbSeis);
        radioButton7 = (RadioButton) view.findViewById(R.id.rbSiete);
        radioButton8 = (RadioButton) view.findViewById(R.id.rbOcho);
        radioButton9 = (RadioButton) view.findViewById(R.id.rbNueve);
        radioButton10 = (RadioButton) view.findViewById(R.id.rbDiez);
        radioButton11 = (RadioButton) view.findViewById(R.id.rbOnce);
        radioButton12 = (RadioButton) view.findViewById(R.id.rbDoce);
        radioButton13 = (RadioButton) view.findViewById(R.id.rbTrece);
        radioButton14 = (RadioButton) view.findViewById(R.id.rbCatorce);
        radioButton15 = (RadioButton) view.findViewById(R.id.rbQuince);
        radioButton16 = (RadioButton) view.findViewById(R.id.rbDiezySeis);
        radioButton17 = (RadioButton) view.findViewById(R.id.rbDiezysiete);
        radioButton18 = (RadioButton) view.findViewById(R.id.rbDiezyocho);
        //botones
        btnTermionarPregunta = (Button) view.findViewById(R.id.btnterminarPregu);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        clickPreguntas = (ClickPreguntas) context;
    }

    public interface ClickPreguntas {
        void ClickPreguntasReintentar();
        void ClickPreguntasContinuar();
    }
}
