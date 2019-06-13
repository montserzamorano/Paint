/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 14.06.2019
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;

public abstract class Figura {
    private Color trazo = Color.BLACK;
    private Stroke stroke;
    private boolean alisado;
    private Point2D puntoOrigen, puntoFinal = new Point(-1000, -1000);
    private float transparencia = 1.0f;
    
    public Figura(Point2D pO, Point2D pF, Color trazo, Stroke stroke, float transparencia, boolean alisado){
        this.trazo = trazo;
        this.stroke = stroke;
        this.alisado = alisado;
        this.transparencia = transparencia;
        puntoOrigen = pO;
        puntoFinal = pF;
    }
    
    public Point2D getPO(){return puntoOrigen;}
    public Point2D getPF(){return puntoFinal;}
    
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
    
    /**
    * Setter.
    * @param transparencia color de relleno de la figura
    */
    public void setTransparencia(float transparencia){
        this.transparencia=transparencia;
    }
    /**
    * Getter.
    * @return transparencia grado de transparencia del relleno
    */
    public float getTransparencia(){return transparencia;}
    
    /**
     * Cambia la posición de una figura. Método abstracto. 
     * @param p 
     */
    abstract public void setLocation(Point2D p);
    /**
     * Actualiza una figura. Método abstracto.
     * @param puntoOrigen
     * @param puntoFinal 
     */
    abstract public void updateShape(Point2D puntoOrigen, Point2D puntoFinal);
    /**
     * Dibuja una figura.
     * @param g 
     */
    public void paint(Graphics2D g){
        Graphics2D g2d = (Graphics2D) g;
        //color de trazo
        g2d.setColor(trazo);
        //alisado
        if(alisado){
            RenderingHints render;
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHints(render);
        }
        //linea
        g2d.setStroke(stroke);
    }
    
}
