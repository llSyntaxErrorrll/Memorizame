package com.apps.memorizame.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.apps.memorizame.Entitys.RespuestasEntity;
import com.apps.memorizame.Tools.Constans;

public class RespuestasCRUD {

    Database database;
    SQLiteDatabase db;

    public RespuestasCRUD(Context context){database= new Database(context);}

    public long insertPreguntas (RespuestasEntity respuestasEntity){
        db = database.getWritableDatabase();
        //columna de la tabla con su valor
        ContentValues values = new ContentValues();
        values.put(Constans.dbColumRespues_nombre, respuestasEntity.getRespuesta());
        values.put(Constans.dbColumRespues_pre, respuestasEntity.getIdPregunta());
        values.put(Constans.dbColumRespues_respuestaCorerec, respuestasEntity.getRespuestaCorreta());

        return db.insert(Constans.dbTbPregun, Constans.dbColumPregunt_id, values);
    }
}
