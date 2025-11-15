/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

/**
 *
 * @author rocio
 */
public class instancia {
    public static void main(String[] args) {
        superm s;
        producto p1= new producto(10,"hoy","ya",3,2);
        producto p2= new producto(11,"ayer","fue",4,2);
        producto p3= new producto(12,"anteayer","listo",2,2);
        producto p4= new producto(10,"hoy","ya",3,2);
        s= new superm("Toledo","50",2,2);
        s.agregarProducto(p1);
        s.agregarProducto(p2);
        s.agregarProducto(p3);
        s.agregarProducto(p3);
        System.out.println(s.marcaMgondolaX(0, "fue"));
        System.out.println((s.gondolaMax()+1));
        System.out.println(s.toString());
    }
}
