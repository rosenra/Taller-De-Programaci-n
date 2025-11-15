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
public class producto {
    private int codigo;
    private String nombre;
    private String marca;
    private int unidades;
    private double precioUnitario;
    
    public producto (int cod,String nom,String unaMarca,int uni,double precioU){
        this.setCodigo(cod);
        this.setNombre(nom);
        this.setMarca(unaMarca);
        this.setUnidades(uni);
        this.setPrecioUnitario(precioU);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public String toString(){
        return "codigo:"+this.codigo+" nombre: "+this.nombre+" marca: "+this.marca+" cantidad de unidades: "+this.unidades+" precio unitario: "+this.precioUnitario;
    }
     
}
