/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author rocio
 */
public class ej3 {
    
    public static void main(String[] args) {
	 
        System.out.println ("inicio");
        
        GeneradorAleatorio.iniciar ();  //Paso 2. iniciar el generador aleatorio
          int dim = 5;
	 int [][] matriz = new int [dim][dim];// 5 puede ser una var dim
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
         int i,j;// i= fila, j columna
        //Paso 4. mostrar el contenido de la matriz en consola
        for (i=0; i<dim; i++){
            for (j=0;j<dim; j++){
                matriz [i][j]= GeneradorAleatorio.generarInt(31);
            }
        }
        for (i=0; i<dim;i++) {
          System.out.println ("");
          for (j=0;j<dim;j++){
              System.out.print (matriz[i][j]+"|");
          }
        }
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        int sumaFila =0;
        for (j=0; j< dim; j++){
            sumaFila += matriz [1][j];
        }
        System.out.println ("");
        System.out.println ("la suma de la fila 1 es: "+sumaFila);
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        int [] vector = new int [dim];//        Luego, imprima el vector.
        for (j=0; j<dim; j++){
            int sumaColumna= 0;// se vuelve a crear???
            for (i=0;i<dim; i++) {
                sumaColumna += matriz [i][j];
            }
           vector [j]=sumaColumna;
        }
        for (j=0; j<5; j++){
            System.out.println ("la suma de la columna: "+j+" es: "+vector[j]);
        }
        System.out.println ("ingrese un valor a buscar");
        int valor = Lector.leerInt();
        int a,b;
        a=0;
        b=0;
        boolean encontre=false;
        while ((a <dim)&& (!encontre)){
            b=0;
            while ((b<dim)&& (!encontre)){
                if (matriz[a][b] == valor){
                  encontre = true;
                }
                b++;
            }
           
            a++;
        }
        if (encontre){
            System.out.println ("Se encontro el valor en la fila: "+a+" columna: "+b);
        }
        else System.out.println (" el valor no se encontro");
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".
    }
    
}

