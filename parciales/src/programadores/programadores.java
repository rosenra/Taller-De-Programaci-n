/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programadores;

/**
 *
 * @author rocio
 */
public class programadores {
    private String nombre;
    private int dni;
    private double sueldoBasico;
    private int lineasXHora;
    private String lenguajePref;
    
    public programadores (String unNombre,int unDni,double basico,int lineasHr,String lenguaje){
        this.setNombre(unNombre);
        this.setDni(unDni);
        this.setSueldoBasico(basico);
        this.setLineasXHora(lineasHr);
        this.setLenguajePref(lenguaje);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int getLineasXHora() {
        return lineasXHora;
    }

    public void setLineasXHora(int lineasXHora) {
        this.lineasXHora = lineasXHora;
    }

    public String getLenguajePref() {
        return lenguajePref;
    }

    public void setLenguajePref(String lenguajePref) {
        this.lenguajePref = lenguajePref;
    }
    public double calcularSueldo(){
        if(this.lineasXHora>200){
            this.sueldoBasico+=50000;
        }
        return this.sueldoBasico;
    }
    public void aumentar(double monto){
        this.sueldoBasico+=monto;
    }
    public String toString(){
        return "nombre: "+this.nombre+" dni: "+this.dni+" sueldo basico: "+this.sueldoBasico+" lineas de codigo por hora: "+this.lineasXHora+" lenguaje de preferencia: "+this.lenguajePref;
    }
}
