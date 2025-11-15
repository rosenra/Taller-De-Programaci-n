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
public abstract class sitio {
    private String nombre;
    private String direccion;
    private int cantUsuarios;
    
    public sitio (String nom,String dir){
        this.nombre=nom;
        this.direccion=dir;
        this.cantUsuarios=0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCantUsuarios() {
        return cantUsuarios;
    }
    public abstract double cotizarSitio();
    public String toString(){
        return "nombre: "+this.getNombre()+" direccion: "+this.getDireccion()+" cantidad de usuarios "+ this.getCantUsuarios()+this.cotizarSitio();
    }
}
