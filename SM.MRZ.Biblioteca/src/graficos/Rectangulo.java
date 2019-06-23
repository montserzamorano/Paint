package graficos;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public class Rectangulo extends FiguraRellenable{
    private Rectangle2D rectangulo;
    
    /**
    * Constructor
     * @param pO
     * @param pF
    * @param trazo
    * @param stroke
     * @param grosor
    * @param relleno
     * @param tr
     * @param deg1
     * @param deg2
     * @param transparencia
     * @param alisado
    */
    public Rectangulo(Point2D pO, Point2D pF, Color trazo, TipoLinea stroke, int grosor,  
            Color relleno, TipoRelleno tr, Color deg1, Color deg2, 
            float transparencia, boolean alisado){
        super(pO, pF,trazo,stroke,grosor,relleno, tr, deg1, deg2, transparencia, alisado);
        rectangulo = new Rectangle2D.Double(pO.getX(), pO.getY(), pF.getX()-pO.getX(), pF.getY()-pO.getY());
        setShape(rectangulo);
    }
    
    @Override
    public void updateShape(Point2D puntoOrigen, Point2D puntoFinal){
        rectangulo.setFrameFromDiagonal(puntoOrigen, puntoFinal);
    }
    
    @Override
    public void setLocation(Point2D p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
