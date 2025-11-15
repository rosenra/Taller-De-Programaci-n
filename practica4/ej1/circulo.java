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
public class circulo extends figura{
    private double radio;
    public circulo (double radio, String unRelleno,String unBorde){
        super(unRelleno,unBorde);
        setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double unRadio) {
        this.radio = unRadio;
    }
    @Override
    public double calcularPerimetro(){
        return (2*(radio* Math.PI));
    }
    @Override
    public double calcularArea(){
        return (Math.PI*(this.radio*this.radio));
    }
    public String ToString(){
        return super.toString()+
               " Radio: " + this.radio;
    }
}
