/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5.ej4;

/**
 *
 * @author rocio
 */
public class Persona {
    private String nombre;
    private int edad;
    private int dni;
    
    public Persona (String unNombre,int unaEdad,int unDni){
        setNombre(unNombre);
        setEdad(unaEdad);
        setDni(unDni);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }
    @Override
    public String toString(){
        return "nombre: "+this.nombre+" edad: "+this.edad+" dni: "+this.dni;
    }
}
