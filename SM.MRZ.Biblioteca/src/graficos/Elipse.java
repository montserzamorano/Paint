/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 14.06.2019
 */
package graficos;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Elipse extends FiguraRellenable{
    private Ellipse2D elipse;
    
    public Elipse(Point2D pO, Point2D pF, Color trazo, Stroke stroke, 
            Color relleno, float transparencia, boolean alisado){
        super(pO, pF,trazo,stroke, relleno, transparencia,alisado);
        elipse = new Ellipse2D.Double(pO.getX(), pO.getY(), pF.getX()-pO.getX(), pF.getY()-pO.getY());
    }
    
    @Override
    public void updateShape(Point2D puntoOrigen, Point2D puntoFinal){
        elipse.setFrameFromDiagonal(puntoOrigen, puntoFinal);
    }
    
    @Override
    public void setLocation(Point2D p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void paint(Graphics2D g){
        Graphics2D g2d = (Graphics2D) g;
        
        //transparencia
        Composite comp;
        comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getTransparencia());
        g2d.setComposite(comp);
        //relleno
        if(getColorRelleno()!=null){
            g2d.setColor(getColorRelleno());
            g2d.fill(elipse);
        }
        //alisado
        if(getAlisado()){
            RenderingHints render;
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHints(render);
        }
        //color
        g2d.setColor(getColor());
        //stroke
        g2d.setStroke(getStroke());
        g2d.draw(elipse);
    }
}