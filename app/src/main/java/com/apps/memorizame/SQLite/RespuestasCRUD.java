package com.apps.memorizame.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.apps.memorizame.Entitys.RespuestasEntity;
import com.apps.memorizame.Tools.Constans;

public class RespuestasCRUD {

    private Database database;
    private SQLiteDatabase db;

    public RespuestasCRUD(Context context){ database= new Database(context); }

    public long insertRespuestas (RespuestasEntity respuestasEntity){
        db = database.getWritableDatabase();
        //columna de la tabla con su valor
        ContentValues values = new ContentValues();
        values.put(Constans.dbColumRespues_nombre, respuestasEntity.getRespuesta());
        values.put(Constans.dbColumRespues_pre, respuestasEntity.getIdPregunta());
        values.put(Constans.dbColumRespues_respuestaCorret, respuestasEntity.getRespuestaCorreta());

        long rs = db.insert(Constans.dbTbRespue, Constans.dbColumRespues_id, values);
        db.close();
        return rs;
    }

    //Consultar por Id
    public Cursor readRespuestas(RespuestasEntity respuestasEntity){
        db = database.getReadableDatabase();
        String[] argumentos = {String.valueOf(respuestasEntity.getIdRespuesta())};
        Cursor rs = db.rawQuery("SELECT * FROM "+Constans.dbTbRespue +" WHERE "+ Constans.dbColumRespues_id +
                " = ? ", argumentos);
        return rs;
    }

    public boolean isFristTime(){
        try{
            //consulta en db
            db = database.getReadableDatabase();
            Cursor rows = db.rawQuery("SELECT count('"+ Constans.dbColumRespues_id+"') FROM "+Constans.dbTbRespue,null);

            //conteno de los registros
            rows.moveToFirst();
            boolean rs = (rows.getInt(0) <= 0);

            if(rs){
                db = database.getWritableDatabase();

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta1 = new RespuestasEntity("Casas",1,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta1 = new  RespuestasEntity("Casas",1,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta1 = new  RespuestasEntity("Casas",1,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta1);
                insertRespuestas(Respuesta2Pregunta1);
                insertRespuestas(Respuesta3Pregunta1);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta2 = new RespuestasEntity("Casas",2,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta2 = new  RespuestasEntity("Casas",2,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta2 = new  RespuestasEntity("Casas",2,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta2);
                insertRespuestas(Respuesta2Pregunta2);
                insertRespuestas(Respuesta3Pregunta2);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta3 = new RespuestasEntity("Casas",3,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta3 = new  RespuestasEntity("Casas",3,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta3 = new  RespuestasEntity("Casas",3,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta3);
                insertRespuestas(Respuesta2Pregunta3);
                insertRespuestas(Respuesta3Pregunta3);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta4 = new RespuestasEntity("Casas",4,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta4 = new  RespuestasEntity("Casas",4,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta4 = new  RespuestasEntity("Casas",4,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta4);
                insertRespuestas(Respuesta2Pregunta4);
                insertRespuestas(Respuesta3Pregunta4);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta5 = new RespuestasEntity("Casas",5,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta5 = new  RespuestasEntity("Casas",5,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta5 = new  RespuestasEntity("Casas",5,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta5);
                insertRespuestas(Respuesta2Pregunta5);
                insertRespuestas(Respuesta3Pregunta5);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta6 = new RespuestasEntity("Casas",6,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta6 = new  RespuestasEntity("Casas",6,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta6 = new  RespuestasEntity("Casas",6,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta6);
                insertRespuestas(Respuesta2Pregunta6);
                insertRespuestas(Respuesta3Pregunta6);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta7 = new RespuestasEntity("Casas",7,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta7 = new  RespuestasEntity("Casas",7,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta7 = new  RespuestasEntity("Casas",7,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta7);
                insertRespuestas(Respuesta2Pregunta7);
                insertRespuestas(Respuesta3Pregunta7);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta8 = new RespuestasEntity("Casas",8,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta8 = new  RespuestasEntity("Casas",8,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta8 = new  RespuestasEntity("Casas",8,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta8);
                insertRespuestas(Respuesta2Pregunta8);
                insertRespuestas(Respuesta3Pregunta8);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta9 = new RespuestasEntity("Casas",9,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta9 = new  RespuestasEntity("Casas",9,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta9 = new  RespuestasEntity("Casas",9,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta9);
                insertRespuestas(Respuesta2Pregunta9);
                insertRespuestas(Respuesta3Pregunta9);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta10 = new RespuestasEntity("Casas",10,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta10 = new  RespuestasEntity("Casas",10,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta10 = new  RespuestasEntity("Casas",10,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta10);
                insertRespuestas(Respuesta2Pregunta10);
                insertRespuestas(Respuesta3Pregunta10);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta11 = new RespuestasEntity("Casas",11,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta11 = new  RespuestasEntity("Casas",11,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta11 = new  RespuestasEntity("Casas",11,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta11);
                insertRespuestas(Respuesta2Pregunta11);
                insertRespuestas(Respuesta3Pregunta11);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta12 = new RespuestasEntity("Casas",12,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta12 = new  RespuestasEntity("Casas",12,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta12= new  RespuestasEntity("Casas",12,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta12);
                insertRespuestas(Respuesta2Pregunta12);
                insertRespuestas(Respuesta3Pregunta12);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta13 = new RespuestasEntity("Casas",13,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta13 = new  RespuestasEntity("Casas",13,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta13 = new  RespuestasEntity("Casas",13,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta13);
                insertRespuestas(Respuesta2Pregunta13);
                insertRespuestas(Respuesta3Pregunta13);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta14 = new RespuestasEntity("Casas",14,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta14 = new  RespuestasEntity("Casas",14,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta14 = new  RespuestasEntity("Casas",14,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta14);
                insertRespuestas(Respuesta2Pregunta14);
                insertRespuestas(Respuesta3Pregunta14);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta15 = new RespuestasEntity("Casas",15,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta15 = new  RespuestasEntity("Casas",15,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta15 = new  RespuestasEntity("Casas",15,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta15);
                insertRespuestas(Respuesta2Pregunta15);
                insertRespuestas(Respuesta3Pregunta15);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta16 = new RespuestasEntity("Casas",16,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta16 = new  RespuestasEntity("Casas",16,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta16 = new  RespuestasEntity("Casas",16,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta16);
                insertRespuestas(Respuesta2Pregunta16);
                insertRespuestas(Respuesta3Pregunta16);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta17 = new RespuestasEntity("Casas",17,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta17 = new  RespuestasEntity("Casas",17,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta17 = new  RespuestasEntity("Casas",17,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta17);
                insertRespuestas(Respuesta2Pregunta17);
                insertRespuestas(Respuesta3Pregunta17);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta18 = new RespuestasEntity("Casas",18,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta18 = new  RespuestasEntity("Casas",18,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta18 = new  RespuestasEntity("Casas",18,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta18);
                insertRespuestas(Respuesta2Pregunta18);
                insertRespuestas(Respuesta3Pregunta18);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta19 = new RespuestasEntity("Casas",19,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta19 = new  RespuestasEntity("Casas",19,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta19 = new  RespuestasEntity("Casas",19,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta19);
                insertRespuestas(Respuesta2Pregunta19);
                insertRespuestas(Respuesta3Pregunta19);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta20 = new RespuestasEntity("Casas",20,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta20 = new  RespuestasEntity("Casas",20,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta20 = new  RespuestasEntity("Casas",20,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta20);
                insertRespuestas(Respuesta2Pregunta20);
                insertRespuestas(Respuesta3Pregunta20);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta21 = new RespuestasEntity("Casas",21,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta21 = new  RespuestasEntity("Casas",21,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta21 = new  RespuestasEntity("Casas",21,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta21);
                insertRespuestas(Respuesta2Pregunta21);
                insertRespuestas(Respuesta3Pregunta21);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta22 = new RespuestasEntity("Casas",22,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta22 = new  RespuestasEntity("Casas",22,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta22= new  RespuestasEntity("Casas",22,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta22);
                insertRespuestas(Respuesta2Pregunta22);
                insertRespuestas(Respuesta3Pregunta22);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta23 = new RespuestasEntity("Casas",23,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta23 = new  RespuestasEntity("Casas",23,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta23 = new  RespuestasEntity("Casas",23,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta23);
                insertRespuestas(Respuesta2Pregunta23);
                insertRespuestas(Respuesta3Pregunta23);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta24 = new RespuestasEntity("Casas",24,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta24 = new  RespuestasEntity("Casas",24,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta24 = new  RespuestasEntity("Casas",24,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta24);
                insertRespuestas(Respuesta2Pregunta24);
                insertRespuestas(Respuesta3Pregunta24);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta25 = new RespuestasEntity("Casas",25,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta25 = new  RespuestasEntity("Casas",25,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta25 = new  RespuestasEntity("Casas",25,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta25);
                insertRespuestas(Respuesta2Pregunta25);
                insertRespuestas(Respuesta3Pregunta25);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta26 = new RespuestasEntity("Casas",26,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta26 = new  RespuestasEntity("Casas",26,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta26 = new  RespuestasEntity("Casas",26,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta26);
                insertRespuestas(Respuesta2Pregunta26);
                insertRespuestas(Respuesta3Pregunta26);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta27 = new RespuestasEntity("Casas",27,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta27 = new  RespuestasEntity("Casas",27,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta27 = new  RespuestasEntity("Casas",27,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta27);
                insertRespuestas(Respuesta2Pregunta27);
                insertRespuestas(Respuesta3Pregunta27);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta28 = new RespuestasEntity("Casas",28,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta28 = new  RespuestasEntity("Casas",28,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta28 = new  RespuestasEntity("Casas",28,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta28);
                insertRespuestas(Respuesta2Pregunta28);
                insertRespuestas(Respuesta3Pregunta28);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta29 = new RespuestasEntity("Casas",29,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta29 = new  RespuestasEntity("Casas",29,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta29 = new  RespuestasEntity("Casas",29,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta29);
                insertRespuestas(Respuesta2Pregunta29);
                insertRespuestas(Respuesta3Pregunta29);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta30 = new RespuestasEntity("Casas",30,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta30 = new  RespuestasEntity("Casas",30,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta30 = new  RespuestasEntity("Casas",30,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta30);
                insertRespuestas(Respuesta2Pregunta30);
                insertRespuestas(Respuesta3Pregunta30);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta31 = new RespuestasEntity("Casas",31,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta31 = new  RespuestasEntity("Casas",31,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta31 = new  RespuestasEntity("Casas",31,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta31);
                insertRespuestas(Respuesta2Pregunta31);
                insertRespuestas(Respuesta3Pregunta31);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta32 = new RespuestasEntity("Casas",32,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta32 = new  RespuestasEntity("Casas",32,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta32 = new  RespuestasEntity("Casas",32,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta32);
                insertRespuestas(Respuesta2Pregunta32);
                insertRespuestas(Respuesta3Pregunta32);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta33 = new RespuestasEntity("Casas",33,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta33 = new  RespuestasEntity("Casas",33,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta33 = new  RespuestasEntity("Casas",33,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta33);
                insertRespuestas(Respuesta2Pregunta33);
                insertRespuestas(Respuesta3Pregunta33);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta34 = new RespuestasEntity("Casas",34,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta34 = new  RespuestasEntity("Casas",34,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta34 = new  RespuestasEntity("Casas",34,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta34);
                insertRespuestas(Respuesta2Pregunta34);
                insertRespuestas(Respuesta3Pregunta34);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta35 = new RespuestasEntity("Casas",35,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta35 = new  RespuestasEntity("Casas",35,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta35 = new  RespuestasEntity("Casas",35,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta35);
                insertRespuestas(Respuesta2Pregunta35);
                insertRespuestas(Respuesta3Pregunta35);

                //entidades quemadas
                RespuestasEntity Respuesta1Pregunta36 = new RespuestasEntity("Casas",36,"Rcorrecta");
                RespuestasEntity Respuesta2Pregunta36 = new  RespuestasEntity("Casas",36,"Rcorrecta");
                RespuestasEntity Respuesta3Pregunta36 = new  RespuestasEntity("Casas",36,"Rcorrecta");

                //insertar cada entidad
                insertRespuestas(Respuesta1Pregunta36);
                insertRespuestas(Respuesta2Pregunta36);
                insertRespuestas(Respuesta3Pregunta36);

            }

            //finaliza
            db.close();
            return rs;

        }catch (Exception e){
            return true;
        }
    }
}
