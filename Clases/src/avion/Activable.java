
package avion;
/*
las interfaces tiene metodos abstractos aunque no se los indique y esto siempre tienen q ser publicos

*/
/**
 * Interface con metodos, estos deben ser siempre publicos.
 * @author Risa
 */
public interface Activable {
    
    public boolean isActivado();
    
    public void setActivado(boolean value);
}
