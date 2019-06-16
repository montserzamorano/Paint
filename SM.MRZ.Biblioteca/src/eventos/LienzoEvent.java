/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */
package eventos;

import graficos.Figura;
import java.awt.Color;
import java.util.EventObject;

public class LienzoEvent extends EventObject{
    private Figura forma;
    private Color color;
    
    public LienzoEvent(Object source, Figura forma, Color color) {
        super(source);
        this.forma = forma;
        this.color = color;
    }
    
    public Figura getForma(){
        return forma;
    }
    
    public Color getColor(){
        return color;
    }
    
}
