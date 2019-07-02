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
 * Clase Figura. Representa una figura.
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
    /**
     * Constructor de clase. Permite crear una figura.
     * @param pO Point2D punto de inicio
     * @param pF Point2D punto final
     * @param trazo Color color de trazo
     * @param stroke TipoLinea tipo de línea
     * @param grosor int grosor de la línea
     * @param transparencia float nivel de transparencia
     * @param alisado boolean activado/desactivado del alisado
     */
    public Figura(Point2D pO, Point2D pF, Color trazo, TipoLinea stroke, int grosor, float transparencia, boolean alisado){
        this.trazo = trazo;
        this.stroke = stroke;
        this.alisado = alisado;
        this.transparencia = transparencia;
        puntoOrigen = pO;
        puntoFinal = pF;
        this.grosor = grosor;
    }
    /**
     * Getter. Devuelve el punto de origen de la figura.
     * @return Point2D puntoOrigen
     */
    public Point2D getPO(){return puntoOrigen;}
    /**
     * Getter. Devuelve el punto final de la figura.
     * @return Point2D puntoFinal
     */
    public Point2D getPF(){return puntoFinal;}
    /**
     * Setter. Establece el punto de origen de la figura.
     * @param p Point2D nuevo punto de origen
     */
    public void setPO(Point2D p){puntoOrigen = p;}
    /**
     * Setter. Establece el punto final de la figura.
     * @param p Point2D nuevo punto final
     */
    public void setPF(Point2D p){puntoFinal=p;}
    /**
     * Getter. Devuelve el grosor del trazo de la figura.
     * @return int grosor
     */
    public int getGrosor(){return grosor;}
    /**
     * Setter. Establece el grosor del trazo de la figura.
     * @param grosor int nuevo grosor de la figura
     */
    public void setGrosor(int grosor){this.grosor = grosor;}
    
    /**
    * Setter. Establece el color del trazo de la figura.
    * @param trazo Color color de la línea
    */
    public void setColor(Color trazo){
        this.trazo = trazo;
    }
    /**
    * Setter. Establece el tipo del línea de la figura.
    * @param stroke TipoLinea trazo de la línea
    */
    public void setStroke(TipoLinea stroke){
        this.stroke = stroke;
    }
    /**
    * Getter. Devuelve el color de la línea de la figura.
    * @return Color color de la línea
     */
    public Color getColor(){
        return trazo;
    }
    /**
    * Getter. Devuelve el tipo de línea de la figura
    * @return TipoLinea tipo de trazo de la línea
     */
    public TipoLinea getStroke(){
        return stroke;
    }
    
    /**
     * Setter. Activa/Desactiva el alisado de bordes
     * @param alisado boolean true para alisado, false en caso contrario
     */
    public void setAlisado(boolean alisado){
        this.alisado = alisado;
    }
    
    /**
     * Getter. Devuelve si el alisado de bordes está activado o no.
     * @return alisado boolean true si alisado activado, false en caso contrario
     */
    public boolean getAlisado(){
        return alisado;
    }
    
    /**
    * Setter. Establece el grado de transparencia de la figura.
    * @param transparencia float nuevo grado de transparencia
    */
    public void setTransparencia(float transparencia){
        this.transparencia=transparencia;
    }
    /**
    * Getter. Devuelve el nivel de transparencia de la figura.
    * @return transparencia float grado de transparencia
    */
    public float getTransparencia(){return transparencia;}
    
    /**
     * Cambia la posición de una figura. Método abstracto. 
     * @param p Point2D nuevo punto de origen
     */
    abstract public void setLocation(Point2D p);
    /**
     * Actualiza una figura. Método abstracto.
     * @param puntoOrigen Point2D punto de origen en la figura
     * @param puntoFinal Point2D punto final de la figura
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
