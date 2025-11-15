/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3.ej4;
import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author rocio
 */
public class ej4 {
	public static void main (String [] args){
    	GeneradorAleatorio.iniciar();
    	hotel hotel1 = new hotel(15);
    	int i;
    	int numHab = 0;// 0 o 1???
    	for (i=0; i < 8; i++) {
        	cliente c = new cliente(GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarInt(50)+100, GeneradorAleatorio.generarInt(100));
        	hotel1.agregarCli(c, numHab);
        	numHab += 2;//salteo para ver como quedan vacias
    	}
    	System.out.println(hotel1.toString());
    	hotel1.aumentarP (100.10);
    	System.out.println(hotel1.toString());
	}
}



