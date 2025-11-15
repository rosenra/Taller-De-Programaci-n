/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5.ej2;

/**
 *
 * @author rocio
 */
public class Auto {
    private String dueño;
    private String patente;
    
    public Auto(String unDueño,String unaPatente){
        setDueño(unDueño);
        setPatente(unaPatente);
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        String aux="dueño: "+this.getDueño()+" patente: "+this.getPatente();
        return aux;
    }
    
}
