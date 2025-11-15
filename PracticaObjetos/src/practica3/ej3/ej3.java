/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3.ej3;
import PaqueteLectura.*;
import practica3.Autor;
import practica3.Estanteria;
import practica3.Libro;
/**
 *
 * @author alumnos
 */
public class ej3 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Estanteria estante1= new Estanteria();// le paso dimF como parametro
        for(int i=0;i<20;i++){
            Autor unAutor= new Autor (GeneradorAleatorio.generarString(3),GeneradorAleatorio.generarString(3),GeneradorAleatorio.generarString(3));
            //System.out.println(unAutor.toString());
            Libro unLibro= new Libro (Lector.leerString(),  GeneradorAleatorio.generarString(6), unAutor, GeneradorAleatorio.generarString(5));
            estante1.agregarL(unLibro);
        }
        System.out.println(estante1.getCantLibros());
        System.out.println(estante1.lleno());
        System.out.println(estante1.devolverTitulo("mujercitas").getPrimerAutor().getNombre());
    }
}


