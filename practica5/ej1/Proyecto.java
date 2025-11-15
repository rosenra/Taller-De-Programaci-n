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
public class Proyecto {
   private String nombre;
   private int codigo;
   private String director;
   private Investigador [] investigadores;
   private int cantInves;
   
   public Proyecto (String unNombre,int unCodigo,String unDirector){
       setNombre(unNombre);
       setCodigo(unCodigo);
       setDirector(unDirector);
       this.investigadores= new Investigador[50];
       this.cantInves=0;
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getCantInves() {
        return cantInves;
    }
    public void agregarInves (Investigador unInvestigador){
        if (this.cantInves<50){
            this.investigadores[this.cantInves++]=unInvestigador;
        }
    }
     public double dineroTotalOtorgado () {
        double aux = 0;
        for(int i=0; i<this.cantInves; i++) {
            aux+= this.investigadores[i].montoTotal();
        }
        return aux;
    }
     public void otorgarTodos(String nombre_completo){
         int i=0;
         while (i<this.cantInves && !this.investigadores[i].getNomCompleto().equals(nombre_completo)){
             i++;
         }
         if (i<this.cantInves){
             this.investigadores[i].otorgarSub();//cumple?
         }
     }
   @Override
     public String toString(){
         String aux= "nombre: "+this.getNombre()+" codigo: "+this.getCodigo()+" director: "+this.getDirector()+" total otorgado: "+this.dineroTotalOtorgado();
         for(int i=0;i<this.cantInves;i++){
             aux+=this.investigadores[i].toString();//!!!
         }
         return aux;
     }
}
