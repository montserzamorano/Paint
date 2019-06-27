package graficos;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public class Elipse extends FiguraRellenable{
    private Ellipse2D elipse;
    
    public Elipse(Point2D pO, Point2D pF, Color trazo, TipoLinea stroke, int grosor,
            Color relleno, TipoRelleno tr, Color deg1, Color deg2, 
            float transparencia, boolean alisado){
        super(pO, pF,trazo,stroke, grosor, relleno, tr, deg1, deg2, transparencia,alisado);
        elipse = new Ellipse2D.Double(pO.getX(), pO.getY(), pF.getX()-pO.getX(), pF.getY()-pO.getY());
        super.setShape(elipse);
    }
    
    @Override
    public void updateShape(Point2D puntoOrigen, Point2D puntoFinal){
        elipse.setFrameFromDiagonal(puntoOrigen, puntoFinal);
        setPO(puntoOrigen);
        setPF(puntoFinal);
    }
    
    @Override
    public void setLocation(Point2D p) {
        double w = Math.abs(getPO().getX()-getPF().getX());
        double h = Math.abs(getPO().getY()-getPF().getY());
        elipse.setFrame(p.getX(), p.getY(), w, h);
        setPO(new Point.Double(elipse.getMinX(), elipse.getMinY()));
        setPF(new Point.Double(elipse.getMaxX(), elipse.getMaxY()));
    }
    
}
