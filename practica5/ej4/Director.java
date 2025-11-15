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
public class Director extends Persona {
    private int antiguedad;
    
    public Director (int antiguedad,String nom,int edad,int dni){
        super(nom,edad,dni);
        this.setAntiguedad(antiguedad);
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    public String toString(){
        return super.toString()+" antiguedad: "+this.antiguedad;
    }
}
