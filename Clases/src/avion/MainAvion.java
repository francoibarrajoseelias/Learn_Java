
package avion;

public class MainAvion {

    public static void main(String[] args) {
        /*
        Aeropuerto ae1 = new Aeropuerto("Alcantari","Bolivia","Junin",34, 20000, 2019);
        System.out.println( ae1); 
        
        Direccion direccion1 = new Direccion("Argentina", "velez", 365);
  
        Aeropuerto ae2 = new Aeropuerto("Belgrano",direccion1, 35000, 2019);
        System.out.println( ae2 );
       
        Aeropuerto ae3 = new Aeropuerto();
        System.out.println(ae3);
        
        
        /* Probando el metodo equals 
       if( ae1.equals(ae2) ){ 
           System.out.println("Son iguales");
       }else{
           System.out.println("No Son iguales");
       }
        */
       
       /* Probando el metodo compareTo 
       switch(ae1.compareTo(ae2)){
           case 1: System.out.println("Es el mayor"); break;
           case -1: System.out.println("Es el menor"); break;
           case 0: System.out.println("SOn iguales"); break;
       }
       */
        Direccion direccion1 = new Direccion("Argentina", "velez", 365);
        System.out.println("Aeropueto Publico con datos");
        Aeropuerto aPublico2 = new AeropuertoPublico(2000000, 50, "Belgrano",direccion1, 35000, 2019);
        System.out.println(aPublico2);
        System.out.println("Aeropueto Privado con datos");
        Aeropuerto aPrivado = new AeropuertoPrivado(50, "Belgrano",direccion1, 35000, 2019);
        System.out.println(aPrivado);
    }
    
}

