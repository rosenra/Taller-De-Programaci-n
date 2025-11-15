/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5.ej1;

/**
 *
 * @author rocio
 */
public class Investigador {
    private String nomCompleto;
    private int categoria;
    private String especialidad;
    private Subsidio [] sub;
    private int cantSubsidios;
    
    public Investigador (String unNom, int unaCategoria,String unaEspecialidad){
        setNomCompleto(unNom);
        setCategoria(unaCategoria);
        setEspecialidad(unaEspecialidad);
        this.cantSubsidios=0;
        this.sub=new Subsidio[5];
    }

    public String getNomCompleto() {
        return nomCompleto;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getCantSubsidios() {
        return cantSubsidios;
    }
    public void agregarSub (Subsidio unSubsidio){
        if (this.cantSubsidios<5){
            this.sub[this.cantSubsidios++]=unSubsidio;
        }
    }
    public double montoTotal(){
        int i=0;
        double aux=0;
        while (i<this.cantSubsidios && this.sub[i].isOtorgado()){
            aux+= this.sub[i].getMonto();
            i++;
        }
        return aux;
    }
    public void otorgarSub(){//hay otra forma o esta bien
        for(int i=0;i<this.cantSubsidios;i++){
            if(!this.sub[i].isOtorgado()){
                this.sub[i].setOtorgado(true);
            }
        }
    }
    @Override
    public String toString(){
        return "Nombre Completo: "+this.getNomCompleto()+" categoria: "+this.getCategoria()+" especialidad: "+this.getEspecialidad()+" cantidad de subsidios: "+this.getCantSubsidios()+" monto total de subsidios otorgados: "+this.montoTotal();
    }
}
