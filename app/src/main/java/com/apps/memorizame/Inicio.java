package com.apps.memorizame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.apps.memorizame.Tools.Constans;

public class Inicio extends AppCompatActivity implements InicioFrgCategorias.ClickCategorias, InicioFrgSubCategorias.ClickSubCategorias, InicioFrgImagen.ClickImagen, InicioFrgPreguntas.ClickPreguntas {

    //declaracion de variables
    private int idCategorias=0;
    private int idSubCategorias=0;
    private InicioFrgImagen frgImagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //evitar que se recargue esta actividad si se cambia a landscape
        if(savedInstanceState == null){
            iniciarFragmentos();
        }
    }

    private void iniciarFragmentos(){
        //crear isntancia de frg y cargar
        getSupportFragmentManager().beginTransaction().replace(R.id.inicio_content_frg, new InicioFrgCategorias()).commit();
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
                Intent intento = new Intent(Inicio.this, Instrucciones.class);
                startActivity(intento);
                break;
        }
        return true;
    }

    @Override
    public void ClickCategorias(int idCategorias) {
        //guardar ID, ya que si el user quiere reintentar prueba
        //hay que cargar la de imagen simulando cargar la subcategoria
        this.idCategorias = idCategorias;

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

    @Override
    public void ClickSubCategorias(int idSubCategorias) {
        //guardar ID, ya que si el user quiere reintentar prueba
        //hay que cargar la de imagen simulando cargar la subcategoria
        this.idSubCategorias = idSubCategorias;

        //argumentos a enviar
        Bundle bundle = new Bundle();
        bundle.putInt(Constans.dbColumSubCatego_id, idSubCategorias);

        //creacion del frg
        frgImagenes = new InicioFrgImagen();
        frgImagenes.setArguments(bundle);

        //iniciar frg
        FragmentTransaction ts = getSupportFragmentManager().beginTransaction();
        ts.replace(R.id.inicio_content_frg, frgImagenes);
        ts.addToBackStack("Imagen");
        ts.commit();
    }

    @Override
    public void ClickImagen() {
        //argumentos a enviar
        Bundle bundle = new Bundle();
        bundle.putInt(Constans.dbColumCatego_id, idCategorias);
        bundle.putInt(Constans.dbColumSubCatego_id, idSubCategorias);

        //creacion del frg
        InicioFrgPreguntas inicioFrgPreguntas = new InicioFrgPreguntas();
        inicioFrgPreguntas.setArguments(bundle);

        //iniciar frg
        FragmentTransaction ts = getSupportFragmentManager().beginTransaction();
        ts.replace(R.id.inicio_content_frg, inicioFrgPreguntas);
        ts.addToBackStack("Preguntas");
        ts.commit();
    }

    @Override
    public void ClickPreguntasReintentar() {
        //elimina todos y recrea la de categorias
        ClickPreguntasContinuar();

        //simula evento click en la subcategoria con el ID guardado
        //llama al override de la interface con el ID
        ClickCategorias(idCategorias);
        ClickSubCategorias(idSubCategorias);
    }

    @Override
    public void ClickPreguntasContinuar() {
        //elimina todos los fragmentos
        getSupportFragmentManager().popBackStack("SubCategorias",FragmentManager.POP_BACK_STACK_INCLUSIVE);

        //inicia de nuevo todos los fragmentos
        iniciarFragmentos();

        //simula evento click en la categoria con el ID guardado
        //llama al override de la interface con el ID
        ClickCategorias(idCategorias);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
