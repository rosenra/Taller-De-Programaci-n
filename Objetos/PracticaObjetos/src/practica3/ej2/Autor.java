/*
Modifique la clase Libro.java (carpeta tema3) para ahora considerar que el primer
autor es un objeto instancia de la clase Autor.
Implemente la clase Autor, sabiendo que se caracterizan por nombre, biografía y origen
y que deben permitir devolver/modificar el valor de sus atributos y devolver una
representación String formada por nombre, biografía y origen.
Luego realice las modificaciones necesarias en la clase Libro
 */
package practica3;

/**
 *
 * @author rocio
 */
public class Autor {
    String nombre;
    String biografia;
    String origen;
    
    public Autor(String nom,String bio,String orig){
        this.nombre=nom;
        this.biografia=bio;
        this.origen= orig;
    }
    public Autor(){
        //otra opcion???
    }


    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nom){
        this.nombre=nom;
    }
    public String getBiografia(){
        return biografia;
    }
    public void setBiografia(String bio){
        this.biografia=bio;
    }
    public String getOrigen(){
        return origen;
    }
    public void setOrigen(String orig){
        this.origen=orig;
    }
    
    @Override
    public String toString(){
        return"nombre " +this.nombre + " biografia "+this.biografia+" Origen "+this.origen;
    }
}
