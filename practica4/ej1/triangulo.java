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
public class triangulo extends figura{
    private double lado1;
    private double lado2;
    private double lado3;
    
    public triangulo (double l1, double l2,double l3,String unRelleno, String unBorde){
        super(unRelleno,unBorde);
        setLado1(l1);
        setLado2(l2);
        setLado3(l3);
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
    @Override
    public double calcularPerimetro(){
        return (this.getLado1()+this.getLado2()+this.getLado3());
    }
    @Override
    public double calcularArea(){
        double s= (lado1 +lado2+lado3)/2;
        return Math.sqrt (s*(s-getLado1())*(s-getLado2())*(s-getLado3()));//tengo que crear var para cada lado ej a=getLado1()
    }
    @Override
    public String toString(){
        String aux = super.toString()+" lado1:"+this.lado1+" lado2:"+this.lado2+"lado3:"+this.lado3;
        return aux;
    }
}
