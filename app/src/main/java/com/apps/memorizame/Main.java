package com.apps.memorizame;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.apps.memorizame.SQLite.CategoriasCRUD;

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
                /*CategoriasCRUD categorias = new CategoriasCRUD(getApplicationContext());
                Boolean categoriasValidator = categorias.isFristTime();

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
