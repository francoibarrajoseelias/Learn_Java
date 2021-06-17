
package avion;


public class AeropuertoPrivado extends Aeropuerto{
    private int numSocios;

    public AeropuertoPrivado() {
        super();
    }

    public AeropuertoPrivado(int numSocios, String nombre, Direccion direccion, int capacidad, int anioInaguracion) {
        super(nombre, direccion, capacidad, anioInaguracion);
        this.numSocios = numSocios;
    }

    public AeropuertoPrivado(int numSocios, String nombre, String pais, String calle, int numero, int capacidad, int anioInaguracion) {
        super(nombre, pais, calle, numero, capacidad, anioInaguracion);
        this.numSocios = numSocios;
    }

    public int getNumSocios() {
        return numSocios;
    }

    public void setNumSocios(int numSocios) {
        this.numSocios = numSocios;
    }

    @Override
    public String toString() {
        return super.toString() + "El aeropuerto es privado y cuenta con " + this.numSocios + " socios";
    }

    @Override
    public void ganancias(double cantidad) {
        double ganancias = cantidad/this.numSocios;
        System.out.println("La cantidad gananda de cada socio es: "+ganancias);
    }
    
    
    
    
}
