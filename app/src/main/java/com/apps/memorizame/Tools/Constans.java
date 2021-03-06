package com.apps.memorizame.Tools;

public class Constans {

    //tablas de la base de datos
    public static final String dbName = "memorizameDB";
    public static final String dbTbCatego = "categorias";
    public static final String dbTbSubCatego = "sub_categorias";
    public static final String dbTbPregun = "preguntas";
    public static final String dbTbRespue = "respuestas";

    //columnas de la tabla de categorias
    public static final String dbColumCatego_id = "id_categorias";
    public static final int dbColumCatego_id_index = 0;
    public static final String dbColumCatego_name = "nombre_categoria";
    public static final int dbColumCatego_name_index = 1;
    public static final String dbColumCatego_imag = "imagen_categoria";
    public static final int dbColumCatego_imag_index = 2;
    public static final String dbColumCatego_esta = "id_estado";
    public static final int dbColumCatego_esta_index = 3;

    //columnas de la tabla de categorias
    public static final String dbColumSubCatego_id = "id_sub_categorias";
    public static final int dbColumSubCatego_id_index = 0;
    public static final String dbColumSubCatego_name = "nombre_sub_categoria";
    public static final int dbColumSubCatego_name_index = 1;
    public static final String dbColumSubCatego_imag = "imagen_sub_categoria";
    public static final int dbColumSubCatego_imag_index = 2;
    public static final String dbColumSubCatego_esta = "id_estado";
    public static final int dbColumSubCatego_esta_index = 3;
    public static final String dbColumSubCatego_cate = "id_categoria";
    public static final int dbColumSubCatego_cate_index = 4;
    public static final String dbColumSubCatego_cali = "calificacion";
    public static final int dbColumSubCatego_cali_index = 5;

    //Columnas de la tabla preguntas
    public static final String dbColumPregunt_id = "id_pregunta";
    public static final int dbColumPregunt_id_index = 0;
    public static final String dbColumPregunt_nombre = "nombre_pregunta";
    public static final int dbColumPregunt_nombre_index = 1;
    public static final String dbColumPregunt_subcate = "ide_sub_categoria";
    public static final int dbColumPregunt_subcate_index = 2;
    public static final String dbColumPregunt_Respuesta1 = "respuesta_uno";
    public static final int dbColumPregunt_Respuesta1_index = 3;
    public static final String dbColumPregunt_Respuesta2 = "respuesta_dos";
    public static final int dbColumPregunt_Respuesta2_index = 4;
    public static final String dbColumPregunt_Respuesta3 = "respuesta_tres";
    public static final int dbColumPregunt_Respuesta3_index = 5;
    public static final String dbColumPregunt_RespuestaCorrecta = "respuesta_correcta";
    public static final int dbColumPregunt_RespuestaCorrrecta_index = 6;

    //Columnas de la tabla respuestas
    public static final String dbColumRespues_id = "id_respuesta";
    public static final int dbColumRespues_id_index = 0;
    public static final String dbColumRespues_nombre = "respuestas";
    public static final int dbColumRespues_nombre_index = 1;
    public static final String dbColumRespues_pre = "ide_pregunta";
    public static final int dbColumRespues_pre_index = 2;
    public static final String dbColumRespues_respuestaCorret = "respuesta_correcta";
    public static final int dbColumRespues_respuestaCorret_index = 3;


    //otras constantes
    public static final int blurRadius = 10;
}
