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
public class hotel {
    private int numHabitaciones;
    private habitacion [] habitaciones;
    
    public hotel (int n){
        numHabitaciones=n;//es necesario el this??
        habitaciones = new habitacion[n];
        for (int i=0;i<n;i++){
            habitaciones[i]= new habitacion();
        }
        
    }
    public hotel(){
        habitaciones= new habitacion[numHabitaciones];
    }
    public int getNumHabitaciones(){
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public habitacion[] getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(habitacion[] habitaciones) {
        this.habitaciones = habitaciones;
    }
    public void agregarCli (cliente cli, int nHabitaciones){
        habitaciones[nHabitaciones].ocupar(cli);//CONSULTAR
    }
    public void aumentarP(double n) {
        for (int i=0; i < numHabitaciones; i++) {
            habitaciones[i].aumentar(n);
        }
    }
    @Override
    public String toString() {
        String aux = "";
        for (int n = 0; n <numHabitaciones; n++) {
            aux += "Habitacion " + (n+1) + ":" + this.habitaciones[n].toString() + "\n" ;//CONSULTAR
        }
        return aux;
    }
}
