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
public class jugadores extends empleados {
    private int partidosJugados;
    private int golesAnotados;
    
    public jugadores (int partidos,int goles, String unNombre,double unSueldo,int antiguedad){
        super(unNombre,unSueldo,antiguedad);
        setPartidosJugados(partidos);
        setGolesAnotados(goles);
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }
    

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }
    @Override
    public double calcularEfectividad(){
        return (this.getGolesAnotados()/this.getPartidosJugados());
    }
    @Override
    public String toString(){
        String aux = super.toString()+" partidos jugados: "+this.getPartidosJugados()+"goles anotados:"+this.getGolesAnotados()+" sueldo a cobrar: "+ this.calcularSueldoACobrar();
        return aux;
    }
    @Override
    public double calcularSueldoACobrar(){
        double aux= super.calcularSueldoACobrar();
        if(this.calcularEfectividad()>=0.5){
            aux=aux+super.calcularSueldoACobrar();
        }
        return aux;
    }
}
