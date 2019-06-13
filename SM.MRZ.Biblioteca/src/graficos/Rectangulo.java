/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 14.06.2019
 */
package graficos;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Rectangulo extends FiguraRellenable{
    private Rectangle2D rectangulo;
    
    /**
    * Constructor
    * @param trazo
    * @param stroke
    * @param relleno
    */
    public Rectangulo(Point2D pO, Point2D pF, Color trazo, Stroke stroke, 
            Color relleno, TipoRelleno tr, float transparencia, boolean alisado){
        super(pO, pF,trazo,stroke, relleno, tr, transparencia, alisado);
        rectangulo = new Rectangle2D.Double(pO.getX(), pO.getY(), pF.getX()-pO.getX(), pF.getY()-pO.getY());
    }
    
    @Override
    public void updateShape(Point2D puntoOrigen, Point2D puntoFinal){
        rectangulo.setFrameFromDiagonal(puntoOrigen, puntoFinal);
    }
    
    @Override
    public void setLocation(Point2D p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void paint(Graphics2D g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //relleno
        if(getTipoRelleno()==TipoRelleno.LISO){
            g2d.setColor(getColorRelleno());
            g2d.fill(rectangulo);
        }
        if(getTipoRelleno()==TipoRelleno.DEGRADADO_DIAGONAL){
            Paint relleno;
            Point2D pc1 = getPO();
            Point2D pc2 = getPF();
            relleno = new GradientPaint(pc1, Color.RED, pc2, Color.BLUE);
            g2d.setPaint(relleno);
            g2d.fill(rectangulo);
        }
        if(getTipoRelleno()==TipoRelleno.DEGRADADO_DIAGONAL){
            Paint relleno;
            Point2D pc1 = getPO();
            Point2D pc2 = getPF();
            relleno = new GradientPaint(pc1, Color.RED, pc2, Color.BLUE);
            g2d.setPaint(relleno);
            g2d.fill(rectangulo);
        }
        if(getTipoRelleno()==TipoRelleno.DEGRADADO_VERTICAL){
            Paint relleno;
            double a = getPF().getX()-getPO().getX();
            Point2D pc1 = getPO();
            Point2D pc2 = new Point((int) (getPF().getX()-a), (int) getPF().getY());
            relleno = new GradientPaint(pc1, Color.RED, pc2, Color.BLUE);
            g2d.setPaint(relleno);
            g2d.fill(rectangulo);
        }
        if(getTipoRelleno()==TipoRelleno.DEGRADADO_HORIZONTAL){
            Paint relleno;
            double a = getPF().getY()-getPO().getY();
            Point2D pc1 = getPO();
            Point2D pc2 = new Point((int) (getPF().getX()), (int) (getPF().getY()-a));
            relleno = new GradientPaint(pc1, Color.RED, pc2, Color.BLUE);
            g2d.setPaint(relleno);
            g2d.fill(rectangulo);
        }
        //si no se pone aquí, el trazo sale del mismo color que el relleno
        g2d.setColor(getColor());
        g2d.draw(rectangulo);
    }
}
