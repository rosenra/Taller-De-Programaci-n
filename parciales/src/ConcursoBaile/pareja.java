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
public class pareja {
    private participante participante1;
    private participante participante2;
    private String estiloBaile;
    
    public pareja (String baile,participante p1,participante p2){
        this.estiloBaile=baile;
        this.participante1 =p1;
        this.participante2=p2;
    }

    public String getEstiloBaile() {
        return estiloBaile;
    }

    public participante getParticipante1() {
        return participante1;
    }

    public participante getParticipante2() {
        return participante2;
    }
    
    public int diferenciaEdad(){
        int edad1 =this.participante1.getEdad();
        int edad2= this.participante2.getEdad();
        int resultado;
        if (edad1>edad2){
            resultado=edad1-edad2;
        }
        else {
            resultado=edad2-edad1;
        }
        return resultado;
    }
    
    public String toString(){
        String aux;
        aux=this.participante1.toString()+" "+this.participante2.toString()+" "+this.getEstiloBaile();
        return aux;
    }
}
