package com.apps.memorizame;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.apps.memorizame.Tools.Constans;
import com.apps.memorizame.Tools.TheInterface;

public class Inicio extends AppCompatActivity implements TheInterface {

    //declaracion de variables
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //iniciar fragmentos
        iniciarFragmentos();
    }

    private void iniciarFragmentos(){
        //crear isntancia de frg y cargar
        InicioFrgCategorias categorias = new InicioFrgCategorias();
        //iniciar frg
        FragmentTransaction ts = getSupportFragmentManager().beginTransaction();
        ts.add(R.id.inicio_content_frg, categorias);
        ts.addToBackStack("Categorias");
        ts.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //cargar menu inicio
        getMenuInflater().inflate(R.menu.inicio_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.inicio_menu_instrucciones:
                //evento click del menu del toolbar instrucciones
                //Intent intento = new Intent(Inicio.this, Intrucciones.class);
                //startActivity(intento);
                break;
        }
        return true;
    }

    @Override
    public void comunicador(int idCategorias) {
        //argumentos a enviar
        Bundle bundle = new Bundle();
        bundle.putInt(Constans.dbColumCatego_id, idCategorias);

        //creacion del frg
        InicioFrgSubCategorias frgSubCategorias = new InicioFrgSubCategorias();
        frgSubCategorias.setArguments(bundle);

        //iniciar frg
        FragmentTransaction ts = getSupportFragmentManager().beginTransaction();
        ts.replace(R.id.inicio_content_frg, frgSubCategorias);
        ts.addToBackStack("SubCategorias");
        ts.commit();
    }
}
