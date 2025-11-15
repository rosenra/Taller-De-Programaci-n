/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teatro;

/**
 *
 * @author rocio
 */
public class butaca {
    private String descriptor;
    private double precio;
    private boolean libre;//true=ocupado false=desocupado
    private int fila;
    private int columna;
    
    public butaca (int i,int j){
        this.fila= i;//¡¡¡
        this.columna= j;
        this.descriptor="fila "+this.getFila()+" columna "+this.getColumna();
        this.precio=(800+100*this.getFila());
        this.libre=false;
    }

    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isLibre() {
        return libre;
    }

    public void ocupar(boolean estado) {
        this.libre = estado;
    }
    public String toString(){
        return "descriptor: "+this.getDescriptor()+" precio: "+this.getPrecio()+" estado: "+this.isLibre();
    }
}
