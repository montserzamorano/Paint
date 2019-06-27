package graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public abstract class Figura {
    private Color trazo = null;
    private TipoLinea stroke;
    private boolean alisado;
    private Point2D puntoOrigen, puntoFinal = new Point(-1000, -1000);
    private float transparencia = 1.0f;
    private int grosor = 1;
    
    public Figura(Point2D pO, Point2D pF, Color trazo, TipoLinea stroke, int grosor, float transparencia, boolean alisado){
        this.trazo = trazo;
        this.stroke = stroke;
        this.alisado = alisado;
        this.transparencia = transparencia;
        puntoOrigen = pO;
        puntoFinal = pF;
        this.grosor = grosor;
    }
    
    public Point2D getPO(){return puntoOrigen;}
    public Point2D getPF(){return puntoFinal;}
    public void setPO(Point2D p){puntoOrigen = p;}
    public void setPF(Point2D p){puntoFinal=p;}
    public int getGrosor(){return grosor;}
    public void setGrosor(int grosor){this.grosor = grosor;}
    
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
    public void setStroke(TipoLinea stroke){
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
    public TipoLinea getStroke(){
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
        else{ //esto está bien???
            RenderingHints render;
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            g2d.setRenderingHints(render);
        }
        //linea
        Stroke trazo = null;
        switch(stroke){
            case CONTINUA:
                trazo = new BasicStroke(grosor);
                break;
            case DISCONTINUA: 
                float patronDiscontinuidad[] = {5.0f};
                trazo = new BasicStroke((float) grosor, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, patronDiscontinuidad, 0.0f);
                break;
            case PUNTEADA:
                float patronDiscontinuidadP[] = {(float) grosor, 1.0f};
                trazo = new BasicStroke((float) grosor, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, patronDiscontinuidadP, 0.0f);
                break;
            default:
                break;
        }
        g2d.setStroke(trazo);
    }
    
}
