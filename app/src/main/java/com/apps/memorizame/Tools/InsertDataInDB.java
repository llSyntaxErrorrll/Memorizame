package com.apps.memorizame.Tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.apps.memorizame.SQLite.Database;

public class InsertDataInDB {

    //declaracion de variables
    private Database database;
    private SQLiteDatabase db;

    public InsertDataInDB(Context context){
        //instanciar db
        database = new Database(context);
    }

    public boolean isFristTime(){
        db = database.getReadableDatabase();

        String colums[] = {"",""};

        return true;
    }

}
