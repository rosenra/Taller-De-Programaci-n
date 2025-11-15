/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcursoBaile;

/**
 *
 * @author rocio
 */
public class concurso {
    private pareja vecP [];//Vector o matriz de 2xN???
    private int cantP;//DIMF!!!
    private int cantPCargadas;//DIML!!!
    
    public concurso (int cant){
        this.cantP= cant;
        vecP= new pareja[cantP];
        cantPCargadas=0;
    }

    public int getCantP() {
        return cantP;
    }

    public int getCantPCargadas() {
        return cantPCargadas;
    }
    
    public void agregarPareja (pareja p1){
        if (cantP> cantPCargadas){
            vecP[cantPCargadas]= p1;
            cantPCargadas++;
        }
    }
    public pareja masDifDeEdad(){//no funciona
        pareja parejaMax=null;//??? esta bien el null?
        int difMax=0;
        for(int i=0;i<this.cantPCargadas;i++){
            if(this.vecP[i].diferenciaEdad()>difMax){
                difMax= this.vecP[i].diferenciaEdad();
                parejaMax= this.vecP[i];
            }
        }
        return parejaMax;
    }
    
    @Override
    public String toString(){
        String aux = " ";
        for(int i=0; i<this.cantPCargadas;i++){
            aux+= "pareja "+i+" : "+this.vecP[i].toString()+"\n";
        }
        return aux;
    }
}
