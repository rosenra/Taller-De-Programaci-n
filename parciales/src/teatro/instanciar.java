/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teatro;

/**
 *
 * @author rocio
 */
public class instanciar {
    public static void main(String[] args) {
        funcion f= new funcion("navidad","25 diciembre",20,2,2);
        System.out.println("precio de la butaca: $"+f.ocuparButacaBF(1, 2));
        f.desocuparF(1);
        System.out.println(f.butacaB(2));
        System.out.println(f.toString());
    }
}
