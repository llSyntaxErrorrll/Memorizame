package com.apps.memorizame.Entitys;

public class CategoriasEntity {

    //declaracion de variables
    private int idEstado,idCategoria;
    private String nombre, imagen;

    public CategoriasEntity(String nombre, String imagen, int idEstado){
        //setear datos
        this.nombre = nombre;
        this.imagen = imagen;
        this.idEstado = idEstado;
    }

    //metodos geters
    public int getIdCategoria(){ return idCategoria; }
    public String getNombre(){ return nombre; }
    public String getImagen(){ return imagen; }
    public int getIdEstado(){ return idEstado; }

    //metodos setters
    public void setIdCategoria(int idCategoria){ this.idCategoria = idCategoria; }
}
