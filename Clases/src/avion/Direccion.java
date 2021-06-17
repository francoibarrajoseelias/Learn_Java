/*
    ----------------- JavaDoc -------------
    JavaDoc nos permite documentar nuestro codigo, para hacer simplemente tenemos que hacef lo siguiente
        /** + Enter             ---> hacemos en encima de la clase y su metodos tambien de los atributos y nos autocompletar con cierto tipo de comentario
               en ahi tenemos q documentar  q es lo q hace en esa parte de codigo.

    Para Generar el JavaDoc nos vamos al proyecto le damos click derecho y nos aparecera un opcion de "Generar JavaDoc" pinchamos ahi y nos
    mostrar un ventana q sera la documentacion de nuestro proyecto en base a lo nosotros comentamos.
*/
package avion;

/**
 * Clase Direccion con diferentes atributos
 * @author Risa
 */
public class Direccion {
    /**
     * Declaracion de Atributos de Direccion.
     */
    private String pais;
    private String calle;
    private int numero;

    public Direccion() {
    }
    /**
     * Creacion del constructor de Direccion.
     * @param pais
     * @param calle
     * @param numero 
     */
    public Direccion(String pais, String calle, int numero) {
        this.pais = pais;
        this.calle = calle;
        this.numero = numero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * toString metodo q muestra todos los datos de la clase.
     * @return 
     */
    @Override
    public String toString() {
        return "pais=" + pais + ", calle=" + calle + ", numero=" + numero + ' ';
    }

  
   
    
}
