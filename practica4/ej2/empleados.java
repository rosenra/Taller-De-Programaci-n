/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.ej2;

/**
 *
 * @author rocio
 */
public abstract class empleados {
    private String nombre;
    private double sueldo;
    private int antiguedad;
    
    public empleados (String unNombre,double unSueldo,int unaAntiguedad){
        this.setNombre(unNombre);
        this.setSueldo(unSueldo);
        this.setAntiguedad(unaAntiguedad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    public abstract double calcularEfectividad();
    
    public double calcularSueldoACobrar(){
        double aux = this.getSueldo()+(this.getSueldo()*0.10)*antiguedad;
        return aux;}
    
    @Override
    public String toString(){
        String aux="nombre: "+getNombre()+" sueldo: "+getSueldo()+" antiguedad: "+getAntiguedad()+" efectividad:"+ this.calcularEfectividad();
        return aux;
    }
}
