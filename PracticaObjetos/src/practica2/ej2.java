/*
Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta
obtener edad 0. Luego de almacenar la información:
- Informe la cantidad de personas mayores de 65 años.
- Muestre la representación de la persona con menor DNI.
 */
package practica2;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author rocio
 */
public class ej2 {
    public static void main (String [] args){
        GeneradorAleatorio.iniciar();
        int dimF=15;
        Persona [] vector = new Persona [dimF]; 
        int i=0;
        int edad= GeneradorAleatorio.generarInt (100);
        while ((i< dimF) && (edad !=0)) {
            String nom = GeneradorAleatorio.generarString (10);
            int dni= GeneradorAleatorio.generarInt (9);
            vector [i] = new Persona (nom,dni,edad);
            edad = GeneradorAleatorio.generarInt (100);
            i++;
        }
        i=0;
        while ((i<dimF) && (vector[i]!= null)){
            System.out.println (vector[i].toString());
            i++;
        }
        i=0;
        int mayores, menor;
        mayores=0;
        menor = 9999;
        Persona min = null;
        while ((i<dimF) && (vector[i]!= null)){
            if (vector[i].getEdad () > 65)
                mayores++;
            if (vector[i].getDNI()<menor){
                menor = vector[i].getEdad();
                min= vector[i];// se queda con la ultima persona con menor dni, pq???
            }
            i++;
        }
        System.out.println("la cantidad de personas mayores a 65 es: "+mayores);
        System.out.print("la persona con menor dni es:"+min.toString());
    }
}

