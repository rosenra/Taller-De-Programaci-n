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
public class infoProfesional {
    private String nombreP;//nombre diferente del nombre de los sitios???
    private String fecha;
    private double montoInscripciones;
    private double montoGanados;
    
    /*public infoProfesional (String nom,String dir,String n,String f,double inscrip,double ganados){
        super(nom,dir);
        this.nombreP=n;
        this.fecha=f;
        this.montoInscripciones=inscrip;
        this.montoGanados=ganados;
    }
*/
    public infoProfesional (String n,String f,double inscrip,double ganados){
        this.nombreP=n;
        this.fecha=f;
        this.montoInscripciones=inscrip;
        this.montoGanados=ganados;
    }
    public String getNombreP() {
        return nombreP;
    }

    public String getFecha() {
        return fecha;
    }

    public double getMontoInscripciones() {
        return montoInscripciones;
    }

    public double getMontoGanados() {
        return montoGanados;
    }
    public String toString(){
        String aux= "nombre: "+this.getNombreP()+" fecha: "+this.getFecha()+" monto inscripciones: "+this.getMontoInscripciones()+" monto partidos ganados: "+this.montoGanados;
        return aux;    
    }
}
