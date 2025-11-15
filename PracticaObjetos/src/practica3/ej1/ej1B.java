/*
Realizar un programa que instancie un triángulo, le cargue información leída desde
teclado e informe en consola el perímetro y el área.
 */
package practica3.ej1;
import PaqueteLectura.Lector;
import practica3.triangulo;
/**
 *
 * @author rocio
 */
public class ej1B {
    public static void main (String [] args){
        triangulo Triangulo1 = new triangulo (Lector.leerDouble(), Lector.leerDouble(), Lector.leerDouble(), Lector.leerString(), Lector.leerString());
        System.out.println("el perimetro del triangulo es:"+ Triangulo1.calcularPerimetro());
        System.out.println("el area del triangulo es:"+ Triangulo1.calcularArea());
    }
    
}
