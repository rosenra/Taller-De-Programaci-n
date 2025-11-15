/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programadores;

/**
 *
 * @author rocio
 */
public class instanciar {
    public static void main(String[] args) {
         empresa emp1;
         programadorLider PL= new programadorLider("pablo",46250,500.00,150,"cobol",3,2);
         emp1= new empresa("google",PL,4);
         programadores p1=new programadores ("juan",45253,200.00,200,"pascal");
         programadores p2=new programadores ("luna",45253,200.00,201,"pascal");
         programadores p3=new programadores ("rodu",45253,200.00,203,"pascal");
         
         emp1.agregarProgramador(p1);
         emp1.agregarProgramador(p2);
         emp1.agregarProgramador(p3);
         
         emp1.aumentar(3);
         System.out.println(emp1.totalAPagar());
         System.out.println(emp1.toString());
    }
   
}
