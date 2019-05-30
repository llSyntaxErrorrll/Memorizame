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
                PreguntasEntity casasSub1Pregunta1 = new PreguntasEntity("Casas",1);
                PreguntasEntity casasSub1Pregunta2 = new PreguntasEntity("Casas",1);
                PreguntasEntity casasSub1Pregunta3 = new PreguntasEntity("Casas",1);
                PreguntasEntity casasSub1Pregunta4 = new PreguntasEntity("Casas",1);
                PreguntasEntity casasSub1Pregunta5 = new PreguntasEntity("Casas",1);
                PreguntasEntity casasSub1Pregunta6 = new PreguntasEntity("Casas",1);

                //insertar cada entidad
                insertPreguntas(casasSub1Pregunta1);
                insertPreguntas(casasSub1Pregunta2);
                insertPreguntas(casasSub1Pregunta3);
                insertPreguntas(casasSub1Pregunta4);
                insertPreguntas(casasSub1Pregunta5);
                insertPreguntas(casasSub1Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub2Pregunta1 = new PreguntasEntity("Casas",2);
                PreguntasEntity casasSub2Pregunta2 = new PreguntasEntity("Casas",2);
                PreguntasEntity casasSub2Pregunta3 = new PreguntasEntity("Casas",2);
                PreguntasEntity casasSub2Pregunta4 = new PreguntasEntity("Casas",2);
                PreguntasEntity casasSub2Pregunta5 = new PreguntasEntity("Casas",2);
                PreguntasEntity casasSub2Pregunta6 = new PreguntasEntity("Casas",2);

                //insertar cada entidad
                insertPreguntas(casasSub2Pregunta1);
                insertPreguntas(casasSub2Pregunta2);
                insertPreguntas(casasSub2Pregunta3);
                insertPreguntas(casasSub2Pregunta4);
                insertPreguntas(casasSub2Pregunta5);
                insertPreguntas(casasSub2Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub3Pregunta1 = new PreguntasEntity("Casas",3);
                PreguntasEntity casasSub3Pregunta2 = new PreguntasEntity("Casas",3);
                PreguntasEntity casasSub3Pregunta3 = new PreguntasEntity("Casas",3);
                PreguntasEntity casasSub3Pregunta4 = new PreguntasEntity("Casas",3);
                PreguntasEntity casasSub3Pregunta5 = new PreguntasEntity("Casas",3);
                PreguntasEntity casasSub3Pregunta6 = new PreguntasEntity("Casas",3);

                //insertar cada entidad
                insertPreguntas(casasSub3Pregunta1);
                insertPreguntas(casasSub3Pregunta2);
                insertPreguntas(casasSub3Pregunta3);
                insertPreguntas(casasSub3Pregunta4);
                insertPreguntas(casasSub3Pregunta5);
                insertPreguntas(casasSub3Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub4Pregunta1 = new PreguntasEntity("Casas",4);
                PreguntasEntity casasSub4Pregunta2 = new PreguntasEntity("Casas",4);
                PreguntasEntity casasSub4Pregunta3 = new PreguntasEntity("Casas",4);
                PreguntasEntity casasSub4Pregunta4 = new PreguntasEntity("Casas",4);
                PreguntasEntity casasSub4Pregunta5 = new PreguntasEntity("Casas",4);
                PreguntasEntity casasSub4Pregunta6 = new PreguntasEntity("Casas",4);

                //insertar cada entidad
                insertPreguntas(casasSub4Pregunta1);
                insertPreguntas(casasSub4Pregunta2);
                insertPreguntas(casasSub4Pregunta3);
                insertPreguntas(casasSub4Pregunta4);
                insertPreguntas(casasSub4Pregunta5);
                insertPreguntas(casasSub4Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub5Pregunta1 = new PreguntasEntity("Casas",5);
                PreguntasEntity casasSub5Pregunta2 = new PreguntasEntity("Casas",5);
                PreguntasEntity casasSub5Pregunta3 = new PreguntasEntity("Casas",5);
                PreguntasEntity casasSub5Pregunta4 = new PreguntasEntity("Casas",5);
                PreguntasEntity casasSub5Pregunta5 = new PreguntasEntity("Casas",5);
                PreguntasEntity casasSub5Pregunta6 = new PreguntasEntity("Casas",5);

                //insertar cada entidad
                insertPreguntas(casasSub5Pregunta1);
                insertPreguntas(casasSub5Pregunta2);
                insertPreguntas(casasSub5Pregunta3);
                insertPreguntas(casasSub5Pregunta4);
                insertPreguntas(casasSub5Pregunta5);
                insertPreguntas(casasSub5Pregunta6);

                //entidades quemadas
                PreguntasEntity casasSub6Pregunta1 = new PreguntasEntity("Casas",6);
                PreguntasEntity casasSub6Pregunta2 = new PreguntasEntity("Casas",6);
                PreguntasEntity casasSub6Pregunta3 = new PreguntasEntity("Casas",6);
                PreguntasEntity casasSub6Pregunta4 = new PreguntasEntity("Casas",6);
                PreguntasEntity casasSub6Pregunta5 = new PreguntasEntity("Casas",6);
                PreguntasEntity casasSub6Pregunta6 = new PreguntasEntity("Casas",6);

                //insertar cada entidad
                insertPreguntas(casasSub6Pregunta1);
                insertPreguntas(casasSub6Pregunta2);
                insertPreguntas(casasSub6Pregunta3);
                insertPreguntas(casasSub6Pregunta4);
                insertPreguntas(casasSub6Pregunta5);
                insertPreguntas(casasSub6Pregunta6);
            }

            //finaliza
            db.close();
            return rs;

        }catch (Exception e){
            return true;
        }
    }
}
