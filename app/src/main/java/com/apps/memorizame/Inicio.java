package com.apps.memorizame;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.apps.memorizame.Adapters.InicioAdapter;
import com.apps.memorizame.Entitys.InicioEntity;
import java.util.ArrayList;

public class Inicio extends AppCompatActivity {

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
        getSupportFragmentManager().beginTransaction().add(R.id.inicio_content_frg, categorias).commit();
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
                Toast.makeText(this, "Colocar las instrucciones :v", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
