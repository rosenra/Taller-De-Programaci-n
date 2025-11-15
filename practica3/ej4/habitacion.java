/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3.ej4;

import  PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author rocio
 */
public class habitacion {
    private double costo;
    private boolean ocupada;
    private cliente cli;
    //GeneradorAleatorio.iniciar();
    public habitacion (){
        this.costo= GeneradorAleatorio.generarDouble(6000)+2000 ;//consultar
        this.ocupada=false;//devuelvo false o String "ocupada"???
        this.cli=null;
    }

   
    public double getCosto(){
        return costo;
    }
    public void setCosto(double unCosto){
        costo=unCosto;
    }
    public boolean isOcupada(){//CONSULTAR EL IS
        return ocupada;
    }

    private void setOcupada(boolean ocupada) {//puede no ir
        this.ocupada = ocupada;
    }
    
    public cliente getCliente(){
         return cli;
    }

    public void setCli(cliente unCliente) {
        this.cli = unCliente;
    }
    public void ocupar(cliente c){
        if(!ocupada){
            this.cli=c;
            this.ocupada= true;
        }
    }
    public void aumentar (double n){
        costo+=n;
    }
   
    @Override
    public String toString(){
     String aux= "costo:%.2f%n"+costo+" estado: "+ocupada;
     if (ocupada){
         aux+=cli.toString();
     }
     return aux;
    }
    
}
