package com.apps.memorizame.Entitys;

public class PreguntasEntity {

    //declaracion de variables
    private int idPregunta, idTipoSubCate;
    private String nombrePregunta;

    public PreguntasEntity(int idPregunta, String nombrePregunta, int idTipoSubCate){
        //setear datos
        this.idPregunta = idPregunta;
        this.nombrePregunta = nombrePregunta;
        this.idTipoSubCate = idTipoSubCate;
    }

    //metodos geters
    public int getIdPregunta(){ return idPregunta; }
    public String getNombrePregunta(){ return nombrePregunta; }
    public int getIdTipoSubCate(){ return idTipoSubCate; }
}
