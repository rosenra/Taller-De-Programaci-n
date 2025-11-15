/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

/**
 *
 * @author rocio
 */
public class Estanteria {
    private int maximo=20;
    private int cantLibros;
    private Libro [] librosE;
    //Consultar punto 3.B
    public Estanteria(){
        this.cantLibros=0;
        librosE= new Libro[maximo];
    }
    public Estanteria(int n){
       this.cantLibros = 0;
       maximo = n;
       librosE = new Libro [n];// CONSULTAR
   }
    public int getCantLibros(){
        return cantLibros;
    }
    public boolean lleno(){
        return maximo== cantLibros;
    }
    public boolean agregarL(Libro l1){
        if (!lleno()){
            librosE[cantLibros++]=l1;
            return true;
        }
        else return false;
    }
    public Libro devolverTitulo (String t1){
        int aux=0;
        while ((aux< cantLibros)&&(!t1.equals(this.librosE[aux].getTitulo()))){//GET TITULO!!!
            aux++;
        }
        if (aux< cantLibros) {
            return librosE[aux];
        }
        else {
            return null;
        }
    }
}
