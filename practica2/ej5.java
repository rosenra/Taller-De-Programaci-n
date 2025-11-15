/*
Se dispone de la clase Partido (en la carpeta tema2). Un objeto partido representa un
encuentro entre dos equipos (local y visitante). Un objeto partido puede crearse sin
valores iniciales o enviando en el mensaje de creación el nombre del equipo local, el
nombre del visitante, la cantidad de goles del local y del visitante (en ese orden). Un objeto
partido sabe responder a los siguientes mensajes:
getLocal() retorna el nombre (String) del equipo local
getVisitante() retorna el nombre (String) del equipo visitante
getGolesLocal() retorna la cantidad de goles (int) del equipo local
getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante
setLocal(X) modifica el nombre del equipo local al “String” X
setVisitante(X) modifica el nombre del equipo visitante al “String” X
setGolesLocal(X) modifica la cantidad de goles del equipo local al “int” X
setGolesVisitante(X) modifica la cantidad de goles del equipo visitante al “int” X
hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador
getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna
un String vacío).
hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate
Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en
el campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga:
- Para cada partido, armar e informar una representación String del estilo:
{EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
- Calcular e informar la cantidad de partidos que ganó River.
- Calcular e informar el total de goles que realizó Boca jugando de local
 */
package practica2;
import PaqueteLectura.Lector;

import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author rocio
 */
public class ej5 {
    public static void main (String [] args){
        GeneradorAleatorio.iniciar();
        int dimF=20;
        Partido [] vector = new Partido[dimF];
        int dimL=0;
        System.out.println("ingrese un nombre");
        String nomVisitante= Lector.leerString();// vector de strings??
        while ((!nomVisitante.equals("ZZZ"))&& (dimL <dimF)){
            String nomLocal= Lector.leerString();
            vector[dimL++] = new Partido(nomLocal, nomVisitante , GeneradorAleatorio.generarInt(7), GeneradorAleatorio.generarInt(7));
            nomVisitante= Lector.leerString();
            
        }
        int i;
        int ganadosR,golesB;
        ganadosR=0;
        golesB=0;
        for (i=0; i<dimL;i++){
            System.out.println(vector[i].getLocal()+" "+vector[i].getGolesLocal()+" vs "+vector[i].getVisitante()+" "+vector[i].getGolesVisitante()); 
            if (vector[i].getGanador().equals("River"))
                ganadosR++;
            if (vector[i].getLocal().equals("Boca"))
                golesB+= vector[i].getGolesLocal();
        }
        System.out.println("River gano "+ganadosR+" partidos.Boca hizo "+golesB+" jugando de local");
    }

 
}
