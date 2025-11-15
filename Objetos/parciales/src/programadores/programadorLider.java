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
public class programadorLider extends programadores {
    private int antiguedad;
    private int proyectosDirigidos;
    
    public programadorLider (String nom,int dni,double basico,int lineas,String lenguaje,int aniosAntiguedad,int dirigidos){
       super(nom,dni,basico,lineas,lenguaje);
       setAntiguedad(aniosAntiguedad);
       setProyectosDirigidos(dirigidos);
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getProyectosDirigidos() {
        return proyectosDirigidos;
    }

    public void setProyectosDirigidos(int proyectosDirigidos) {
        this.proyectosDirigidos = proyectosDirigidos;
    }
    public double calcularSueldo(){
        double aux = super.calcularSueldo()+this.antiguedad*10000+this.proyectosDirigidos*20000;
        return aux;
    }
    public void aumentar(double monto){
        super.aumentar(monto);
    }
    public String toString(){
        return super.toString()+" anios de antiguedad"+this.antiguedad+" cantidad de proyectos dirigidos: "+this.proyectosDirigidos;
    }
    
}
