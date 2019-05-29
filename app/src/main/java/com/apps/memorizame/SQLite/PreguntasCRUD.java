package com.apps.memorizame.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.apps.memorizame.Entitys.PreguntasEntity;
import com.apps.memorizame.Tools.Constans;

public class PreguntasCRUD {

    Database database;
    SQLiteDatabase db;

    public PreguntasCRUD(Context context){database= new Database(context);}

    public long insertPreguntas (PreguntasEntity preguntasEntity){
        db = database.getWritableDatabase();
        //columna de la tabla con su valor
        ContentValues values = new ContentValues();
        values.put(Constans.dbColumPregunt_nombre, preguntasEntity.getNombrePregunta());
        values.put(Constans.dbColumPregunt_subcate, preguntasEntity.getIdTipoSubCate());

        return db.insert(Constans.dbTbPregun, Constans.dbColumPregunt_id, values);
    }
}
