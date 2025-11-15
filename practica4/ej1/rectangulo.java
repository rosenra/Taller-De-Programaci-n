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
public class rectangulo extends figura {
    private double base;
    private double altura;
    
    public rectangulo (double base, double altura,String unRelleno,String unBorde){
        super(unRelleno,unBorde);
        setBase(base);
        setAltura(altura);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double unaBase) {
        this.base = unaBase;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double unaAltura) {
        this.altura = unaAltura;
    }
    @Override// ???
    public double calcularPerimetro(){
        return (getBase()*getAltura());//??
    }
    @Override
    public double calcularArea(){
        return (2*getBase()+2*getAltura());
    }
    @Override
    public String toString(){
      String aux = super.toString() + 
                    " Base: " + getBase() +
                    " Altura: " + getAltura();
      return aux;
     }
}
