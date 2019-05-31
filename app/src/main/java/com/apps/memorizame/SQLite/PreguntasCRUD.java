package com.apps.memorizame.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.apps.memorizame.Entitys.PreguntasEntity;
import com.apps.memorizame.R;
import com.apps.memorizame.Tools.Constans;

public class PreguntasCRUD {

    private Database database;
    private SQLiteDatabase db;
    Resources res ;

    public PreguntasCRUD(Context context){
        res = context.getResources();
        database= new Database(context); }

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
                PreguntasEntity casasSub1Pregunta1 = new PreguntasEntity(res.getString(R.string.casa1pregunta1),1,"respuesta1","respuesta2","respuesta3","rc");
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
                PreguntasEntity casasSub7Pregunta1 = new PreguntasEntity(res.getString(R.string.anim_c1_p1),7,res.getString(R.string.cero),res.getString(R.string.cuatro),res.getString(R.string.dos),res.getString(R.string.cuatro));
                PreguntasEntity casasSub7Pregunta2 = new PreguntasEntity(res.getString(R.string.anim_c1_p2),7,res.getString(R.string.anim_c1_p2_r1),res.getString(R.string.anim_c1_p2_r2),res.getString(R.string.anim_c1_p2_r3),res.getString(R.string.anim_c1_p2_r2));
                PreguntasEntity casasSub7Pregunta3 = new PreguntasEntity(res.getString(R.string.anim_c1_p3),7,"Violeta","Azul","Rojo","Rojo");
                PreguntasEntity casasSub7Pregunta4 = new PreguntasEntity(res.getString(R.string.anim_c1_p4),7,"Fondo borroso","Fondo opaco","Fondo desgastado","Fondo borroso");
                PreguntasEntity casasSub7Pregunta5 = new PreguntasEntity(res.getString(R.string.anim_c1_p5),7,"Contento","Aburrido","Enojado","Contento");
                PreguntasEntity casasSub7Pregunta6 = new PreguntasEntity(res.getString(R.string.anim_c1_p6),7,"Montaña","Parque","Bosque","Bosque");

                //insertar cada entidad
                insertPreguntas(casasSub7Pregunta1);
                insertPreguntas(casasSub7Pregunta2);
                insertPreguntas(casasSub7Pregunta3);
                insertPreguntas(casasSub7Pregunta4);
                insertPreguntas(casasSub7Pregunta5);
                insertPreguntas(casasSub7Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub8Pregunta1 = new PreguntasEntity(res.getString(R.string.anim_c2_p1),8,"Rojo","Azul","Verde","Azul");
                PreguntasEntity casasSub8Pregunta2 = new PreguntasEntity(res.getString(R.string.anim_c2_p2),8,"Cuatro","Dos","Tres","Tres");
                PreguntasEntity casasSub8Pregunta3 = new PreguntasEntity(res.getString(R.string.anim_c2_p3),8,"Verdes","Azules","Cafes","Azules");
                PreguntasEntity casasSub8Pregunta4 = new PreguntasEntity(res.getString(R.string.anim_c2_p4),8,"Dos","Tres","Cuatro","Dos");
                PreguntasEntity casasSub8Pregunta5 = new PreguntasEntity(res.getString(R.string.anim_c2_p5),8,"Verde","Azul","Amarillo","Verde");
                PreguntasEntity casasSub8Pregunta6 = new PreguntasEntity(res.getString(R.string.anim_c2_p6),8,"Uno","Dos","Tres","Uno");

                //insertar cada entidad
                insertPreguntas(casasSub8Pregunta1);
                insertPreguntas(casasSub8Pregunta2);
                insertPreguntas(casasSub8Pregunta3);
                insertPreguntas(casasSub8Pregunta4);
                insertPreguntas(casasSub8Pregunta5);
                insertPreguntas(casasSub8Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub9Pregunta1 = new PreguntasEntity(res.getString(R.string.anim_c3_p1),9,"Uno","Dos","Tres","Uno");
                PreguntasEntity casasSub9Pregunta2 = new PreguntasEntity(res.getString(R.string.anim_c3_p2),9,"Morado","Rosado","Rojo","Rosado");
                PreguntasEntity casasSub9Pregunta3 = new PreguntasEntity(res.getString(R.string.anim_c3_p3),9,"Rojo","Rosado","Morado","Rojo");
                PreguntasEntity casasSub9Pregunta4 = new PreguntasEntity(res.getString(R.string.anim_c3_p4),9,"Amarillo con blanco","Amarillo con cafe","Blanco con Cafe","Amarillo con blanco");
                PreguntasEntity casasSub9Pregunta5 = new PreguntasEntity(res.getString(R.string.anim_c3_p5),9,"Circular","Ovalada","Cuadrada","Circular");
                PreguntasEntity casasSub9Pregunta6 = new PreguntasEntity(res.getString(R.string.anim_c3_p6),9,"Negro","Gris","Cafe","Negro");

                //insertar cada entidad
                insertPreguntas(casasSub9Pregunta1);
                insertPreguntas(casasSub9Pregunta2);
                insertPreguntas(casasSub9Pregunta3);
                insertPreguntas(casasSub9Pregunta4);
                insertPreguntas(casasSub9Pregunta5);
                insertPreguntas(casasSub9Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub10Pregunta1 = new PreguntasEntity(res.getString(R.string.anim_c4_p1),10,"Ocho","Seis","Siete","Ocho");
                PreguntasEntity casasSub10Pregunta2 = new PreguntasEntity(res.getString(R.string.anim_c4_p2),10,"Borroso","Distorsionado","Enfocado","Borroso");
                PreguntasEntity casasSub10Pregunta3 = new PreguntasEntity(res.getString(R.string.anim_c4_p3),10,"Blanco","Gris","Rosado","Blanco");
                PreguntasEntity casasSub10Pregunta4 = new PreguntasEntity(res.getString(R.string.anim_c4_p4),10,"Rama","Piedra","Tronco cortado","Rama");
                PreguntasEntity casasSub10Pregunta5 = new PreguntasEntity(res.getString(R.string.anim_c4_p5),10,"Seis","Cinco","Siete","Siete");
                PreguntasEntity casasSub10Pregunta6 = new PreguntasEntity(res.getString(R.string.anim_c4_p6),10,"Borde superior izquierdo","Borde inferior izquierdo","Borde inferior derecho","Borde inferior izquierdo");

                //insertar cada entidad
                insertPreguntas(casasSub10Pregunta1);
                insertPreguntas(casasSub10Pregunta2);
                insertPreguntas(casasSub10Pregunta3);
                insertPreguntas(casasSub10Pregunta4);
                insertPreguntas(casasSub10Pregunta5);
                insertPreguntas(casasSub10Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub11Pregunta1 = new PreguntasEntity(res.getString(R.string.anim_c5_p1),11,"Ocho","Siete","Seis","Ocho");
                PreguntasEntity casasSub11Pregunta2 = new PreguntasEntity(res.getString(R.string.anim_c5_p2),11,"Amarillo con blanco","Cafe con blanco","Negro con blanco","Cafe con blanco");
                PreguntasEntity casasSub11Pregunta3 = new PreguntasEntity(res.getString(R.string.anim_c5_p3),11,"Amarillo con blanco","Cafe con blanco","Negro con blanco","Negro con blanco");
                PreguntasEntity casasSub11Pregunta4 = new PreguntasEntity(res.getString(R.string.anim_c5_p4),11,"Verde","Blanco","Amarillo","Verde");
                PreguntasEntity casasSub11Pregunta5 = new PreguntasEntity(res.getString(R.string.anim_c5_p5),11,"El conejo de la izquierda","El conejo de la derecha","Ninguno","El conejo de la derecha");
                PreguntasEntity casasSub11Pregunta6 = new PreguntasEntity(res.getString(R.string.anim_c5_p6),11,"Verde","Amarillo y blanco","Amarillo","Amarillo y blanco");

                //insertar cada entidad
                insertPreguntas(casasSub11Pregunta1);
                insertPreguntas(casasSub11Pregunta2);
                insertPreguntas(casasSub11Pregunta3);
                insertPreguntas(casasSub11Pregunta4);
                insertPreguntas(casasSub11Pregunta5);
                insertPreguntas(casasSub11Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub12Pregunta1 = new PreguntasEntity(res.getString(R.string.anim_c6_p1),12,"Felicidad","Molestia","Enojo","Molestia");
                PreguntasEntity casasSub12Pregunta2 = new PreguntasEntity(res.getString(R.string.anim_c6_p2),12,"Amistad","Enojo","Molestia","Amistad");
                PreguntasEntity casasSub12Pregunta3 = new PreguntasEntity(res.getString(R.string.anim_c6_p3),12,"Blanco","Amarillo","Cafe","Blanco");
                PreguntasEntity casasSub12Pregunta4 = new PreguntasEntity(res.getString(R.string.anim_c6_p4),12,"Blanco","Amarillo","Verde","Verde");
                PreguntasEntity casasSub12Pregunta5 = new PreguntasEntity(res.getString(R.string.anim_c6_p5),12,"Cafe","Gris","Negro","Cafe");
                PreguntasEntity casasSub12Pregunta6 = new PreguntasEntity(res.getString(R.string.anim_c6_p6),12,"Se asemeja al bosque","Está desenfocado","Es de color gris","Está desenfocado");

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
                PreguntasEntity casasSub17Pregunta1 = new PreguntasEntity("Calles 5 - 1",17,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub17Pregunta2 = new PreguntasEntity("Calles 5 - 2",17,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub17Pregunta3 = new PreguntasEntity("Calles 5 - 3",17,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub17Pregunta4 = new PreguntasEntity("Calles 5 - 4",17,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub17Pregunta5 = new PreguntasEntity("Calles 5 - 5",17,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub17Pregunta6 = new PreguntasEntity("Calles 5 - 6",17,"respuesta1","respuesta2","respuesta3","rc");

                //insertar cada entidad
                insertPreguntas(casasSub17Pregunta1);
                insertPreguntas(casasSub17Pregunta2);
                insertPreguntas(casasSub17Pregunta3);
                insertPreguntas(casasSub17Pregunta4);
                insertPreguntas(casasSub17Pregunta5);
                insertPreguntas(casasSub17Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub18Pregunta1 = new PreguntasEntity("Calles 6 - 1",18,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub18Pregunta2 = new PreguntasEntity("Calles 6 - 2",18,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub18Pregunta3 = new PreguntasEntity("Calles 6 - 3",18,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub18Pregunta4 = new PreguntasEntity("Calles 6 - 4",18,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub18Pregunta5 = new PreguntasEntity("Calles 6 - 5",18,"respuesta1","respuesta2","respuesta3","rc");
                PreguntasEntity casasSub18Pregunta6 = new PreguntasEntity("Calles 6 - 6",18,"respuesta1","respuesta2","respuesta3","rc");

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
