package com.apps.memorizame.Entitys;

public class SubCategoriasEntity {

    //declaracion de variables
    private String nombreSub,imagenSub;
    private int idSubCategoria,idCategoria,idEstado,calificacion;

    public SubCategoriasEntity(String nombreSub, String imagenSub, int idCategoria, int idEstado, int calificacion){
        //setear datos
        this.nombreSub = nombreSub;
        this.imagenSub = imagenSub;
        this.idCategoria = idCategoria;
        this.idEstado = idEstado;
        this.calificacion = calificacion;
    }

    //getters de esta entidad
    public int getIdSubCategoria(){ return idSubCategoria; }
    public String getNombreSub(){ return nombreSub; }
    public String getImagenSub(){ return imagenSub; }
    public int getCalificacion(){ return calificacion; }
    public int getIdCategoria(){ return idCategoria; }
    public int getIdEstado(){ return idEstado; }

    //setters
    public void setIdSubCategoria(int idSubCategoria){ this.idSubCategoria = idSubCategoria; }

}
