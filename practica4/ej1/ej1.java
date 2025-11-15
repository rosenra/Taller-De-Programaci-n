/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.ej1;

import PaqueteLectura.Lector;

/**
 *
 * @author rocio
 */
public class ej1 {
    public static void main (String [] args){
     circulo circulo1= new circulo(Lector.leerDouble(), Lector.leerString(), Lector.leerString());
     triangulo triangulo1 = new triangulo(Lector.leerDouble(), Lector.leerDouble(), Lector.leerDouble(), Lector.leerString(), Lector.leerString());
    
     System.out.println (circulo1.toString());
     System.out.println (triangulo1.toString());
            
    triangulo1.Despintar();
    System.out.println (triangulo1.toString());
  }
}
