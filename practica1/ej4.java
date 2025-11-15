/*
Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso
(1..4). Realice un programa que permita informar la cantidad de personas que
concurrieron a cada oficina de cada piso. Para esto, simule la llegada de personas al
edificio de la siguiente manera: a cada persona se le pide el nro. de piso y nro. de
oficina a la cual quiere concurrir. La llegada de personas finaliza al indicar un nro.
de piso 9. Al finalizar la llegada de personas, informe lo pedido. 
 */
package practica1;
import PaqueteLectura.*;
/**
 *
 * @author rocio
 */
public class ej4 {
    public static void main (String [] args){
        GeneradorAleatorio.iniciar ();
        int piso = 8;
        int oficina = 4;
        int [][] edificio = new int [piso][oficina];
        System.out.println ("ingrese piso");
       // int p = Lector.leerInt ();
        int p = GeneradorAleatorio.generarInt (9)+1;
        while (p != 9){
            System.out.println ("ingrese oficina");
            int ofi = GeneradorAleatorio.generarInt (4)+1;
            //int ofi = Lector.leerInt ();
            edificio [p-1][ofi-1] ++;
            System.out.println ("ingrese piso");
            //int p = Lector.leerInt ();
            p = GeneradorAleatorio.generarInt (9)+1;
        }
        int i,j;
        i=0;
        j=0;
        for (i=0; i<piso; i++){
            System.out.println ("");
            for (j=0; j<oficina;j++){
            System.out.print (edificio [i][j]+"|"); }
        }
    }
}
