package com.apps.memorizame.SQLite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.apps.memorizame.Tools.Constans;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, Constans.dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creacion de la tabla de categorias
        String sql = "CREATE TABLE "+Constans.dbTbCatego+ "(" +
                Constans.dbColumCatego_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Constans.dbColumCatego_name+" TEXT,"+
                Constans.dbColumCatego_imag+" TEXT,"+
                Constans.dbColumCatego_esta+" INTEGER) ";

        //creacion de la tabla de sub-categorias
        sql += " CREATE TABLE "+Constans.dbTbSubCatego+ "(" +
                Constans.dbColumSubCatego_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Constans.dbColumSubCatego_name+" TEXT,"+
                Constans.dbColumSubCatego_imag+" TEXT,"+
                Constans.dbColumSubCatego_esta+" INTEGER,"+
                Constans.dbColumSubCatego_cate+" INTEGER,"+
                Constans.dbColumSubCatego_cali+" TEXT)";

        //ejecutar creacion de db
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Constans.dbTbCatego);
        db.execSQL("DROP TABLE IF EXISTS "+Constans.dbTbSubCatego);
        onCreate(db);
    }
}
