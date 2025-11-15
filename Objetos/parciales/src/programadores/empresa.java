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
public class empresa {
    private String nombre;
    private programadorLider lider;
    private int cantProgramadores;
    private programadores [] vector;
    private int contador = 0;
    
    public empresa (String nom,programadorLider programL,int cantP){
        setNombre(nom);
        setLider(programL);
        setCantProgramadores(cantP);
        vector= new programadores[this.cantProgramadores];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public programadorLider getLider() {
        return lider;
    }

    public void setLider(programadorLider lider) {
        this.lider = lider;
    }

    public int getCantProgramadores() {
        return cantProgramadores;
    }

    public void setCantProgramadores(int cantProgramadores) {
        this.cantProgramadores = cantProgramadores;
    }
    public void agregarProgramador(programadores P){
        if(this.contador<this.cantProgramadores){
            vector[this.contador]= P;
            this.contador++;
        }
    }
    public double totalAPagar(){
        double total= lider.calcularSueldo();
        for(int i=0;i<this.contador;i++){
            total+=vector[i].calcularSueldo();
        }
        return total;
    }
    public void aumentar(double monto){
        lider.aumentar(monto);
        for(int i=0;i<this.contador;i++){
            vector[i].aumentar(monto);
        }
    }
    public String toString(){
        String aux= "Empresa: "+this.nombre+"\n"+"programador lider: "+lider.toString()+"\n";
        for(int i=0;i<this.contador;i++){
            aux+="programador "+(i+1)+": "+vector[i].toString()+"\n";
        }
        aux+= "monto total abonar por la empresa: "+this.totalAPagar();
        return aux;
    }
}
