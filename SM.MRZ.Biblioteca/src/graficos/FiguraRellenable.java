package graficos;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public abstract class FiguraRellenable extends Figura{
    Shape s = null;
    private Color colorRelleno = null;
    private TipoRelleno tipoRelleno = null;
    private Color degradado1 = null;
    private Color degradado2 = null;
    
    public FiguraRellenable(Point2D puntoOrigen, Point2D puntoFinal,
            Color trazo, TipoLinea stroke, int grosor, Color colorRelleno, TipoRelleno tr, 
            Color deg1, Color deg2, float transparencia, boolean alisado){
        super(puntoOrigen, puntoFinal, trazo,stroke, grosor,transparencia,alisado);
        this.colorRelleno = colorRelleno;
        tipoRelleno = tr;
        degradado1 = deg1;
        degradado2 = deg2;
    }
    
    public void setShape(Shape s){this.s = s;}
    
    public void setTipoRelleno(TipoRelleno tipoRelleno){
        this.tipoRelleno = tipoRelleno;
    }
    
    public TipoRelleno getTipoRelleno(){return tipoRelleno;}
    
    public void setDegradado1(Color d){
        degradado1 = d;
    }
    public Color getDegradado1(){return degradado1;}
    public void setDegradado2(Color d){
        degradado2 = d;
    }
    public Color getDegradado2(){return degradado2;}
    
    /**
    * Setter.
    * @param color color de relleno de la figura
    */
    public void setColorRelleno(Color color){colorRelleno = color;}
    @Override
    public boolean isFiguraRellenable(){return true;}
    /**
    * Getter.
    * @return color color de relleno de la figura
    */
    public Color getColorRelleno(){return colorRelleno;}
    @Override
    public void paint(Graphics2D g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //transparencia
        Composite comp;
        comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getTransparencia());
        g2d.setComposite(comp);

        //relleno
        if(getTipoRelleno()==TipoRelleno.LISO){
            g2d.setColor(getColorRelleno());
            g2d.fill(s);
        }
        if(getTipoRelleno()==TipoRelleno.DEGRADADO_DIAGONAL){
            Paint relleno;
            Point2D pc1 = getPO();
            Point2D pc2 = getPF();
            relleno = new GradientPaint(pc1, Color.RED, pc2, Color.BLUE);
            g2d.setPaint(relleno);
            g2d.fill(s);
        }
        if(getTipoRelleno()==TipoRelleno.DEGRADADO_DIAGONAL){
            Color deg1 = getDegradado1();
            Color deg2 = getDegradado2();
            if(deg1!=null && deg2 != null){
                Paint relleno;
                Point2D pc1 = getPO();
                Point2D pc2 = getPF();
                relleno = new GradientPaint(pc1, deg1, pc2, deg2);
                g2d.setPaint(relleno);
                g2d.fill(s);
            }
        }
        if(getTipoRelleno()==TipoRelleno.DEGRADADO_VERTICAL){
            Color deg1 = getDegradado1();
            Color deg2 = getDegradado2();
            if(deg1!=null && deg2 != null){
                Paint relleno;
                double a = getPF().getX()-getPO().getX();
                Point2D pc1 = getPO();
                Point2D pc2 = new Point((int) (getPF().getX()-a), (int) getPF().getY());
                relleno = new GradientPaint(pc1, deg1, pc2, deg2);
                g2d.setPaint(relleno);
                g2d.fill(s);
            }
        }
        if(getTipoRelleno()==TipoRelleno.DEGRADADO_HORIZONTAL){
            Color deg1 = getDegradado1();
            Color deg2 = getDegradado2();
            if(deg1!=null && deg2 != null){
                Paint relleno;
                double a = getPF().getY()-getPO().getY();
                Point2D pc1 = getPO();
                Point2D pc2 = new Point((int) (getPF().getX()), (int) (getPF().getY()-a));
                relleno = new GradientPaint(pc1, deg1, pc2, deg2);
                g2d.setPaint(relleno);
                g2d.fill(s);
            }
        }
        if(getTipoRelleno()==TipoRelleno.DEGRADADO_RADIAL){
            Color deg1 = getDegradado1();
            Color deg2 = getDegradado2();
            if(deg1!=null && deg2 != null){
                Paint relleno;
                float r = 500;
                float[] dist = {0.0f, 0.25f, 0.5f, 0.75f};
                Color[] colors = {deg1, deg2, deg1, deg2};
                Point2D center = new Point((int) (Math.abs(getPF().getX()-getPO().getX())/2), 
                        (int) Math.abs((getPF().getY()-getPO().getY())/2));
                relleno = new RadialGradientPaint(center, r, dist, colors);
                g2d.setPaint(relleno);
                g2d.fill(s);
            }
        }
        //si no se pone aquí, el trazo sale del mismo color que el relleno
        g2d.setColor(getColor());
        g2d.draw(s);
    }
}
