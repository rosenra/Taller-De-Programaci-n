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
public class funcion {
    private String titulo;
    private String fecha;
    private int hora;
    private butaca [][] matriz;
    private int cantFila;
    private int cantColum;
    
    public funcion(String tit,String f,int h,int n,int m){
        this.titulo=tit;
        this.fecha=f;
        this.hora=h;
        this.cantFila=n;
        this.cantColum=m;
        this.matriz= new butaca[this.cantFila][this.cantColum];
        this.inicializarMatriz();//!!!!
    }

    public String getTitulo() {
        return titulo;
    }

    public int getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }
    
    private void inicializarMatriz(){
        for(int i=0;i<this.cantFila;i++){
            for (int j=0;j<this.cantColum;j++){
                this.matriz[i][j]= new butaca(i+1,j+1);//!!!!
            }
        }
    }
    public double ocuparButacaBF(int b,int f){
       if ( this.matriz[f-1][b-1].isLibre()){//!= o equals??
           this.matriz[f-1][b-1].ocupar(true);
           return this.matriz[f-1][b-1].getPrecio();
       }else
           return 0;
      
    }
    public void desocuparF (int f){
        for (int j=0;j< this.cantColum;j++){
            this.matriz[f-1][j].ocupar(false);
        }
    }
    public String butacaB(int b){
        String aux=" ";
        for (int i=0;i<this.cantFila;i++){
            aux+=matriz[i][b-1].toString()+"\n";
        }
        return aux;
    }
    public String toString(){
        String aux=" titulo: "+this.getTitulo()+ " fecha: "+this.getFecha()+" hora: "+this.getHora()+"hs"+"\n";
        for (int i=0;i<this.cantFila;i++){
            for(int j=0;j<this.cantColum;j++){
                aux+= this.matriz[i][j].toString()+"\n";
            }
        }
        return aux;
    }
}
