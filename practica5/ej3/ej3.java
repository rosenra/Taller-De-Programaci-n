/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5.ej3;
import PaqueteLectura.Lector;
/**
 *
 * @author rocio
 */
public class ej3 {
    public static void main(String[] args) {
        EventoOcasional evo;
        Gira g1;
        Fecha f;
        evo = new EventoOcasional("el Plan",4,"beneficiencia","sebas",12);
        for (int i=0;i<evo.getCantTemas();i++){
            System.out.println("agregue un tema para el ev. ocasional");
            evo.agregarTema(Lector.leerString());
        }
        g1=new Gira("obras","el plan",5,3);
        for (int j=0;j<g1.getCantTemas();j++){
            System.out.println("agregue un tema para la gira");
          g1.agregarTema(Lector.leerString());
    }
        for(int l=0;l<g1.getCantFechas();l++){
            f= new Fecha(Lector.leerString(),Lector.leerInt());
            g1.agregarFecha(f);
        }
        System.out.println(g1.actuar());//no imprime la fecha imprime la direccion"" ej.practica5.ej3
        System.out.println(g1.calcularCosto());
        System.out.println(evo.actuar());
        System.out.println(evo.calcularCosto());
    }
}
