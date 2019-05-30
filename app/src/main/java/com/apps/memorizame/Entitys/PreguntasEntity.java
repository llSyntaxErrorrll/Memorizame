package com.apps.memorizame.Entitys;

public class PreguntasEntity {

    //declaracion de variables
    private int idPregunta, idTipoSubCate;
    private String nombrePregunta, respuesta1, respuesta2, respuesta3, respuestaCorrect;

    public PreguntasEntity( String nombrePregunta, int idTipoSubCate, String respuesta1,
                            String respuesta2,String respuesta3,String respuestaCorrect){
        //setear datos
        this.nombrePregunta = nombrePregunta;
        this.idTipoSubCate = idTipoSubCate;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuestaCorrect = respuestaCorrect;
    }
    public void setIdPregunta(int idPregunta){
        this.idPregunta = idPregunta;
    }

    //metodos geters
    public int getIdPregunta(){ return idPregunta; }
    public String getNombrePregunta(){ return nombrePregunta; }
    public int getIdTipoSubCate(){ return idTipoSubCate; }
    public String getRespuesta1(){ return respuesta1; }
    public String getRespuesta2(){ return respuesta2; }
    public String getRespuesta3(){ return respuesta3; }
    public String getRespuestaCorrect(){ return respuestaCorrect; }
}
