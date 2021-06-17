 
package avion;
/*
    Una clase pueden implementar un monton de interfaces
*/
/**
 * Clase Avion
 * @author Elias Franco
 */
public class Avion implements Activable{
    
    private String modelo;
    private int nAsientos; 
    private double velocidadMaxima;
    private boolean activado;
    
    public Avion() {
         this("",0,0);
    }
    
    public Avion(String modelo, int nAsientos, double velocidadMaxima){
        this.modelo = modelo;
        this.nAsientos = nAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.activado=false;
    }
    
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getnAsientos() {
        return nAsientos;
    }

    public void setnAsientos(int nAsientos) {
        this.nAsientos = nAsientos;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

   
    
    
    /*
    public static void main(String[] args) {
        
        Avion tam = new Avion();
        tam.setModelo("mx-2021");
        System.out.println("El modelo del avion tam es: "+tam.getModelo());
    }
    */

    @Override
    public String toString() {
        return "\n Avion " + "modelo = " + modelo + ", nAsientos = " + nAsientos + ", velocidadMaxima = " + velocidadMaxima + '\n';
    }

    @Override
    public boolean isActivado() {
        return this.activado;
    }

    @Override
    public void setActivado(boolean value) {
        this.activado = value;
    }
}
