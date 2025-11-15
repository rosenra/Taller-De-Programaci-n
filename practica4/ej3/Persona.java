package practica4.ej3;

/**
 *
 * @author rocio
 */
public class Persona {
   private String nombre;
   private  int dni;
   private int edad;
   
   public Persona (String unNombre,int unDni, int unaEdad){
       this.setNombre(unNombre);
       this.setDni(unDni);
       this.setEdad(unaEdad);
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
   @Override
    public String toString(){
        return "Mi nombre es "+this.getNombre()+"mi DNI es "+this.getDni()+" tengo "+this.getEdad()+" años";
    }
   
}
