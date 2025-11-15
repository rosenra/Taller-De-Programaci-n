/*
El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen
(con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad
de la comida (2) Precio (3) Ambiente.
Escriba un programa que lea desde teclado las calificaciones de los cinco clientes
para cada uno de los aspectos y almacene la información en una estructura. Luego
imprima la calificación promedio obtenida por cada aspecto.
 */
package practica1;
import PaqueteLectura.*;
/**
 *
 * @author rocio
 */
public class ej5 {
    public static void main (String [] args){
       GeneradorAleatorio.iniciar ();
       int dimClientes = 5;//columna
       int dimCategorias =4;//fila
       int [][] restaurante = new int [dimClientes][dimCategorias];
       int i,j;
       for (i=0;i<dimClientes;i++){
           for (j=0; j<dimCategorias;j++){
               //System.out.println ("clasifique la categoria: "+j);
               restaurante [i][j]= GeneradorAleatorio.generarInt (10)+1;//o generarDouble?
           }
       }
       for (i=0;i<dimClientes;i++){
           System.out.println ("");
           System.out.println ("cliente: "+i);
           for (j=0; j<dimCategorias;j++){
               System.out.print (restaurante[i][j]+"|");
           }
    }
       double [] promedio = new double[dimCategorias];
       for (j=0;j<dimCategorias;j++){//promedio de cada categoria no de cliente!!!
           double prom=0;
           for (i=0;i<dimClientes; i++){
               prom+= restaurante [i][j];
           }
           promedio[j]=prom/dimClientes;
       }
       for (j=0;j<dimCategorias;j++){
           System.out.println ("la categoria: "+j+" tiene una calificacion promedio de: "+promedio[j]);
       }
}
}
