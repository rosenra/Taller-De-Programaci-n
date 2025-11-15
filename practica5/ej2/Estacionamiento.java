/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5.ej2;

/**
 *
 * @author rocio
 */
public class Estacionamiento {
    private String nombre;
    private String direccion;
    private int horaApertura;
    private int horaCierre;
    private int cantPisos;
    private int cantPlazas;
    private Auto [][] autos;
    
    public Estacionamiento(String nom, String dir){
        this.nombre = nom;
        this.direccion = dir;
        this.horaApertura = 8;
        this.horaCierre = 21;
        this.cantPisos = 5;
        this.cantPlazas = 10;
        this.autos = new Auto[cantPisos][cantPlazas];
        this.inicializarMatrizAutos(cantPisos, cantPlazas);
    }
    
    public Estacionamiento(String nom, String dir, int apertura, int cierre, int nropiso, int nroplazas){
        this.setNombre(nom);
        this.setDireccion(dir);
        this.setHoraApertura(apertura);
        this.setHoraCierre(cierre);
        this.setCantPisos(nropiso);
        this.setCantPlazas(nroplazas);
        this.autos = new Auto[nropiso][nroplazas];
        this.inicializarMatrizAutos(nropiso, nroplazas);
    }
    public void inicializarMatrizAutos(int pisos,int plazas){
        for(int i=0; i<pisos;i++){
            for(int j=0;j<plazas;j++){
                this.autos[i][j]=null;
            }
        }
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

    public int getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(int horaApertura) {
        this.horaApertura = horaApertura;
    }

    public int getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(int horaCierre) {
        this.horaCierre = horaCierre;
    }

    public int getCantPisos() {
        return cantPisos;
    }

    public void setCantPisos(int cantPisos) {
        this.cantPisos = cantPisos;
    }

    public int getCantPlazas() {
        return cantPlazas;
    }

    public void setCantPlazas(int cantPlazas) {
        this.cantPlazas = cantPlazas;
    }
    public void agregarAuto(Auto a,int p, int m){
        this.autos[p-1][m-1]=a;//hay que restar???
    }
    
    public String buscarPatente (String patente){
        boolean encontrado=false;
        String aux= "auto inexistente";
        int piso=0;
        int plaza=0;
        while ((!encontrado)&&(piso<this.cantPisos)){
          if(this.autos[piso][plaza]!=null && this.autos[piso][plaza].getPatente().equals(patente)){
              aux=" auto encontrado en el piso "+(piso+1)+" plaza "+(plaza+1);//sino puede dar 0!!!
              encontrado = true;
          }
          else{
              plaza++;
              if (plaza == this.cantPlazas){
              plaza=0;
              piso++;
          }
        }
    }
        return aux;
    }
    public String ocupado(){
        String aux = "", cero;
        for(int i=0;i<this.getCantPisos();i++){
            for(int j=0;j<this.getCantPlazas();j++){
                if(this.autos[i][j] == null){
                    cero = "libre";
                }
                else
                    cero = this.autos[i][j].toString();
                aux = aux + " Piso: "+ (i+1) + " Plaza: "+ (j+1) + " | " + cero + " | ";
            }
            aux = aux + "\n";
        }
        return aux;
    }
    public int plazaY(int y){
        int aux=0;
        for (int i=0; i<this.cantPisos;i++){
            if (this.autos[i][y-1]!= null){//asi devuelve bien donde deberia estar la plaza
                aux++;
            }
        }
        return aux;
    }
    
    @Override
    public String toString(){
        String aux="nombre: "+this.getNombre()+" direccion:"+this.getDireccion()+this.ocupado();
        return aux;
    }
}
