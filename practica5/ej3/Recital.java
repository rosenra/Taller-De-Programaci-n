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
public abstract class Recital {
    private String banda;
    private int cantTemas;
    private String [] listaTemas;
    private int contador=0;
    public Recital (String unaBanda,int cant){
        this.setBanda(unaBanda);
        this.setCantTemas(cant);
        this.listaTemas= new String[cant];// NEW STRING!!!
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public int getCantTemas() {
        return cantTemas;
    }

    public void setCantTemas(int cantTemas) {
        this.cantTemas = cantTemas;
    }  

    public String[] getListaTemas() {
        return listaTemas;
    }
    
    
    public void agregarTema(String tema){
        if(contador<this.cantTemas){
            this.listaTemas[contador++]=tema;
        }
    }
    public String actuar(){
        String aux="y ahora tocaremos:";
        int i= this.contador;
        return aux+this.listaTemas[i-1];//???
    }
/*for(i=0;i<this.cantTemas;i++){CONSULTAR
    return aux+this.getListaTemas()[i];
    */
    public abstract int calcularCosto();
    
    
}
