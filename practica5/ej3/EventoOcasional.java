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
public class EventoOcasional extends Recital {
    private String motivo;
    private String contratante;
    private int dia;
    
    public EventoOcasional(String unaBanda,int cantTemas,String unMotivo,String unContratante,int unDia){
        super(unaBanda,cantTemas);
        this.setMotivo(unMotivo);
        this.setContratante(unContratante);
        this.setDia(unDia);
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    public String actuar(){
        String aux;
        if (this.motivo.equals("beneficiencia")){
            aux="recuerden colaborar con "+this.contratante;
        }
        else if(this.motivo.equals("TV")){
            aux="Saludos amigos televidentes";
        }
        else{
            aux="un feliz cumpleaños para "+this.contratante;
        }
        return aux+super.actuar();
    }
    public int calcularCosto(){
        int aux=0;
        if (this.motivo.equals("beneficiencia")){
            aux=0;
        }
        else if(this.motivo.equals("TV")){
            aux=50000;
        }
        else{
            aux=150000;
        }
        return aux;
    }
}
