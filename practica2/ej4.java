/*
Sobre un nuevo programa, modifique el ejercicio anterior para considerar que:
a) Durante el proceso de inscripción se pida a cada persona sus datos (nombre, DNI, edad)
y el día en que se quiere presentar al casting. La persona debe ser inscripta en ese día, en el
siguiente turno disponible. En caso de no existir un turno en ese día, informe la situación.
La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos de
casting.
Una vez finalizada la inscripción:
b) Informar para cada día: la cantidad de inscriptos al casting ese día y el nombre de la
persona a entrevistar en cada turno asignado.
 */
package practica2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author rocio
 */
public class ej4 {
     public static void main (String [] args){
        GeneradorAleatorio.iniciar();  
        int dias =5;
        int entrevistasXDia = 8;
        int entrevistados =0;
        Persona [][] casting = new Persona [dias][entrevistasXDia];
        int [] vector = new int[dias];// saber cant de entrevistados en el dia
        int aux=0;
        int i;
        for (i=0; i<dias; i++)
            vector[i]=0;
        String nom = GeneradorAleatorio.generarString(3);
        while ((!nom.equals("ZZZ"))&& ((dias*entrevistasXDia)>entrevistados)){
            System.out.println ("\nelija un dia");
            aux= Lector.leerInt();
            if ((vector[aux]<entrevistasXDia)){
            casting[aux][vector[aux]++]= new Persona(nom,GeneradorAleatorio.generarInt(6), GeneradorAleatorio.generarInt(100));
            entrevistados++;
            }else
                System.out.print("no hay turnos disponibles para ese dia");
            nom= Lector.leerString();
            //nom =GeneradorAleatorio.generarString(3);//nom= Lector.leerString();
        }
        for (i=0; i<dias; i++){
            for (int j=0; j<vector[i];j++){
                System.out.println("dia "+i+" entrevista "+j+" "+casting[i][j].getNombre());
            }
        }
        
    }
  
    
}
