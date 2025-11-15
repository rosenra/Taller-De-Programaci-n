/*
Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.
a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
40 cupos de casting.
Una vez finalizada la inscripción:
b) Informar para cada día y turno asignado, el nombre de la persona a entrevistar.
NOTA: utilizar la clase Persona. Pensar en la estructura de datos a utilizar. Para comparar
Strings use el método equals.
 */
package practica2;
import PaqueteLectura.GeneradorAleatorio;
//import PaqueteLectura.Lector;
/**
 *
 * @author rocio
 */
public class ej3 {
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
            casting[aux][vector[aux]++]= new Persona(nom,GeneradorAleatorio.generarInt(6), GeneradorAleatorio.generarInt(100));
            if ((vector[aux]==entrevistasXDia)&& (aux< (dias-1)))//8 dias max de 0-7
             aux++;// cambio de dia
            entrevistados++;
            nom =GeneradorAleatorio.generarString(3);//nom= Lector.leerString();
        }
        for (i=0; i<dias; i++){
            for (int j=0; j<vector[i];j++){
                System.out.println("dia "+i+" entrevista "+j+" "+casting[i][j].getNombre());
            }
        }
        
    }
  
}
