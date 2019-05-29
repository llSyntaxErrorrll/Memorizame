package com.apps.memorizame.Entitys;

public class RespuestasEntity {

    //declaracion de variables
    private int idRespuesta,idPregunta;
    private String respuesta,respuestaCorrecta;

    public RespuestasEntity(int idRespuesta, String respuesta, int idPregunta, String respuestaCorrecta){
        //setear datos
        this.idRespuesta = idRespuesta;
        this.respuesta = respuesta;
        this.idPregunta = idPregunta;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    //metodos geters
    public int getIdRespuesta(){ return idRespuesta; }
    public String getRespuesta(){ return respuesta; }
    public int getIdPregunta(){ return idPregunta; }
    public String getRespuestaCorreta(){ return respuestaCorrecta; }
}
