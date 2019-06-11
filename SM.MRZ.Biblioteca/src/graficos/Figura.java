/**
 *
 * @author Montserrat Rodríguez Zamorano
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;

public abstract class Figura {
    private Color trazo = Color.BLACK;
    private Stroke stroke;
    private boolean alisado;
    private Point2D puntoOrigen, puntoFinal = new Point(-1000, -1000);
    
    public Figura(Point2D pO, Point2D pF, Color trazo, Stroke stroke, boolean alisado){
        this.trazo = trazo;
        this.stroke = stroke;
        this.alisado = alisado;
        puntoOrigen = pO;
        puntoFinal = pF;
    }
    
    /**
    * Setter.
    * @param trazo color de la línea
    */
    public void setColor(Color trazo){
        this.trazo = trazo;
    }
    /**
    * Setter.
    * @param stroke trazo de la línea
    */
    public void setStroke(Stroke stroke){
        this.stroke = stroke;
    }
    /**
    * Getter.
    * @return color de la línea
     */
    public Color getColor(){
        return trazo;
    }
    /**
    * Getter.
    * @return trazo de la línea
     */
    public Stroke getStroke(){
        return stroke;
    }
    
    /**
     * Setter.
     * @param alisado establece si los bordes se alisan o no
     */
    public void setAlisado(boolean alisado){
        this.alisado = alisado;
    }
    
    /**
     * Getter.
     * @return alisado indica si los bordes se alisan o no
     */
    public boolean getAlisado(){
        return alisado;
    }
    
    //métodos abstractos
    abstract public void setLocation(Point2D p);
    abstract public void updateShape(Point2D puntoOrigen, Point2D puntoFinal);
    abstract public void paint(Graphics2D g);
}
