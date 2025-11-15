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
public class entrenadores extends empleados{
    private int campeonatosGanados;
    public entrenadores (int ganados,String unNombre,double unSueldo,int antiguedad){
        super(unNombre,unSueldo,antiguedad);
        setCampeonatosGanados(ganados);
    }

    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }
    @Override
    public double calcularEfectividad(){
        return (this.getCampeonatosGanados()/this.getAntiguedad());
    }
    @Override
    public double calcularSueldoACobrar(){
        double aux= super.calcularSueldoACobrar();
        if ((this.campeonatosGanados>= 1)&&(this.campeonatosGanados<=4)){
          aux=aux + 5000;}
        else if ((this.campeonatosGanados>= 5)&&(this.campeonatosGanados<=10)){
            aux=aux+30000;
        }
        else if (this.campeonatosGanados>10){aux=aux+50000;}
        return aux;
        
    }
    @Override
    public String toString(){
        String aux= super.toString()+" campeonatos ganados:"+this.getCampeonatosGanados()+" sueldo a cobrar:"+this.calcularSueldoACobrar();
        return aux;
    }
}
