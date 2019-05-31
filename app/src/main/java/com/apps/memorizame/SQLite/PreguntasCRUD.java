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
                PreguntasEntity casasSub1Pregunta1 = new PreguntasEntity(res.getString(R.string.casa1pregunta1),1,res.getString(R.string.cuatro),res.getString(R.string.tres),res.getString(R.string.dos),res.getString(R.string.dos));
                PreguntasEntity casasSub1Pregunta2 = new PreguntasEntity(res.getString(R.string.casa1pregunta2),1,res.getString(R.string.seis),res.getString(R.string.siete),res.getString(R.string.ocho),res.getString(R.string.seis));
                PreguntasEntity casasSub1Pregunta3 = new PreguntasEntity(res.getString(R.string.casa1pregunta3),1,res.getString(R.string.metal),res.getString(R.string.madera),res.getString(R.string.plastico),res.getString(R.string.madera));
                PreguntasEntity casasSub1Pregunta4 = new PreguntasEntity(res.getString(R.string.casa1pregunta4),1,res.getString(R.string.tres),res.getString(R.string.uno),res.getString(R.string.dos),res.getString(R.string.dos));
                PreguntasEntity casasSub1Pregunta5 = new PreguntasEntity(res.getString(R.string.casa1pregunta5),1,res.getString(R.string.manana),res.getString(R.string.tarde),res.getString(R.string.noche),res.getString(R.string.tarde));
                PreguntasEntity casasSub1Pregunta6 = new PreguntasEntity(res.getString(R.string.casa1pregunta6),1,res.getString(R.string.lsala),res.getString(R.string.lcocina),res.getString(R.string.lalcoba),res.getString(R.string.lsala));

                //insertar cada entidad
                insertPreguntas(casasSub1Pregunta1);
                insertPreguntas(casasSub1Pregunta2);
                insertPreguntas(casasSub1Pregunta3);
                insertPreguntas(casasSub1Pregunta4);
                insertPreguntas(casasSub1Pregunta5);
                insertPreguntas(casasSub1Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub2Pregunta1 = new PreguntasEntity(res.getString(R.string.casa2pregunta1),2,res.getString(R.string.metal),res.getString(R.string.madera),res.getString(R.string.plastico),res.getString(R.string.madera));
                PreguntasEntity casasSub2Pregunta2 = new PreguntasEntity(res.getString(R.string.casa2pregunta2),2,res.getString(R.string.antena),res.getString(R.string.chimenea),res.getString(R.string.pajaros),res.getString(R.string.chimenea));
                PreguntasEntity casasSub2Pregunta3 = new PreguntasEntity(res.getString(R.string.casa2pregunta3),2,res.getString(R.string.ubicicleta),res.getString(R.string.upersoperro),res.getString(R.string.umesabanca),res.getString(R.string.umesabanca));
                PreguntasEntity casasSub2Pregunta4 = new PreguntasEntity(res.getString(R.string.casa2pregunta4),2,res.getString(R.string.dos),res.getString(R.string.uno),res.getString(R.string.ninguno),res.getString(R.string.dos));
                PreguntasEntity casasSub2Pregunta5 = new PreguntasEntity(res.getString(R.string.casa2pregunta5),2,res.getString(R.string.pintada),res.getString(R.string.eladrillo),res.getString(R.string.econcreto),res.getString(R.string.eladrillo));
                PreguntasEntity casasSub2Pregunta6 = new PreguntasEntity(res.getString(R.string.casa2pregunta6),2,res.getString(R.string.dos),res.getString(R.string.tres),res.getString(R.string.cuatro),res.getString(R.string.dos));

                //insertar cada entidad
                insertPreguntas(casasSub2Pregunta1);
                insertPreguntas(casasSub2Pregunta2);
                insertPreguntas(casasSub2Pregunta3);
                insertPreguntas(casasSub2Pregunta4);
                insertPreguntas(casasSub2Pregunta5);
                insertPreguntas(casasSub2Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub3Pregunta1 = new PreguntasEntity(res.getString(R.string.casa3pregunta1),3,res.getString(R.string.cubica),res.getString(R.string.esferica),res.getString(R.string.ninguno),res.getString(R.string.esferica));
                PreguntasEntity casasSub3Pregunta2 = new PreguntasEntity(res.getString(R.string.casa3pregunta2),3,res.getString(R.string.uno),res.getString(R.string.dos),res.getString(R.string.tres),res.getString(R.string.tres));
                PreguntasEntity casasSub3Pregunta3 = new PreguntasEntity(res.getString(R.string.casa3pregunta3),3,res.getString(R.string.plastico),res.getString(R.string.madera),res.getString(R.string.metal),res.getString(R.string.madera));
                PreguntasEntity casasSub3Pregunta4 = new PreguntasEntity(res.getString(R.string.casa3pregunta4),3,res.getString(R.string.cinco),res.getString(R.string.seis),res.getString(R.string.siete),res.getString(R.string.cinco));
                PreguntasEntity casasSub3Pregunta5 = new PreguntasEntity(res.getString(R.string.casa3pregunta5),3,res.getString(R.string.ucuadro),res.getString(R.string.ureloj),res.getString(R.string.ulampara),res.getString(R.string.ureloj));
                PreguntasEntity casasSub3Pregunta6 = new PreguntasEntity(res.getString(R.string.casa3pregunta6),3,res.getString(R.string.siete),res.getString(R.string.nueve),res.getString(R.string.ocho),res.getString(R.string.nueve));

                //insertar cada entidad
                insertPreguntas(casasSub3Pregunta1);
                insertPreguntas(casasSub3Pregunta2);
                insertPreguntas(casasSub3Pregunta3);
                insertPreguntas(casasSub3Pregunta4);
                insertPreguntas(casasSub3Pregunta5);
                insertPreguntas(casasSub3Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub4Pregunta1 = new PreguntasEntity(res.getString(R.string.casa4pregunta1),4,res.getString(R.string.blanco),res.getString(R.string.amarillo),res.getString(R.string.negro),res.getString(R.string.amarillo));
                PreguntasEntity casasSub4Pregunta2 = new PreguntasEntity(res.getString(R.string.casa4pregunta2),4,res.getString(R.string.auto),res.getString(R.string.bicicleta),res.getString(R.string.avion),res.getString(R.string.bicicleta));
                PreguntasEntity casasSub4Pregunta3 = new PreguntasEntity(res.getString(R.string.casa4pregunta3),4,res.getString(R.string.blancoynegro),res.getString(R.string.azulynegro),res.getString(R.string.blancoyazul),res.getString(R.string.blancoyazul));
                PreguntasEntity casasSub4Pregunta4 = new PreguntasEntity(res.getString(R.string.casa4pregunta4),4,res.getString(R.string.perro),res.getString(R.string.gato),res.getString(R.string.raton),res.getString(R.string.perro));
                PreguntasEntity casasSub4Pregunta5 = new PreguntasEntity(res.getString(R.string.casa4pregunta6),4,res.getString(R.string.ventilador),res.getString(R.string.lampara),res.getString(R.string.adorno),res.getString(R.string.lampara));
                PreguntasEntity casasSub4Pregunta6 = new PreguntasEntity(res.getString(R.string.casa4pregunta6),4,res.getString(R.string.plastico),res.getString(R.string.metal),res.getString(R.string.madera),res.getString(R.string.madera));

                //insertar cada entidad
                insertPreguntas(casasSub4Pregunta1);
                insertPreguntas(casasSub4Pregunta2);
                insertPreguntas(casasSub4Pregunta3);
                insertPreguntas(casasSub4Pregunta4);
                insertPreguntas(casasSub4Pregunta5);
                insertPreguntas(casasSub4Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub5Pregunta1 = new PreguntasEntity(res.getString(R.string.casa5pregunta1),5,res.getString(R.string.cuatro),res.getString(R.string.tres),res.getString(R.string.dos),res.getString(R.string.dos));
                PreguntasEntity casasSub5Pregunta2 = new PreguntasEntity(res.getString(R.string.casa5pregunta2),5,res.getString(R.string.verde1),res.getString(R.string.azul),res.getString(R.string.blanco),res.getString(R.string.verde1));
                PreguntasEntity casasSub5Pregunta3 = new PreguntasEntity(res.getString(R.string.casa5pregunta3),5,res.getString(R.string.metal),res.getString(R.string.madera),res.getString(R.string.plastico),res.getString(R.string.madera));
                PreguntasEntity casasSub5Pregunta4 = new PreguntasEntity(res.getString(R.string.casa5pregunta4),5,res.getString(R.string.lapizyc),res.getString(R.string.compuyc),res.getString(R.string.adornoyflo),res.getString(R.string.adornoyflo));
                PreguntasEntity casasSub5Pregunta5 = new PreguntasEntity(res.getString(R.string.casa5pregunta5),5,res.getString(R.string.rombo),res.getString(R.string.cuadrado),res.getString(R.string.rectangulo),res.getString(R.string.rombo));
                PreguntasEntity casasSub5Pregunta6 = new PreguntasEntity(res.getString(R.string.casa5pregunta6),5,res.getString(R.string.negro),res.getString(R.string.blanco),res.getString(R.string.beige),res.getString(R.string.blanco));

                //insertar cada entidad
                insertPreguntas(casasSub5Pregunta1);
                insertPreguntas(casasSub5Pregunta2);
                insertPreguntas(casasSub5Pregunta3);
                insertPreguntas(casasSub5Pregunta4);
                insertPreguntas(casasSub5Pregunta5);
                insertPreguntas(casasSub5Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub6Pregunta1 = new PreguntasEntity(res.getString(R.string.casa6pregunta1),6,res.getString(R.string.lampara),res.getString(R.string.ventilador),res.getString(R.string.proyetor),res.getString(R.string.proyetor));
                PreguntasEntity casasSub6Pregunta2 = new PreguntasEntity(res.getString(R.string.casa6pregunta2),6,res.getString(R.string.lampara),res.getString(R.string.ventilador),res.getString(R.string.proyetor),res.getString(R.string.lampara));
                PreguntasEntity casasSub6Pregunta3 = new PreguntasEntity(res.getString(R.string.casa6pregunta3),6,res.getString(R.string.negro),res.getString(R.string.gris),res.getString(R.string.blanco),res.getString(R.string.gris));
                PreguntasEntity casasSub6Pregunta4 = new PreguntasEntity(res.getString(R.string.casa6pregunta4),6,res.getString(R.string.tres),res.getString(R.string.cuatro),res.getString(R.string.cinco),res.getString(R.string.tres));
                PreguntasEntity casasSub6Pregunta5 = new PreguntasEntity(res.getString(R.string.casa6pregunta5),6,res.getString(R.string.umatera),res.getString(R.string.usilla),res.getString(R.string.ulampara),res.getString(R.string.ulampara));
                PreguntasEntity casasSub6Pregunta6 = new PreguntasEntity(res.getString(R.string.casa6pregunta6),6,res.getString(R.string.azul),res.getString(R.string.gris),res.getString(R.string.verde1),res.getString(R.string.verde1));

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
                PreguntasEntity casasSub13Pregunta1 = new PreguntasEntity(res.getString(R.string.calle1pregunta1),13,res.getString(R.string.dos),res.getString(R.string.uno),res.getString(R.string.ninguno),res.getString(R.string.uno));
                PreguntasEntity casasSub13Pregunta2 = new PreguntasEntity(res.getString(R.string.calle1pregunta2),13,res.getString(R.string.sesenta),res.getString(R.string.setenta),res.getString(R.string.cincuenta),res.getString(R.string.cincuenta));
                PreguntasEntity casasSub13Pregunta3 = new PreguntasEntity(res.getString(R.string.calle1pregunta3),13,res.getString(R.string.uno),res.getString(R.string.dos),res.getString(R.string.tres),res.getString(R.string.dos));
                PreguntasEntity casasSub13Pregunta4 = new PreguntasEntity(res.getString(R.string.calle1pregunta4),13,res.getString(R.string.tres),res.getString(R.string.uno),res.getString(R.string.dos),res.getString(R.string.tres));
                PreguntasEntity casasSub13Pregunta5 = new PreguntasEntity(res.getString(R.string.calle1pregunta5),13,res.getString(R.string.uno),res.getString(R.string.dos),res.getString(R.string.tres),res.getString(R.string.tres));
                PreguntasEntity casasSub13Pregunta6 = new PreguntasEntity(res.getString(R.string.calle1pregunta6),13,res.getString(R.string.menos),res.getString(R.string.mas),res.getString(R.string.peaton),res.getString(R.string.menos));

                //insertar cada entidad
                insertPreguntas(casasSub13Pregunta1);
                insertPreguntas(casasSub13Pregunta2);
                insertPreguntas(casasSub13Pregunta3);
                insertPreguntas(casasSub13Pregunta4);
                insertPreguntas(casasSub13Pregunta5);
                insertPreguntas(casasSub13Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub14Pregunta1 = new PreguntasEntity(res.getString(R.string.calle2pregunta1),14,res.getString(R.string.siete),res.getString(R.string.tres),res.getString(R.string.diez),res.getString(R.string.siete));
                PreguntasEntity casasSub14Pregunta2 = new PreguntasEntity(res.getString(R.string.calle2pregunta2),14,res.getString(R.string.tres),res.getString(R.string.uno),res.getString(R.string.cinco),res.getString(R.string.uno));
                PreguntasEntity casasSub14Pregunta3 = new PreguntasEntity(res.getString(R.string.calle2pregunta3),14,res.getString(R.string.verblanrojo),res.getString(R.string.naazulroj),res.getString(R.string.azulnaraver),res.getString(R.string.azulnaraver));
                PreguntasEntity casasSub14Pregunta4 = new PreguntasEntity(res.getString(R.string.calle2pregunta4),14,res.getString(R.string.rojo),res.getString(R.string.azul),res.getString(R.string.morado),res.getString(R.string.azul));
                PreguntasEntity casasSub14Pregunta5 = new PreguntasEntity(res.getString(R.string.calle2pregunta5),14,res.getString(R.string.ida),res.getString(R.string.regreso),res.getString(R.string.ambos),res.getString(R.string.ida));
                PreguntasEntity casasSub14Pregunta6 = new PreguntasEntity(res.getString(R.string.calle2pregunta6),14,res.getString(R.string.nublado),res.getString(R.string.despejado),res.getString(R.string.estrellado),res.getString(R.string.despejado));

                //insertar cada entidad
                insertPreguntas(casasSub14Pregunta1);
                insertPreguntas(casasSub14Pregunta2);
                insertPreguntas(casasSub14Pregunta3);
                insertPreguntas(casasSub14Pregunta4);
                insertPreguntas(casasSub14Pregunta5);
                insertPreguntas(casasSub14Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub15Pregunta1 = new PreguntasEntity(res.getString(R.string.calle3pregunta1),15,res.getString(R.string.tres),res.getString(R.string.dos),res.getString(R.string.uno),res.getString(R.string.tres));
                PreguntasEntity casasSub15Pregunta2 = new PreguntasEntity(res.getString(R.string.calle3pregunta2),15,res.getString(R.string.dos),res.getString(R.string.cuatro),res.getString(R.string.uno),res.getString(R.string.dos));
                PreguntasEntity casasSub15Pregunta3 = new PreguntasEntity(res.getString(R.string.calle3pregunta3),15,res.getString(R.string.morado),res.getString(R.string.blanco),res.getString(R.string.azul),res.getString(R.string.blanco));
                PreguntasEntity casasSub15Pregunta4 = new PreguntasEntity(res.getString(R.string.calle3pregunta4),15,res.getString(R.string.negro),res.getString(R.string.azul),res.getString(R.string.morado),res.getString(R.string.morado));
                PreguntasEntity casasSub15Pregunta5 = new PreguntasEntity(res.getString(R.string.calle3pregunta5),15,res.getString(R.string.doblecalzada),res.getString(R.string.triplecalzada),res.getString(R.string.ninguno),res.getString(R.string.triplecalzada));
                PreguntasEntity casasSub15Pregunta6 = new PreguntasEntity(res.getString(R.string.calle3pregunta6),15,res.getString(R.string.ninguno),res.getString(R.string.doblecalzada),res.getString(R.string.unacalzada),res.getString(R.string.unacalzada));

                //insertar cada entidad
                insertPreguntas(casasSub15Pregunta1);
                insertPreguntas(casasSub15Pregunta2);
                insertPreguntas(casasSub15Pregunta3);
                insertPreguntas(casasSub15Pregunta4);
                insertPreguntas(casasSub15Pregunta5);
                insertPreguntas(casasSub15Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub16Pregunta1 = new PreguntasEntity(res.getString(R.string.calle4pregunta1),16,res.getString(R.string.cuatro),res.getString(R.string.dos),res.getString(R.string.uno),res.getString(R.string.uno));
                PreguntasEntity casasSub16Pregunta2 = new PreguntasEntity(res.getString(R.string.calle4pregunta2),16,res.getString(R.string.arbol),res.getString(R.string.andes),res.getString(R.string.andro),res.getString(R.string.andes));
                PreguntasEntity casasSub16Pregunta3 = new PreguntasEntity(res.getString(R.string.calle4pregunta3),16,res.getString(R.string.uno),res.getString(R.string.dos),res.getString(R.string.ninguno),res.getString(R.string.uno));
                PreguntasEntity casasSub16Pregunta4 = new PreguntasEntity(res.getString(R.string.calle4pregunta4),16,res.getString(R.string.doblecalzada),res.getString(R.string.triplecalzada),res.getString(R.string.ninguno),res.getString(R.string.triplecalzada));
                PreguntasEntity casasSub16Pregunta5 = new PreguntasEntity(res.getString(R.string.calle4pregunta5),16,res.getString(R.string.dos),res.getString(R.string.tres),res.getString(R.string.cuatro),res.getString(R.string.dos));
                PreguntasEntity casasSub16Pregunta6 = new PreguntasEntity(res.getString(R.string.calle4pregunta6),16,res.getString(R.string.azul),res.getString(R.string.verde1),res.getString(R.string.morado),res.getString(R.string.morado));

                //insertar cada entidad
                insertPreguntas(casasSub16Pregunta1);
                insertPreguntas(casasSub16Pregunta2);
                insertPreguntas(casasSub16Pregunta3);
                insertPreguntas(casasSub16Pregunta4);
                insertPreguntas(casasSub16Pregunta5);
                insertPreguntas(casasSub16Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub17Pregunta1 = new PreguntasEntity(res.getString(R.string.calle5pregunta1),17,res.getString(R.string.uno),res.getString(R.string.dos),res.getString(R.string.tres),res.getString(R.string.dos));
                PreguntasEntity casasSub17Pregunta2 = new PreguntasEntity(res.getString(R.string.calle5pregunta2),17,res.getString(R.string.azul),res.getString(R.string.blanco),res.getString(R.string.verde1),res.getString(R.string.verde1));
                PreguntasEntity casasSub17Pregunta3 = new PreguntasEntity(res.getString(R.string.calle5pregunta3),17,res.getString(R.string.uno),res.getString(R.string.tres),res.getString(R.string.ninguno),res.getString(R.string.uno));
                PreguntasEntity casasSub17Pregunta4 = new PreguntasEntity(res.getString(R.string.calle5pregunta4),17,res.getString(R.string.losdade),res.getString(R.string.unootroizquier),res.getString(R.string.losdaiz),res.getString(R.string.unootroizquier));
                PreguntasEntity casasSub17Pregunta5 = new PreguntasEntity(res.getString(R.string.calle5pregunta5),17,res.getString(R.string.canfut),res.getString(R.string.parqueadero),res.getString(R.string.parque),res.getString(R.string.parque));
                PreguntasEntity casasSub17Pregunta6 = new PreguntasEntity(res.getString(R.string.calle5pregunta6),17,res.getString(R.string.unootroizquier),res.getString(R.string.losdaiz),res.getString(R.string.losdade),res.getString(R.string.unootroizquier));

                //insertar cada entidad
                insertPreguntas(casasSub17Pregunta1);
                insertPreguntas(casasSub17Pregunta2);
                insertPreguntas(casasSub17Pregunta3);
                insertPreguntas(casasSub17Pregunta4);
                insertPreguntas(casasSub17Pregunta5);
                insertPreguntas(casasSub17Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub18Pregunta1 = new PreguntasEntity(res.getString(R.string.calle6pregunta1),18,res.getString(R.string.dos),res.getString(R.string.siete),res.getString(R.string.uno),res.getString(R.string.uno));
                PreguntasEntity casasSub18Pregunta2 = new PreguntasEntity(res.getString(R.string.calle6pregunta2),18,res.getString(R.string.azul),res.getString(R.string.verde1),res.getString(R.string.rojo),res.getString(R.string.verde1));
                PreguntasEntity casasSub18Pregunta3 = new PreguntasEntity(res.getString(R.string.calle6pregunta3),18,res.getString(R.string.tres),res.getString(R.string.cinco),res.getString(R.string.dos),res.getString(R.string.tres));
                PreguntasEntity casasSub18Pregunta4 = new PreguntasEntity(res.getString(R.string.calle6pregunta4),18,res.getString(R.string.tres),res.getString(R.string.uno),res.getString(R.string.dos),res.getString(R.string.dos));
                PreguntasEntity casasSub18Pregunta5 = new PreguntasEntity(res.getString(R.string.calle6pregunta5),18,res.getString(R.string.naranja),res.getString(R.string.azul),res.getString(R.string.negro),res.getString(R.string.azul));
                PreguntasEntity casasSub18Pregunta6 = new PreguntasEntity(res.getString(R.string.calle6pregunta6),18,res.getString(R.string.uno),res.getString(R.string.dos),res.getString(R.string.ninguno),res.getString(R.string.uno));

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
