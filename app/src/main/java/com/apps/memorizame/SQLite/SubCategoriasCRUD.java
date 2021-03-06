package com.apps.memorizame.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.apps.memorizame.Entitys.SubCategoriasEntity;
import com.apps.memorizame.Tools.Constans;

public class SubCategoriasCRUD {

    //declaracion de variables
    private Database database;
    private SQLiteDatabase db;

    public SubCategoriasCRUD(Context context){
        database = new Database(context);
    }

    public void insert(SubCategoriasEntity entity){
        db = database.getWritableDatabase();

        //columna de la tabla con su valor
        ContentValues values = new ContentValues();
        values.put(Constans.dbColumSubCatego_name, entity.getNombreSub());
        values.put(Constans.dbColumSubCatego_imag, entity.getImagenSub());
        values.put(Constans.dbColumSubCatego_cate, entity.getIdCategoria());
        values.put(Constans.dbColumSubCatego_esta, entity.getIdEstado());
        values.put(Constans.dbColumSubCatego_cali, entity.getCalificacion());

        //inserta en db
        long rs = db.insert(Constans.dbTbSubCatego, Constans.dbColumSubCatego_id, values);
        db.close();
    }

    public Cursor read(SubCategoriasEntity entity){
        db = database.getReadableDatabase();
        String args[] = { String.valueOf(entity.getIdCategoria()) };
        return db.rawQuery("SELECT * FROM "+Constans.dbTbSubCatego+" WHERE "+Constans.dbColumSubCatego_cate+" = ? ",args);
    }

    public Cursor readById(SubCategoriasEntity entity){
        db = database.getReadableDatabase();
        String args[] = { String.valueOf(entity.getIdSubCategoria()) };
        return db.rawQuery("SELECT * FROM "+Constans.dbTbSubCatego+" WHERE "+Constans.dbColumSubCatego_id+" = ? ",args);
    }

    public void update(SubCategoriasEntity entity){
        db = database.getWritableDatabase();

        //valores a actualizar
        ContentValues values = new ContentValues();
        values.put(Constans.dbColumSubCatego_cali, entity.getCalificacion());

        //argumento where y actualizar
        String args[] = { String.valueOf(entity.getIdSubCategoria()) };
        db.update(Constans.dbTbSubCatego,values,Constans.dbColumSubCatego_id+" = ? ",args);

        //si actualiza y califica
        if(entity.getCalificacion() >= 6){
            try {
                //si responde bien actualiza el sigueinte registro desbloqueandolo
                values = new ContentValues();
                values.put(Constans.dbColumSubCatego_esta, 1);

                //argumento where y actualizar el sigueinte ID
                String argsx[] = { String.valueOf((entity.getIdSubCategoria() + 1)),
                                    String.valueOf(entity.getIdCategoria())};
                long rs = db.update(Constans.dbTbSubCatego, values, Constans.dbColumSubCatego_id+" = ? AND "+
                        Constans.dbColumSubCatego_cate+" = ?",argsx);


                //si no encuentra la subCategoria es la ultima
                //actualiza estado de la sigueinte categoria
                if(rs <= 0){
                    //valor a actualizar
                    values = new ContentValues();
                    values.put(Constans.dbColumCatego_esta, 1);

                    //where
                    String argsxx[] = { String.valueOf((entity.getIdCategoria() + 1))};

                    //actualiza la categoria siguiente
                    db.update(Constans.dbTbCatego,values,Constans.dbColumCatego_id+" = ? ",argsxx);
                }

            }catch (Exception e){
                Log.e("error", "Error: ",e);
                //por si sobrepasa el ID de actualizacion
            }
        }
    }
    
    public boolean isFristTime(){
        try{
            //consulta en db
            db = database.getReadableDatabase();
            Cursor rows = db.rawQuery("SELECT count('"+ Constans.dbColumSubCatego_id+"') FROM "+Constans.dbTbSubCatego,null);

            //conteno de los registros
            rows.moveToFirst();
            boolean rs = (rows.getInt(0) <= 0);

            if(rs){
                db = database.getWritableDatabase();
                //subcategorias de la primera categoria
                SubCategoriasEntity casa1 = new SubCategoriasEntity("Casas - Reto 1","sub_cat_casas_uno",1,1,0);
                SubCategoriasEntity casa2 = new SubCategoriasEntity("Casas - Reto 2","sub_cat_casas_dos",1,0,0);
                SubCategoriasEntity casa3 = new SubCategoriasEntity("Casas - Reto 3","sub_cat_casas_tres",1,0,0);
                SubCategoriasEntity casa4 = new SubCategoriasEntity("Casas - Reto 4","sub_cat_casas_cuatro",1,0,0);
                SubCategoriasEntity casa5 = new SubCategoriasEntity("Casas - Reto 5","sub_cat_casas_cinco",1,0,0);
                SubCategoriasEntity casa6 = new SubCategoriasEntity("Casas - Reto 6","sub_cat_casas_seis",1,0,0);

                //insertar cada entidad
                insert(casa1);
                insert(casa2);
                insert(casa3);
                insert(casa4);
                insert(casa5);
                insert(casa6);

                //------------------------------------------
                //subcategorias de la primera categoria
                SubCategoriasEntity animal1 = new SubCategoriasEntity("Animales - Reto 1","sub_cat_animal_uno",2,1,0);
                SubCategoriasEntity animal2 = new SubCategoriasEntity("Animales - Reto 2","sub_cat_animal_dos",2,0,0);
                SubCategoriasEntity animal3 = new SubCategoriasEntity("Animales - Reto 3","sub_cat_animal_tres",2,0,0);
                SubCategoriasEntity animal4 = new SubCategoriasEntity("Animales - Reto 4","sub_cat_animal_cuatro",2,0,0);
                SubCategoriasEntity animal5 = new SubCategoriasEntity("Animales - Reto 5","sub_cat_animal_cinco",2,0,0);
                SubCategoriasEntity animal6 = new SubCategoriasEntity("Animales - Reto 6","sub_cat_animal_seis",2,0,0);

                //insertar cada entidad
                insert(animal1);
                insert(animal2);
                insert(animal3);
                insert(animal4);
                insert(animal5);
                insert(animal6);

                //-------------------------------------------
                //subcategorias de la primera categoria
                SubCategoriasEntity calle1 = new SubCategoriasEntity("Calles - Reto 1","sub_cat_calle_uno",3,1,0);
                SubCategoriasEntity calle2 = new SubCategoriasEntity("Calles - Reto 2","sub_cat_calle_dos",3,0,0);
                SubCategoriasEntity calle3 = new SubCategoriasEntity("Calles - Reto 3","sub_cat_calle_tres",3,0,0);
                SubCategoriasEntity calle4 = new SubCategoriasEntity("Calles - Reto 4","sub_cat_calle_cuatro",3,0,0);
                SubCategoriasEntity calle5 = new SubCategoriasEntity("Calles - Reto 5","sub_cat_calle_cinco",3,0,0);
                SubCategoriasEntity calle6 = new SubCategoriasEntity("Calles - Reto 6","sub_cat_calle_seis",3,0,0);

                //insertar cada entidad
                insert(calle1);
                insert(calle2);
                insert(calle3);
                insert(calle4);
                insert(calle5);
                insert(calle6);
            }

            //finaliza
            db.close();
            return rs;

        }catch (Exception e){
            return true;
        }
    }

}
