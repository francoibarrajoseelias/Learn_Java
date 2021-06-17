package avion;

import java.util.Calendar;
/*
Las clases abstractas no se puede instanciar pero si puede ser padres de otras clase, las clases hijas utilizan todos los metodos y atributos de la
clase padre abstracta.
Los metodos se pueden utilizar con esta o se pueden sobreescribir.
Si queremos q las hijas implementen un metodo obligatoriamente y q este no este desarrollado en el padre, hacemos lo siguiente en la clase abstracta padre
    public abstract void nombre_metodo( parametros );   --> Pueden devolver enteros string incluso no puedo devolver nada
    Ejemplo:
        public abstract void ganancias(double cantidad);
    Este metodo se desarrollara en las clase q herede de la clase padre.

*/

/**
 * Clase Aeropuerto representa un aeropuerto
 * @author Risa
 */
public abstract class Aeropuerto implements Comparable<Aeropuerto> {
    private static int id_autonumerico=1;
    private final int MAX_AVIONES = 20;

    private int id;
    private String nombre;
    private Direccion direccion;
    private int capacidad;
    private int anioInaguracion;
    private Avion[] aviones;
    private int numAviones;

    /**
     * Constructor Vacio
     */
    
    public Aeropuerto() {
        this("", "", "", 0, 0, 0);
    }

    /**
     * Contructor con parametros y un objeto direccion
     * @param nombre
     * @param direccion
     * @param capacidad
     * @param anioInaguracion 
     */
    public Aeropuerto(String nombre, Direccion direccion, int capacidad, int anioInaguracion) {
        this(nombre,
                direccion.getPais(),
                direccion.getCalle(),
                direccion.getNumero(),
                capacidad,
                anioInaguracion);
    }
    /**
     * Constructor completo, se envian todos lo parametros
     * @param nombre
     * @param pais
     * @param calle
     * @param numero
     * @param capacidad
     * @param anioInaguracion 
     */
    public Aeropuerto(String nombre, String pais, String calle, int numero, int capacidad, int anioInaguracion) {
        this.id = id_autonumerico++;
        this.nombre = nombre;
        this.direccion = new Direccion(pais, calle, numero);
        this.capacidad = capacidad;
        this.anioInaguracion = anioInaguracion;
        this.aviones = new Avion[MAX_AVIONES];
        this.numAviones = 0;
    }
/**
 * Devuelve el ID del aeropuerto
 * @return 
 */
    public int getId() {
        return id;
    }

    
    /**
     * Retorno del Nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Modoficacion del Nombre, enviamos un parametro con el q se reemplazara.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAnioInaguracion() {
        return anioInaguracion;
    }

    public void setAnioInaguracion(int anioInaguracion) {
        this.anioInaguracion = anioInaguracion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    /**
     * Obtener el numero de aviones
     * @return 
     */
    public int getNumAviones() {
        return numAviones;
    }
    /**
     * Retorno de los anios de servicios, metodo q no se puede modificar.
     * @return 
     */
    public final int anioDeServicio() {
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        return anioActual - this.anioInaguracion;
    }

    public void aniadirAviones(Avion a){
        if(this.numAviones < this.MAX_AVIONES){
            this.aviones[this.numAviones] = a;
            this.numAviones++;
        }else{
            System.out.println("Ya no puede ingresar mas aviones, lista llena");
        }
    }
    
    /**
     * Metodo q muestra los aviones activos del Aeropuerto.
     * @return 
     */
    private String mostrarAviones(){
        String avionesCadena="";
        for(int i=0; i< this.numAviones; i++){
            if(this.aviones[i].isActivado()){
                avionesCadena+= this.aviones[i].toString()+ "\n";
            }
            
        }
        return avionesCadena;
    }

   /**
    * Metodo abstracto que los hijos deben desarrollar.
    * @param cantidad 
    */
    public abstract void ganancias(double cantidad);
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aeropuerto other = (Aeropuerto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    /**
     * Metodo para comparar cual es el mayor
     * @param t
     * @return 
     */
    @Override
    public int compareTo(Aeropuerto t) {
        if( this.anioInaguracion < t.anioInaguracion ){
            return -1;
        }else if( this.anioInaguracion > t.anioInaguracion ){
            return 1;
        }else{
            return 0;
        }
    }
    
    
    /**
     * Metodo q imprime todos los atributos del Aeropuerto.
     * @return 
     */
    
    @Override
    public String toString() {
        return "nombre=" + nombre + ' '+ "Con el ID " + id + ' ' + direccion.toString() + "capacidad=" + capacidad + ", anioInaguracion=" + anioInaguracion + ' '
                +"\nCuenta con los siguientes aviones " + mostrarAviones()+"\n";
    }

    

}
