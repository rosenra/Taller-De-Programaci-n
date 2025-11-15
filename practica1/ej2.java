/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;
import PaqueteLectura.Lector;
/**
 *
 * @author rocio
 */
public class ej2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Paso 2: Declarar la variable vector de double 
        int DF=5;
     double [] jugadores;
     jugadores = new double [DF];
     int i;
     double suma =0;
     for (i=0;i<DF; i++){
         System.out.println("ingresse una altura");
         jugadores[i]= Lector.leerDouble ();
         suma += jugadores[i];

     }
     suma = (suma/DF);
     System.out.printf("la altura promedio es: %.2f",suma);
     System.out.println ();
     int cant =0;
     for (i=0; i<DF; i++) {
         if (jugadores[i]> suma)
             cant ++;
     }
     System.out.println ("la cantidad de jugadores cuya altura supera la media es:"+cant); 
      
      

    }
    
}
