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
public class cuadrado extends figura{
    private double lado;
    
    public cuadrado(double lado, String unRelleno, String unBorde){
        super(unRelleno,unBorde);// sin el super queda un cosntructor nulo
        setLado(lado);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    @Override
    public double calcularPerimetro(){
        return (getLado()*4);
    }
    @Override
    public double calcularArea(){
        return (getLado()*getLado());
    }
    @Override
    public String toString(){
       String aux = super.toString() + 
                    " Lado: " + getLado();
       return aux;
    }
}
