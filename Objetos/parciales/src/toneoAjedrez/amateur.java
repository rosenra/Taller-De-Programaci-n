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
public class amateur extends sitio {
    private int cantTorneos;
    private int cantClicks;
    
    public amateur (String nom,String dir){
        super(nom,dir);
        this.cantTorneos=0;
        this.cantClicks=0;
    }

    public int getCantClicks() {
        return cantClicks;
    }

    public int getCantTorneos() {
        return cantTorneos;
    }
    public double cotizarSitio(){
        double cotizacion=(10*this.cantClicks)+(50*this.getCantUsuarios());
        return cotizacion;
    }
    
    public void registrarTorneoAmateur(int c){
        this.cantClicks+=c;
        this.cantTorneos++;
    }
    public String toString(){
        String aux= super.toString()+" cantidad de torneos jugados: "+ this.getCantTorneos()+" cantidad de clicks en publicidad: "+this.getCantClicks();
        return aux;
    }
    
}
