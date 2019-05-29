package com.apps.memorizame;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.memorizame.Entitys.CategoriasEntity;
import com.apps.memorizame.SQLite.CategoriasCRUD;
import com.apps.memorizame.Tools.Constans;

public class Preguntas extends AppCompatActivity {

    private TextView txtValor;
    private Integer valor;
    private ScrollView mImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);


        CategoriasCRUD categoriasCRUD = new CategoriasCRUD(getApplicationContext());
        CategoriasEntity entity1 = new CategoriasEntity("CATEGORIAX","-700090",1);
        CategoriasEntity entity2 = new CategoriasEntity("CATEGORIAXXX","-700090",0);

        long result1 = categoriasCRUD.insert(entity1);
        long result2 = categoriasCRUD.insert(entity2);

        Toast.makeText(this, "ID GUARDADO: "+result1+", "+result2, Toast.LENGTH_SHORT).show();


        Cursor resultx = categoriasCRUD.read();
        while (resultx.moveToNext()){
            Toast.makeText(this, resultx.getString(Constans.dbColumCatego_name_index), Toast.LENGTH_SHORT).show();
        }



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
}
