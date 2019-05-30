package com.apps.memorizame;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.apps.memorizame.SQLite.CategoriasCRUD;
import com.apps.memorizame.SQLite.PreguntasCRUD;
import com.apps.memorizame.SQLite.SubCategoriasCRUD;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //poner la pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //iniciar la tarea
        splashScreen screen = new splashScreen();
        screen.execute();
    }

    //tarea asincronica para el splascreen
    public class splashScreen extends AsyncTask{
        @Override
        protected Object doInBackground(Object[] objects) {
            try{
                CategoriasCRUD categorias = new CategoriasCRUD(getApplicationContext());
                Boolean categoriasVali = categorias.isFristTime();

                SubCategoriasCRUD subCategorias = new SubCategoriasCRUD(getApplicationContext());
                Boolean SubCategoriasVali = subCategorias.isFristTime();

                PreguntasCRUD preguntas = new PreguntasCRUD(getApplicationContext());
                Boolean preguntasValidator = preguntas.isFristTime();
                /*
                Boolean vefifiFinal = false;

                if(categoriasValidator){
                    vefifiFinal = true;
                }

                Intent pasar = null;

                if (vefifiFinal){
                    //instrucciones 1ra ves
                    //pasar = new Intent(Main.this, Instrucciones.class);
                }else{
                    //pasar al inicio
                    pasar = new Intent(Main.this, Inicio.class);
                }*/



                Thread.sleep(1500);
                Intent pasar = new Intent(Main.this, Inicio.class);
                startActivity(pasar);
                finish();
            }catch (Exception e){
                e.notify();
            }
            return null;
        }
    }
}
