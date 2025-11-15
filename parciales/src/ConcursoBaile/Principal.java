/*
1)Representar un concurso de baile.El concurso tiene a lo sumo N parejas.
Cada pareja tiene 2 participantes y un estilo de baile.
De los participantes se sabe: nombre,dni y edad.
a) Genere las clases necesarias.Provea constructores para iniciar: el concurso para un maximo de N parejas
(inicialmente sin parejas cargadas); las parejas y los participantes a partir de toda su informacion.
b)Implemente metodos en las clases adecuadas para permitir:
 -Agregar una pareja al concurso.Asuma que hay lugar
 -Obtener la diferencia de edad de la pareja
 -Obtener la pareja con mas diferencia de edad del concurso

2) Realize un programa que instancie un concurso,cargue dos parejas
y apartir del concurso muestre: los nombres de los participantes de la pareja con mas diferencia de edad.
 */
package ConcursoBaile;

/**
 *
 * @author rocio
 */
public class Principal { 
    public static void main (String[] args) {
        concurso concurso1 = new concurso (4);
        
        participante p1 = new participante ("PrimerParticipante", 45,000);
        participante p2 = new participante ("SegundoParticipante",42,020);
        pareja pareja1 = new pareja ("unEstiloBaile",p1,p2);
        concurso1.agregarPareja(pareja1);
        
        participante p3 = new participante ("TercerParticipante", 32, 111);
        participante p4 = new participante ("CuartoParticipante",24, 555);
        pareja pareja2 = new pareja ("unEstiloBaile",p3,p4);
        concurso1.agregarPareja(pareja2);
        System.out.println(concurso1.toString());
        pareja parejaMaxima = concurso1.masDifDeEdad();
        System.out.println("la pareja con mas diferencia de edad es:"+parejaMaxima.toString());
    }
}
