/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toneoAjedrez;

/**
 *
 * @author rocio
 */
public class profesional extends sitio {
    private infoProfesional [] vector;
    private String nom;
    private String dir;
    private int maximo;
    private int dimL;
    
    public profesional (int max,String nom,String dir){
        super(nom,dir);
        this.maximo= max;
        vector= new infoProfesional[this.maximo];
        this.dimL=0;
        this.inicializarVec();
    }

    public int getMaximo() {
        return maximo;
    }
    private void inicializarVec(){//¡¡¡
        for (int i=0; i<maximo; i++){
            this.vector[i]=null;
        }
    }
    
    public boolean registrarTorneoProfesional (infoProfesional ip){
        boolean ok=false;
        if(dimL<maximo){
            vector[dimL]=ip;
            dimL++;
            ok=true;
        }
        return ok;
    }
    public double cotizarSitio(){
        double recaudacion=0;
        for (int i=0; i<dimL;i++){
            recaudacion+=(vector[i].getMontoInscripciones()-vector[i].getMontoGanados())+1000;
        }
        return recaudacion;
    }
    public String toString(){
        String aux=super.toString()+"\n";
        for(int i=0;i<this.dimL;i++){
            aux+=vector[i].toString()+"\n";
        }
        return aux;
    }
}
