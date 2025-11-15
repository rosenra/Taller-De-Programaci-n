/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3.ej5;

/**
 *
 * @author rocio
 */
public class circulo {
    private double radio;
    private String relleno;
    private String linea;
    
    public circulo (double unRadio,String unRelleno, String unaLinea){
        this.radio=unRadio;
        this.relleno= unRelleno;
        this.linea= unaLinea;
    }
    public double getRadio(){
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public String getRelleno() {
        return relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }
    public double calcularPerimetro(){
        return 2* Math.PI*radio;
    }
    public double calcularArea(){
        return Math.PI*(radio*radio);
    }

    @Override
    public String toString() {
        return "radio: "+radio+" color de relleno: "+relleno+" color del borde: "+linea;
    }
    
}
