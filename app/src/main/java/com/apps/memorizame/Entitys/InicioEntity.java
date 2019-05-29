package com.apps.memorizame.Entitys;

public class InicioEntity {

    //declaracion de variables
    private int imagen;
    private String nombre, estado;

    public InicioEntity(int imagen, String nombre, String estado){
        //setear datos
        this.nombre = nombre;
        this.imagen = imagen;
        this.estado = estado;
    }

    //metodos geters
    public int getImagen(){ return imagen; }
    public String getNombre(){ return nombre; }
    public String getEstado(){ return estado; }
}
