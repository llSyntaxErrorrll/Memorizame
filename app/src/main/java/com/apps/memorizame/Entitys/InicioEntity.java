package com.apps.memorizame.Entitys;

public class InicioEntity {

    //declaracion de variables
    private int imagen;
    private String nombre;

    public InicioEntity(int imagen, String nombre){
        //setear datos
        this.nombre = nombre;
        this.imagen = imagen;
    }

    //metodos geters
    public int getImagen(){ return imagen; }
    public String getNombre(){ return nombre; }
}
