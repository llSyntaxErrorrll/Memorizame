package com.apps.memorizame.Entitys;

public class RespuestasEntity {

    //declaracion de variables
    private int idRespuesta,idPregunta;
    private String respuesta,respuestaCorrecta;

    public RespuestasEntity( String respuesta, int idPregunta, String respuestaCorrecta){
        //setear datos
        this.respuesta = respuesta;
        this.idPregunta = idPregunta;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public void setIdPregunta(int idRespuesta){
        this.idRespuesta = idRespuesta;
    }

    //metodos geters
    public int getIdRespuesta(){ return idRespuesta; }
    public String getRespuesta(){ return respuesta; }
    public int getIdPregunta(){ return idPregunta; }
    public String getRespuestaCorreta(){ return respuestaCorrecta; }
}
