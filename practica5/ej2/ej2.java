/*
Queremos un sistema para gestionar estacionamientos. Un estacionamiento conoce su
nombre, dirección, hora de apertura, hora de cierre, y almacena para cada número de piso
(1..N) y número de plaza (1..M), el auto que ocupa dicho lugar. De los autos se conoce
nombre del dueño y patente.
a) Genere las clases, incluyendo getters y setters adecuados.
b) Implemente constructores. En particular, para el estacionamiento:
- Un constructor debe recibir nombre y dirección, e iniciar el estacionamiento
con hora de apertura “8:00”, hora de cierre “21:00”, y para 5 pisos y 10 plazas
por piso. El estacionamiento inicialmente no tiene autos.
- Otro constructor debe recibir nombre, dirección, hora de apertura, hora de
cierre, el número de pisos (N) y el número de plazas por piso (M) e iniciar el
estacionamiento con los datos recibidos y sin autos.
c) Implemente métodos para:
- Dado un auto A, un número de piso X y un número de plaza Y, registrar al auto
en el estacionamiento en el lugar X,Y. Suponga que X, Y son válidos (es decir,
están en rango 1..N y 1..M respectivamente) y que el lugar está desocupado.
- Dada una patente, obtener un String que contenga el número de piso y plaza
donde está dicho auto en el estacionamiento. En caso de no encontrarse,
retornar el mensaje “Auto Inexistente”.
- Obtener un String con la representación del estacionamiento. Ejemplo: “Piso 1
Plaza 1: libre Piso 1 Plaza 2: representación del auto …
Piso 2 Plaza 1: libre … etc”
- Dado un número de plaza Y, obtener la cantidad de autos ubicados en dicha
plaza (teniendo en cuenta todos los pisos).
d) Realice un programa que instancie un estacionamiento con 3 pisos y 3 plazas por piso.
Registre 6 autos en el estacionamiento en distintos lugares.
Muestre la representación String del estacionamiento en consola.
Muestre la cantidad de autos ubicados en la plaza 1.
Lea una patente por teclado e informe si dicho auto se encuentra en el estacionamiento
o no. En caso de encontrarse, la información a imprimir es el piso y plaza que ocupa
 */
package practica5.ej2;
import PaqueteLectura.*;
/**
 *
 * @author rocio
 */
public class ej2 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Estacionamiento est= new Estacionamiento("rochas","50y5",8,13,3,3);
        Auto a;
        for (int i=1;i<=3;i++){
            for(int j=1;j<=2;j++){//2 para que instancie 6 autos!!!
                a= new Auto(Lector.leerString(),Lector.leerString());
                est.agregarAuto(a, i, j);
            }
        }
        System.out.println(est.toString());
        System.out.println("ingrese un numero de patente");
        String aux= Lector.leerString();
        System.out.println(est.buscarPatente(aux));
        System.out.println("cant de autos en la plaza 1:"+est.plazaY(1));
    }
}
