package eventos;

import graficos.Figura;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.EventObject;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

//https://www.javaworld.com/article/2077333/mr-happy-object-teaches-custom-events.html

public class LienzoEvent extends EventObject{
    private Figura figura;
    private Color color;
    private Point2D posicion;
    
    public LienzoEvent(Object source, Figura figura, Color color, Point2D posicion) {
        super(source);
        this.figura = figura;
        this.color = color;
        this.posicion = posicion;
    }
    
    public Figura getFigura(){
        return figura;
    }
    
    public Color getColor(){
        return color;
    }
    
    public Point2D getPosicion(){
        return posicion;
    }
    
}
