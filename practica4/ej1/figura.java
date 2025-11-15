/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.ej1;

/**
 *
 * @author rocio
 */
public abstract class figura {
    private String relleno;
    private String borde;
   
    public figura (String unRelleno, String unBorde){
        setRelleno(unRelleno);//??
        setBorde(unBorde);
    }
    public String getRelleno(){
        return relleno;
    }
    public String getBorde(){
        return borde;
    }

    public void setRelleno(String unRelleno) {
        this.relleno = unRelleno;
    }

    public void setBorde(String unBorde) {
        this.borde = unBorde;
    }
    public abstract double calcularArea();// definir tipo!!!
    public abstract double calcularPerimetro();
    @Override
    public String toString(){
        String aux = "Area: " + this.calcularArea() + " Perimetro: " + this.calcularPerimetro() +
                     " CR: "  + getRelleno() + 
                      " CL: " + getBorde();            
             return aux;
       }
    public void Despintar(){//void pq no retorna nada
        this.setBorde("negro");
        this.setRelleno("blanco");
    }

}
