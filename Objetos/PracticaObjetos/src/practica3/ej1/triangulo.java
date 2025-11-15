/*
1-A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el
tamaño de sus 3 lados (double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)
NOTA: Calcular el área con la fórmula , donde a, b y cÁ𝑟𝑒𝑎 = 𝑠(𝑠 − 𝑎)(𝑠 − 𝑏)(𝑠 − 𝑐)
son los lados y s= = (𝑎+𝑏+𝑐)/2. La función raíz cuadrada es Math.sqrt(#
 */
package practica3;

/**
 *
 * @author rocio
 */
public class triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String borde;
    private String relleno;
    
   public triangulo(double l1,double l2, double l3, String b,String r){
    this.lado1=l1;
    this.lado2=l2;
    this.lado3=l3;
    this.borde= b;
    this.relleno = r ;
}
    public double getLado1 (){
        return lado1;
    }
    public void setLado1(double l1){
        this.lado1=l1;
    }
    public double getLado2 (){
        return lado2;
    }
    public void setLado2(double l2){
        this.lado2=l2;
    }
    public double getLado3(){
        return lado3;
    }
    public void setLado3 (double l3){
        this.lado3=l3;
    }
    public String getBorde (){
        return borde;
    }
    public void setBorde (String b){
        this.borde=b;
    }
    public String getRelleno(){
        return relleno;
    }
    public void setRelleno (String r){
        this.relleno=r;
    }
    public double calcularPerimetro (){
        return this.lado1 + this.lado2 + this.lado3;
    }
    public double calcularArea(){
        double s= (lado1 +lado2+lado3)/2;
        return Math.sqrt (s*(s-lado1)*(s-lado2)*(s-lado3));
    }

}
