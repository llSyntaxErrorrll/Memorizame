package com.apps.memorizame.Tools;

public class Constans {

    //tablas de la base de datos
    public static final String dbName = "memorizameDB";
    public static final String dbTbCatego = "categorias";
    public static final String dbTbSubCatego = "sub_categorias";
    public static final String dbTbEstado = "estados";
    public static final String dbTbPregun = "preguntas";
    public static final String dbTbRespue = "respuestas";

    //columnas de la tabla de categorias
    public static final String dbColumCatego_id = "id_categorias";
    public static final String dbColumCatego_name = "nombre_categoria";
    public static final String dbColumCatego_imag = "imagen_categoria";
    public static final String dbColumCatego_esta = "id_estado";

    //columnas de la tabla de categorias
    public static final String dbColumSubCatego_id = "id_sub_categorias";
    public static final String dbColumSubCatego_name = "nombre_sub_categoria";
    public static final String dbColumSubCatego_imag = "imagen_sub_categoria";
    public static final String dbColumSubCatego_esta = "id_estado";
    public static final String dbColumSubCatego_cate = "id_categoria";
    public static final String dbColumSubCatego_cali = "calificacion";
}
