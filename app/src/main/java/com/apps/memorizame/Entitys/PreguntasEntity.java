package com.apps.memorizame.Entitys;

public class PreguntasEntity {

    //declaracion de variables
    private int idPregunta, idTipoSubCate;
    private String nombrePregunta;

    public PreguntasEntity( String nombrePregunta, int idTipoSubCate){
        //setear datos
        this.nombrePregunta = nombrePregunta;
        this.idTipoSubCate = idTipoSubCate;
    }
    public void setIdPregunta(int idPregunta){
        this.idPregunta = idPregunta;
    }

    //metodos geters
    public int getIdPregunta(){ return idPregunta; }
    public String getNombrePregunta(){ return nombrePregunta; }
    public int getIdTipoSubCate(){ return idTipoSubCate; }
}
