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
public class superm {
    private String nombre;
    private String direccion;
    private int maxGondolas;
    private int maxEstantes;
    private producto [][] matriz;
    private int gondolaActual=0;
    private int estanteActual=0;
    
    public superm(String nom,String dir,int cantG,int cantE){
        this.setNombre(nom);
        this.setDireccion(dir);
        this.setMaxGondolas(cantG);
        this.setMaxEstantes(cantE);
        matriz= new producto[cantG][cantE];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setMaxGondolas(int maxGondolas) {
        this.maxGondolas = maxGondolas;
    }

    public int getMaxGondolas() {
        return maxGondolas;
    }


    public int getMaxEstantes() {
        return maxEstantes;
    }

    public void setMaxEstantes(int maxEstantes) {
        this.maxEstantes = maxEstantes;
    }
    //dado que todos los productos se agregan en orden secuencial no es necesario inicializar la matriz
    public void agregarProducto(producto P){
        if (this.gondolaActual<this.maxGondolas){
        if (this.estanteActual<this.maxEstantes){
            matriz[this.gondolaActual][this.estanteActual++]=P;
        }
        else{
           gondolaActual++;
           estanteActual=0;
           if (this.gondolaActual<this.maxGondolas){
           matriz[this.gondolaActual][this.estanteActual++]=P;}
          }
        }
    }
    public String marcaMgondolaX(int x,String m){
        String aux=" ";
            for(int j=0;j<this.maxEstantes;j++){
                if (matriz[x][j] !=null && matriz[x][j].getMarca().equals(m)){
                    aux+=matriz[x][j].toString();
            }
        }
     return aux;
    }
    
    public int gondolaMax(){
        int max=-1;
        int gonMax=-1;
        for(int i=0;i<this.maxGondolas;i++){
            int suma=0;
            for(int j=0;j<this.maxEstantes;j++){
                suma+= this.matriz[i][j].getUnidades();
            }
            if (suma>max){
                max=suma;
                gonMax=i;
            }
        }
        return gonMax;
    }
    
    public String toString(){
        String aux="Supermercado: "+this.nombre+" direccion: "+this.direccion+"\n";
        for(int i=0;i<this.maxGondolas;i++){
            aux+=" gondola:"+(i+1)+"\n";
            for(int j=0;j<this.maxEstantes;j++){
                aux+= "estante:"+(j+1)+this.matriz[i][j].toString();
            }
        }
        return aux;
    }
}
