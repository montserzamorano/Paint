/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 14.06.2019
 */
package graficos;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Linea extends FiguraLineal{
    private Line2D linea;
    
    public Linea(Point2D puntoOrigen, Point2D puntoFinal, Color trazo, Stroke stroke, float transparencia, boolean alisado){
        super(puntoOrigen, puntoFinal, trazo,stroke, transparencia, alisado);
        linea = new Line2D.Float(puntoOrigen, puntoFinal);
    }
    
    @Override
    public void updateShape(Point2D puntoOrigen, Point2D puntoFinal){
        linea.setLine(puntoOrigen, puntoFinal);
    }
    
    @Override 
    public void paint(Graphics2D g){
        Graphics2D g2d = (Graphics2D) g;
        //color
        g2d.setColor(getColor());
        //stroke
        g2d.draw(linea);
    }

    @Override
    public void setLocation(Point2D p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
