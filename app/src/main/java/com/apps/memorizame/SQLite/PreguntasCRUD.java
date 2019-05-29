package com.apps.memorizame.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.apps.memorizame.Entitys.CategoriasEntity;
import com.apps.memorizame.Entitys.PreguntasEntity;
import com.apps.memorizame.Tools.Constans;

public class PreguntasCRUD {

    private Database database;
    private SQLiteDatabase db;

    public PreguntasCRUD(Context context){ database= new Database(context); }

    public long insertPreguntas (PreguntasEntity preguntasEntity){
        db = database.getWritableDatabase();
        //columna de la tabla con su valor
        ContentValues values = new ContentValues();
        values.put(Constans.dbColumPregunt_nombre, preguntasEntity.getNombrePregunta());
        values.put(Constans.dbColumPregunt_subcate, preguntasEntity.getIdTipoSubCate());
        long rs = db.insert(Constans.dbTbPregun, Constans.dbColumPregunt_id, values);
        db.close();
        return rs;
    }

    public Cursor readPreguntas(PreguntasEntity preguntasEntity){
        db = database.getReadableDatabase();
        String[] argumentos = {String.valueOf(preguntasEntity.getIdPregunta())};
        Cursor rs = db.rawQuery("SELECT * FROM "+Constans.dbTbPregun +" WHERE "+ Constans.dbColumRespues_id +
                " = ? ", argumentos);
        return rs;
    }

    public boolean isFristTime(){
        try{
            //consulta en db
            db = database.getReadableDatabase();
            Cursor rows = db.rawQuery("SELECT count('"+ Constans.dbColumPregunt_id+"') FROM "+Constans.dbTbPregun,null);

            //conteno de los registros
            rows.moveToFirst();
            boolean rs = (rows.getInt(0) <= 0);

            if(rs){
                db = database.getWritableDatabase();
                //entidades quemadas
                CategoriasEntity casas = new CategoriasEntity("Casas","",1);
                CategoriasEntity animal = new CategoriasEntity("Animales","",0);
                CategoriasEntity calles = new CategoriasEntity("Calles","",0);

                //insertar cada entidad
                /*insertPreguntas(casas);
                insert(animal);
                insert(calles);*/
            }

            //finaliza
            db.close();
            return rs;

        }catch (Exception e){
            return true;
        }
    }
}
