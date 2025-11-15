/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toneoAjedrez;

/**
 *
 * @author rocio
 */
public class instanciar {
    public static void main(String[] args) {
         amateur a1=new amateur("amateur1","direccion1");
         infoProfesional if1= new infoProfesional ("info1","25 dic",200,100);
         infoProfesional if2= new infoProfesional ("info2","23 dic",300,150);
         profesional p1= new profesional(3,"profesional1","dir2");
         p1.registrarTorneoProfesional(if1);
         p1.registrarTorneoProfesional(if2);
         a1.registrarTorneoAmateur(4);
         System.out.println("cotizacion profesional: "+p1.cotizarSitio());
         System.out.println("cotizacion amateur: "+a1.cotizarSitio());
         System.out.println(a1.toString());
         System.out.println(p1.toString());
    }
    
}
