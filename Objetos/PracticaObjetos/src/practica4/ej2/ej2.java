/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.ej2;
import PaqueteLectura.Lector;
/**
 *
 * @author rocio
 */
public class ej2 {
    public static void main (String [] args){
        jugadores jugador;
        entrenadores entrenador;
        jugador =new jugadores(10,7,"pablo",100,2);
        entrenador = new entrenadores (15,"tomas",350,3);
        
        System.out.println(jugador.toString());
        System.out.println(entrenador.toString());
       
    }
}
