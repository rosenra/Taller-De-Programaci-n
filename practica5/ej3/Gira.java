/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5.ej3;

/**
 *
 * @author rocio
 */
public class Gira extends Recital {
    private String nombre;
    private Fecha [] listaFechas;
    private int actual;
    private int cantFechas;
 
    
    public Gira (String unNom,String banda,int cantT,int cantF){
        super(banda,cantT);
        this.setNombre(unNom);
        this.setCantFechas(cantF);
        this.listaFechas= new Fecha[cantF];
        this.actual=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantFechas() {
        return cantFechas;
    }

    public void setCantFechas(int cantFechas) {
        this.cantFechas = cantFechas;
    }
    public void agregarFecha(Fecha f){
        int i=0;
        while((this.listaFechas[i]!= null)&&(i<this.cantFechas)){
            i++;
        }
        if(i<this.cantFechas){
            this.listaFechas[i]=f;
        }
    }
    public String actuar(){
        String aux="Buenas noches"+this.listaFechas[this.actual];
        return aux+super.actuar();
    }
    public int calcularCosto(){
        int aux=0;
        for (int i=0;i<this.cantFechas;i++){
            aux+=30000;
        }
        return aux;
    }
}
