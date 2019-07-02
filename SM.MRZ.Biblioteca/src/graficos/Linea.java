package graficos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public class Linea extends FiguraLineal{
    private Line2D linea;
    /**
     * 
     * @param puntoOrigen
     * @param puntoFinal
     * @param trazo
     * @param stroke
     * @param grosor
     * @param transparencia
     * @param alisado 
     */
    public Linea(Point2D puntoOrigen, Point2D puntoFinal, Color trazo, TipoLinea stroke, int grosor, float transparencia, boolean alisado){
        super(puntoOrigen, puntoFinal, trazo,stroke, grosor, transparencia, alisado);
        linea = new Line2D.Float(puntoOrigen, puntoFinal);
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public void updateShape(Point2D puntoOrigen, Point2D puntoFinal){
        linea.setLine(puntoOrigen, puntoFinal);
        setPO(puntoOrigen);
        setPF(puntoFinal);
    }
    /**
     * {@inheritDoc }
     */
    @Override 
    public void paint(Graphics2D g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //color
        g2d.setColor(getColor());
        //stroke
        g2d.draw(linea);
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public void setLocation(Point2D p) {
        double dx=p.getX()-linea.getX1();
        double dy=p.getY()-linea.getY1();
        Point2D newp2 = new Point2D.Double(linea.getX2()+dx, linea.getY2()+dy);
        linea.setLine(p,newp2);
        setPO(p);
        setPF(newp2);
    }
}
