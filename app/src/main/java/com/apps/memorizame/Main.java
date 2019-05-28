package com.apps.memorizame;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

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
                //1.5s y pasar de actividad
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
