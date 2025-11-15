/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import PaqueteLectura.GeneradorAleatorio;


/**
 *
 * @author rocio
 */
public class ej1 {
    /**
     * Carga un vector que representa la tabla del 2
     */
    public static void main(String [] args) {
        GeneradorAleatorio.iniciar();
        int DF=15;  
        int [] tabla2 = new int[DF]; // indices de 0 a 10
        int i;
        for (i=0;i<DF;i++) 
            tabla2[i]=2*i;
        System.out.println("2x" + "5" + "="+ tabla2[5]);
        int num = GeneradorAleatorio.generarInt(15);
        while (num != 11){ 
          System.out.println("2x" + num + "="+ tabla2[num]);
          num = GeneradorAleatorio.generarInt (15);
        

    }
    
}
}
