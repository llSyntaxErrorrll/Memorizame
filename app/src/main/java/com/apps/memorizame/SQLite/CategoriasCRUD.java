package com.apps.memorizame.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.apps.memorizame.Entitys.CategoriasEntity;
import com.apps.memorizame.Tools.Constans;

import java.util.ArrayList;

public class CategoriasCRUD {

    //declracion de variables de db
    private Database database;
    private SQLiteDatabase db;

    public CategoriasCRUD(Context context){
        database = new Database(context);
    }

    public long insert(CategoriasEntity entity){
        db = database.getWritableDatabase();

        //columna de la tabla con su valor
        ContentValues values = new ContentValues();
        values.put(Constans.dbColumCatego_name, entity.getNombre());
        values.put(Constans.dbColumCatego_imag, entity.getImagen());
        values.put(Constans.dbColumCatego_esta, entity.getIdEstado());

        //inserta en db
        long rs = db.insert(Constans.dbTbCatego, Constans.dbColumCatego_id, values);
        db.close();
        return rs;
    }

    public Cursor read(){
        db = database.getReadableDatabase();
        Cursor rs = db.rawQuery("SELECT * FROM "+Constans.dbTbCatego,null);
        return rs;
    }

    public boolean isFristTime(){
        try{
            //consulta en db
            db = database.getReadableDatabase();
            Cursor rows = db.rawQuery("SELECT count('"+ Constans.dbColumCatego_id+"') FROM "+Constans.dbTbCatego,null);

            //conteno de los registros
            rows.moveToFirst();
            boolean rs = (rows.getInt(0) <= 0);

            if(rs){
                db = database.getWritableDatabase();
                //entidades quemadas
                CategoriasEntity casas = new CategoriasEntity("Casas", "cat_casas",1);
                CategoriasEntity animal = new CategoriasEntity("Animales","cat_animales",0);
                CategoriasEntity calles = new CategoriasEntity("Calles","cat_calle",0);

                //insertar cada entidad
                insert(casas);
                insert(animal);
                insert(calles);
            }

            //finaliza
            db.close();
            return rs;

        }catch (Exception e){
            return true;
        }
    }
}
