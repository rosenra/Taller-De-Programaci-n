/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.ej3;
import PaqueteLectura.*;
/**
 *
 * @author rocio
 */
public class ej3 {
    public static void main(String[] args) {
        Persona persona1;
        Trabajadores trabajador1;
        trabajador1= new Trabajadores("Pablo",46268547,78,"jardinero");
        persona1= new Persona("juan",46268702,64);
        System.out.println(persona1.toString());
        System.out.println(trabajador1.toString());
    }
}
