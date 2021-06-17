
package avion;
/*
    Una clase solo puede tener un padre, no se permite un clase padre
*/
public class AeropuertoPublico extends Aeropuerto{
    private double financiacion;
    private int numTrabajadoresDiscapacitados;

    public AeropuertoPublico() {
        super();
    }

    public AeropuertoPublico(double financiacion, int numTrabajadoresDiscapacitados, String nombre, Direccion direccion, int capacidad, int anioInaguracion) {
        super(nombre, direccion, capacidad, anioInaguracion);
        this.financiacion = financiacion;
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    public AeropuertoPublico(double financiacion, int numTrabajadoresDiscapacitados, String nombre, String pais, String calle, int numero, int capacidad, int anioInaguracion) {
        super(nombre, pais, calle, numero, capacidad, anioInaguracion);
        this.financiacion = financiacion;
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    public double getFinanciacion() {
        return financiacion;
    }

    public void setFinanciacion(double financiacion) {
        this.financiacion = financiacion;
    }

    public int getNumTrabajadoresDiscapacitados() {
        return numTrabajadoresDiscapacitados;
    }

    public void setNumTrabajadoresDiscapacitados(int numTrabajadoresDiscapacitados) {
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "El aeropuerto es publico y tiene un financiacion de "+ this.financiacion + " y cuenta con " + this.numTrabajadoresDiscapacitados + " trabajadores";
    }

    @Override
    public void ganancias(double cantidad) {
        double ganancia = cantidad + this.financiacion + this.numTrabajadoresDiscapacitados*100;
        System.out.println("La cantidad ganada es: "+ganancia);
    }

    
    
    
}
