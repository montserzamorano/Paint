package graficos;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * Clase Elipse. Representa una elipse y proporciona métodos para su edición.
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public class Elipse extends FiguraRellenable{
    private Ellipse2D elipse;
    
    /**
     * Constructor de clase. Permite crear una elipse.
     * @param pO Point2D punto de origen
     * @param pF Point2D punto final
     * @param trazo Color color de trazo
     * @param stroke TipoLinea tipo de línea
     * @param grosor int grosor de la línea
     * @param relleno Color color de relleno
     * @param tr TipoRelleno tipo de relleno
     * @param deg1 Color primer color de degradado
     * @param deg2 Color segundo color de degradado
     * @param transparencia float nivel de transparencia
     * @param alisado boolean activar alisado de la imagen (true/false)
     */
    public Elipse(Point2D pO, Point2D pF, Color trazo, TipoLinea stroke, int grosor,
            Color relleno, TipoRelleno tr, Color deg1, Color deg2, 
            float transparencia, boolean alisado){
        super(pO, pF,trazo,stroke, grosor, relleno, tr, deg1, deg2, transparencia,alisado);
        elipse = new Ellipse2D.Double(pO.getX(), pO.getY(), pF.getX()-pO.getX(), pF.getY()-pO.getY());
        super.setShape(elipse);
    }
    /**
     * 
     * {@inheritDoc} 
     */
    @Override
    public void updateShape(Point2D puntoOrigen, Point2D puntoFinal){
        elipse.setFrameFromDiagonal(puntoOrigen, puntoFinal);
        setPO(puntoOrigen);
        setPF(puntoFinal);
    }
    
    /**
     * 
     * {@inheritDoc} 
     */
    public void setLocation(Point2D p) {
        double w = Math.abs(getPO().getX()-getPF().getX());
        double h = Math.abs(getPO().getY()-getPF().getY());
        elipse.setFrame(p.getX(), p.getY(), w, h);
        setPO(new Point.Double(elipse.getMinX(), elipse.getMinY()));
        setPF(new Point.Double(elipse.getMaxX(), elipse.getMaxY()));
    }
    
}
