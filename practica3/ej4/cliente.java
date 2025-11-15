/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3.ej4;

/**
 *
 * @author rocio
 */
public class cliente {
    private String nombre;
    private int dni;
    private int edad;
    
    public cliente (String unNombre, int unDni, int unaEdad){
        nombre=unNombre;
        dni=unDni;
        edad=unaEdad;
    }
    public String getNombre(){
        return nombre;
    }
    public int getDni (){
        return dni;
    }
    public int getEdad(){
        return edad;
    }
    public void setNombre (String nom){
        nombre=nom;
    }
    public void setDni (int documento){
        dni=documento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString(){
      return "nombre: "+nombre+" dni:"+dni+ "edad: "+edad;  
    }
}
