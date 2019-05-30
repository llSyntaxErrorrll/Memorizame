package com.apps.memorizame.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
        values.put(Constans.dbColumPregunt_Respuesta1, preguntasEntity.getRespuesta1());
        values.put(Constans.dbColumPregunt_Respuesta2, preguntasEntity.getRespuesta2());
        values.put(Constans.dbColumPregunt_Respuesta3, preguntasEntity.getRespuesta3());
        values.put(Constans.dbColumPregunt_RespuestaCorrecta, preguntasEntity.getRespuestaCorrect());
        long rs = db.insert(Constans.dbTbPregun, Constans.dbColumPregunt_id, values);
        db.close();
        return rs;
    }

    //Consultar por Id
    public Cursor readPreguntas(PreguntasEntity preguntasEntity){
        db = database.getReadableDatabase();
        String[] argumentos = {String.valueOf(preguntasEntity.getIdTipoSubCate())};
        Cursor rs = db.rawQuery("SELECT * FROM "+Constans.dbTbPregun +" WHERE "+ Constans.dbColumPregunt_subcate +
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
                PreguntasEntity casasSub1Pregunta1 = new PreguntasEntity("Hola",1,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub1Pregunta2 = new PreguntasEntity("K",1,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub1Pregunta3 = new PreguntasEntity("Hace",1,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub1Pregunta4 = new PreguntasEntity("Mija",1,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub1Pregunta5 = new PreguntasEntity("Trabaje",1,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub1Pregunta6 = new PreguntasEntity("Vos sabes",1,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub1Pregunta1);
                insertPreguntas(casasSub1Pregunta2);
                insertPreguntas(casasSub1Pregunta3);
                insertPreguntas(casasSub1Pregunta4);
                insertPreguntas(casasSub1Pregunta5);
                insertPreguntas(casasSub1Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub2Pregunta1 = new PreguntasEntity("Casas",2,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub2Pregunta2 = new PreguntasEntity("Casas",2,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub2Pregunta3 = new PreguntasEntity("Casas",2,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub2Pregunta4 = new PreguntasEntity("Casas",2,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub2Pregunta5 = new PreguntasEntity("Casas",2,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub2Pregunta6 = new PreguntasEntity("Casas",2,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub2Pregunta1);
                insertPreguntas(casasSub2Pregunta2);
                insertPreguntas(casasSub2Pregunta3);
                insertPreguntas(casasSub2Pregunta4);
                insertPreguntas(casasSub2Pregunta5);
                insertPreguntas(casasSub2Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub3Pregunta1 = new PreguntasEntity("Casas",3,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub3Pregunta2 = new PreguntasEntity("Casas",3,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub3Pregunta3 = new PreguntasEntity("Casas",3,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub3Pregunta4 = new PreguntasEntity("Casas",3,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub3Pregunta5 = new PreguntasEntity("Casas",3,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub3Pregunta6 = new PreguntasEntity("Casas",3,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub3Pregunta1);
                insertPreguntas(casasSub3Pregunta2);
                insertPreguntas(casasSub3Pregunta3);
                insertPreguntas(casasSub3Pregunta4);
                insertPreguntas(casasSub3Pregunta5);
                insertPreguntas(casasSub3Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub4Pregunta1 = new PreguntasEntity("Casas",4,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub4Pregunta2 = new PreguntasEntity("Casas",4,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub4Pregunta3 = new PreguntasEntity("Casas",4,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub4Pregunta4 = new PreguntasEntity("Casas",4,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub4Pregunta5 = new PreguntasEntity("Casas",4,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub4Pregunta6 = new PreguntasEntity("Casas",4,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub4Pregunta1);
                insertPreguntas(casasSub4Pregunta2);
                insertPreguntas(casasSub4Pregunta3);
                insertPreguntas(casasSub4Pregunta4);
                insertPreguntas(casasSub4Pregunta5);
                insertPreguntas(casasSub4Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub5Pregunta1 = new PreguntasEntity("Casas",5,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub5Pregunta2 = new PreguntasEntity("Casas",5,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub5Pregunta3 = new PreguntasEntity("Casas",5,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub5Pregunta4 = new PreguntasEntity("Casas",5,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub5Pregunta5 = new PreguntasEntity("Casas",5,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub5Pregunta6 = new PreguntasEntity("Casas",5,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub5Pregunta1);
                insertPreguntas(casasSub5Pregunta2);
                insertPreguntas(casasSub5Pregunta3);
                insertPreguntas(casasSub5Pregunta4);
                insertPreguntas(casasSub5Pregunta5);
                insertPreguntas(casasSub5Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub6Pregunta1 = new PreguntasEntity("Casas",6,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub6Pregunta2 = new PreguntasEntity("Casas",6,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub6Pregunta3 = new PreguntasEntity("Casas",6,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub6Pregunta4 = new PreguntasEntity("Casas",6,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub6Pregunta5 = new PreguntasEntity("Casas",6,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub6Pregunta6 = new PreguntasEntity("Casas",6,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub6Pregunta1);
                insertPreguntas(casasSub6Pregunta2);
                insertPreguntas(casasSub6Pregunta3);
                insertPreguntas(casasSub6Pregunta4);
                insertPreguntas(casasSub6Pregunta5);
                insertPreguntas(casasSub6Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub7Pregunta1 = new PreguntasEntity("Casas",7,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub7Pregunta2 = new PreguntasEntity("Casas",7,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub7Pregunta3 = new PreguntasEntity("Casas",7,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub7Pregunta4 = new PreguntasEntity("Casas",7,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub7Pregunta5 = new PreguntasEntity("Casas",7,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub7Pregunta6 = new PreguntasEntity("Casas",7,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub7Pregunta1);
                insertPreguntas(casasSub7Pregunta2);
                insertPreguntas(casasSub7Pregunta3);
                insertPreguntas(casasSub7Pregunta4);
                insertPreguntas(casasSub7Pregunta5);
                insertPreguntas(casasSub7Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub8Pregunta1 = new PreguntasEntity("Casas",8,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub8Pregunta2 = new PreguntasEntity("Casas",8,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub8Pregunta3 = new PreguntasEntity("Casas",8,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub8Pregunta4 = new PreguntasEntity("Casas",8,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub8Pregunta5 = new PreguntasEntity("Casas",8,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub8Pregunta6 = new PreguntasEntity("Casas",8,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub8Pregunta1);
                insertPreguntas(casasSub8Pregunta2);
                insertPreguntas(casasSub8Pregunta3);
                insertPreguntas(casasSub8Pregunta4);
                insertPreguntas(casasSub8Pregunta5);
                insertPreguntas(casasSub8Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub9Pregunta1 = new PreguntasEntity("Casas",9,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub9Pregunta2 = new PreguntasEntity("Casas",9,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub9Pregunta3 = new PreguntasEntity("Casas",9,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub9Pregunta4 = new PreguntasEntity("Casas",9,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub9Pregunta5 = new PreguntasEntity("Casas",9,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub9Pregunta6 = new PreguntasEntity("Casas",9,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub9Pregunta1);
                insertPreguntas(casasSub9Pregunta2);
                insertPreguntas(casasSub9Pregunta3);
                insertPreguntas(casasSub9Pregunta4);
                insertPreguntas(casasSub9Pregunta5);
                insertPreguntas(casasSub9Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub10Pregunta1 = new PreguntasEntity("Casas",10,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub10Pregunta2 = new PreguntasEntity("Casas",10,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub10Pregunta3 = new PreguntasEntity("Casas",10,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub10Pregunta4 = new PreguntasEntity("Casas",10,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub10Pregunta5 = new PreguntasEntity("Casas",10,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub10Pregunta6 = new PreguntasEntity("Casas",10,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub10Pregunta1);
                insertPreguntas(casasSub10Pregunta2);
                insertPreguntas(casasSub10Pregunta3);
                insertPreguntas(casasSub10Pregunta4);
                insertPreguntas(casasSub10Pregunta5);
                insertPreguntas(casasSub10Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub11Pregunta1 = new PreguntasEntity("Casas",11,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub11Pregunta2 = new PreguntasEntity("Casas",11,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub11Pregunta3 = new PreguntasEntity("Casas",11,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub11Pregunta4 = new PreguntasEntity("Casas",11,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub11Pregunta5 = new PreguntasEntity("Casas",11,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub11Pregunta6 = new PreguntasEntity("Casas",11,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub11Pregunta1);
                insertPreguntas(casasSub11Pregunta2);
                insertPreguntas(casasSub11Pregunta3);
                insertPreguntas(casasSub11Pregunta4);
                insertPreguntas(casasSub11Pregunta5);
                insertPreguntas(casasSub11Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub12Pregunta1 = new PreguntasEntity("Casas",12,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub12Pregunta2 = new PreguntasEntity("Casas",12,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub12Pregunta3 = new PreguntasEntity("Casas",12,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub12Pregunta4 = new PreguntasEntity("Casas",12,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub12Pregunta5 = new PreguntasEntity("Casas",12,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub12Pregunta6 = new PreguntasEntity("Casas",12,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub12Pregunta1);
                insertPreguntas(casasSub12Pregunta2);
                insertPreguntas(casasSub12Pregunta3);
                insertPreguntas(casasSub12Pregunta4);
                insertPreguntas(casasSub12Pregunta5);
                insertPreguntas(casasSub12Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub13Pregunta1 = new PreguntasEntity("Casas",13,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub13Pregunta2 = new PreguntasEntity("Casas",13,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub13Pregunta3 = new PreguntasEntity("Casas",13,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub13Pregunta4 = new PreguntasEntity("Casas",13,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub13Pregunta5 = new PreguntasEntity("Casas",13,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub13Pregunta6 = new PreguntasEntity("Casas",13,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub13Pregunta1);
                insertPreguntas(casasSub13Pregunta2);
                insertPreguntas(casasSub13Pregunta3);
                insertPreguntas(casasSub13Pregunta4);
                insertPreguntas(casasSub13Pregunta5);
                insertPreguntas(casasSub13Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub14Pregunta1 = new PreguntasEntity("Casas",14,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub14Pregunta2 = new PreguntasEntity("Casas",14,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub14Pregunta3 = new PreguntasEntity("Casas",14,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub14Pregunta4 = new PreguntasEntity("Casas",14,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub14Pregunta5 = new PreguntasEntity("Casas",14,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub14Pregunta6 = new PreguntasEntity("Casas",14,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub14Pregunta1);
                insertPreguntas(casasSub14Pregunta2);
                insertPreguntas(casasSub14Pregunta3);
                insertPreguntas(casasSub14Pregunta4);
                insertPreguntas(casasSub14Pregunta5);
                insertPreguntas(casasSub14Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub15Pregunta1 = new PreguntasEntity("Casas",15,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub15Pregunta2 = new PreguntasEntity("Casas",15,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub15Pregunta3 = new PreguntasEntity("Casas",15,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub15Pregunta4 = new PreguntasEntity("Casas",15,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub15Pregunta5 = new PreguntasEntity("Casas",15,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub15Pregunta6 = new PreguntasEntity("Casas",15,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub15Pregunta1);
                insertPreguntas(casasSub15Pregunta2);
                insertPreguntas(casasSub15Pregunta3);
                insertPreguntas(casasSub15Pregunta4);
                insertPreguntas(casasSub15Pregunta5);
                insertPreguntas(casasSub15Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub16Pregunta1 = new PreguntasEntity("Casas",16,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub16Pregunta2 = new PreguntasEntity("Casas",16,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub16Pregunta3 = new PreguntasEntity("Casas",16,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub16Pregunta4 = new PreguntasEntity("Casas",16,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub16Pregunta5 = new PreguntasEntity("Casas",16,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub16Pregunta6 = new PreguntasEntity("Casas",16,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub16Pregunta1);
                insertPreguntas(casasSub16Pregunta2);
                insertPreguntas(casasSub16Pregunta3);
                insertPreguntas(casasSub16Pregunta4);
                insertPreguntas(casasSub16Pregunta5);
                insertPreguntas(casasSub16Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub17Pregunta1 = new PreguntasEntity("Casas",17,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub17Pregunta2 = new PreguntasEntity("Casas",17,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub17Pregunta3 = new PreguntasEntity("Casas",17,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub17Pregunta4 = new PreguntasEntity("Casas",17,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub17Pregunta5 = new PreguntasEntity("Casas",17,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub17Pregunta6 = new PreguntasEntity("Casas",17,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub17Pregunta1);
                insertPreguntas(casasSub17Pregunta2);
                insertPreguntas(casasSub17Pregunta3);
                insertPreguntas(casasSub17Pregunta4);
                insertPreguntas(casasSub17Pregunta5);
                insertPreguntas(casasSub17Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub18Pregunta1 = new PreguntasEntity("Casas",18,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub18Pregunta2 = new PreguntasEntity("Casas",18,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub18Pregunta3 = new PreguntasEntity("Casas",18,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub18Pregunta4 = new PreguntasEntity("Casas",18,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub18Pregunta5 = new PreguntasEntity("Casas",18,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub18Pregunta6 = new PreguntasEntity("Casas",18,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub18Pregunta1);
                insertPreguntas(casasSub18Pregunta2);
                insertPreguntas(casasSub18Pregunta3);
                insertPreguntas(casasSub18Pregunta4);
                insertPreguntas(casasSub18Pregunta5);
                insertPreguntas(casasSub18Pregunta6);
            }

            //finaliza
            db.close();
            return rs;

        }catch (Exception e){
            return true;
        }
    }
}
