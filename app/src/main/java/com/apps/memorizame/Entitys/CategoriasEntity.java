package com.apps.memorizame.Entitys;

public class CategoriasEntity {

    //declaracion de variables
    private int idEstado;
    private String nombre, imagen;

    public CategoriasEntity(String nombre, String imagen, int idEstado){
        //setear datos
        this.nombre = nombre;
        this.imagen = imagen;
        this.idEstado = idEstado;
    }

    //metodos geters
    public String getImagen(){ return imagen; }
    public String getNombre(){ return nombre; }
    public int getIdEstado(){ return idEstado; }
}
