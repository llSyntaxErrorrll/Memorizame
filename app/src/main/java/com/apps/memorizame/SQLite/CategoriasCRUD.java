package com.apps.memorizame.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.apps.memorizame.Entitys.InicioEntity;
import com.apps.memorizame.Tools.Constans;

public class CategoriasCRUD {

    Database database;
    SQLiteDatabase db;

    public CategoriasCRUD(Context context){
        database = new Database(context);
    }

    public long insert(InicioEntity entity){
        db = database.getWritableDatabase();

        //columna de la tabla con su valor
        ContentValues values = new ContentValues();
        values.put(Constans.dbColumCatego_name, entity.getNombre());
        values.put(Constans.dbColumCatego_imag, entity.getImagen());
        values.put(Constans.dbColumCatego_imag, entity.getEstado());

        //inserta en db
        return db.insert(Constans.dbTbCatego, Constans.dbColumCatego_id, values);
    }

    public Cursor read(InicioEntity entity){
        db = database.getReadableDatabase();

        String []asd = {"",""};

        return db.rawQuery("SELECT * FROM "+Constans.dbTbCatego, asd);
    }
}
