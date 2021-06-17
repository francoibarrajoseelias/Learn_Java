
package avion;
/**
 * Poliformismo, pruebas, mostrando los aviones q estan activados.
 * @author Risa
 */
public class Polimorfismo {
    public static void main(String[] args) {
        Direccion direccion1 = new Direccion("Argentina", "velez", 365);
        
        //Aeropuerto a = new Aeropuerto("Viru Viru", direccion1, 200,20000 );
        
        AeropuertoPrivado aP = new AeropuertoPrivado(30, "Alcantari", direccion1, 200,20000 );
        
        //AeropuertoPrivado aPri = new AeropuertoPrivado(5, "Privado state", direccion1, 200,20000 );
        
        Avion a = new Avion("mx",20,40000);
        Avion a2 = new Avion("Falcon",60,900000);
        Avion a3 = new Avion("spunik",10,2000);
        aP.aniadirAviones(a);
        aP.aniadirAviones(a2);
        aP.aniadirAviones(a3);
        
        a.setActivado(true);
        a2.setActivado(true);
        System.out.println(aP);
        
    }
}
