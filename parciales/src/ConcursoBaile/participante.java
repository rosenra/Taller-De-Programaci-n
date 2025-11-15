/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcursoBaile;

/**
 *
 * @author rocio
 */
public class participante {
    private String nombre;
    private int edad;
    private int dni;
    
public participante(String nom, int edad, int dni){
    this.nombre =nom;
    this.edad = edad;
    this.dni= dni;
}

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getDni() {
        return dni;
    }
    @Override
    public String toString(){
    return "nombre "+this.getNombre()+" edad "+this.getEdad()+" dni: "+this.getDni();
}
}
