package graficos;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * Clase FiguraRellenable. Hereda de Figura. Representa una figura que puede
 * rellenarse.
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public abstract class FiguraRellenable extends Figura{
    Shape s = null;
    private Color colorRelleno = null;
    private TipoRelleno tipoRelleno = null;
    private Color degradado1 = null;
    private Color degradado2 = null;
    /**
     * Crea un objeto FiguraRellenable.
     * @param puntoOrigen Point2D punto de origen
     * @param puntoFinal Point2D punto final
     * @param trazo Color color de trazo
     * @param stroke TipoLinea tipo de trazo
     * @param grosor int grosor de la línea
     * @param colorRelleno Color color de relleno
     * @param tr TipoRelleno tipo de relleno
     * @param deg1 Color primer color de degradado
     * @param deg2 Color segundo color de degradado
     * @param transparencia float grado de transparencia
     * @param alisado boolean true/false si alisado activado/desactivado
     */
    public FiguraRellenable(Point2D puntoOrigen, Point2D puntoFinal,
            Color trazo, TipoLinea stroke, int grosor, Color colorRelleno, TipoRelleno tr, 
            Color deg1, Color deg2, float transparencia, boolean alisado){
        super(puntoOrigen, puntoFinal, trazo,stroke, grosor,transparencia,alisado);
        this.colorRelleno = colorRelleno;
        tipoRelleno = tr;
        degradado1 = deg1;
        degradado2 = deg2;
    }
    /**
     * Setter.
     * @param s Shape nueva figura asociada a la figura rellenable 
     */
    public void setShape(Shape s){this.s = s;}
    /**
     * Getter.
     * @return Shape figura asociada a la figura rellenable. 
     */
    public Shape getShape(){return s;}
    /**
     * Setter.
     * @param tipoRelleno TipoRelleno nuevo tipo de relleno asociado a la figura
     */
    public void setTipoRelleno(TipoRelleno tipoRelleno){
        this.tipoRelleno = tipoRelleno;
    }
    /**
     * Getter.
     * @return TipoRelleno tipo de relleno asociado a la figura
     */
    public TipoRelleno getTipoRelleno(){return tipoRelleno;}
    /**
     * Setter.
     * @param d Color nuevo primer color de degradado
     */
    public void setDegradado1(Color d){
        degradado1 = d;
    }
    /**
     * Getter.
     * @return Color primer color de degradado asociado a la figura
     */
    public Color getDegradado1(){return degradado1;}
    /**
     * Setter.
     * @param d Color segundo color de degradado
     */
    public void setDegradado2(Color d){
        degradado2 = d;
    }
    /**
     * Getter.
     * @return Color segundo color de degradado
     */
    public Color getDegradado2(){return degradado2;}
    
    /**
    * Setter.
    * @param color color de relleno de la figura
    */
    public void setColorRelleno(Color color){colorRelleno = color;}
    /**
    * Getter.
    * @return color color de relleno de la figura
    */
    public Color getColorRelleno(){return colorRelleno;}
    /**
     * {@inheritDoc}
     */
    @Override
    public void paint(Graphics2D g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //transparencia
        Composite comp;
        comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getTransparencia());
        g2d.setComposite(comp);

        //relleno
        if(getTipoRelleno()==TipoRelleno.LISO && colorRelleno!=null){
            g2d.setColor(getColorRelleno());
            g2d.fill(s);
        }
        if(getTipoRelleno()==TipoRelleno.DEGRADADO_DIAGONAL){
            Color deg1 = getDegradado1();
            Color deg2 = getDegradado2();
            if(deg1!=null && deg2!=null){
                Paint relleno;
                Point2D pc1 = getPO();
                Point2D pc2 = getPF();
                relleno = new GradientPaint(pc1, deg1, pc2, deg2);
                g2d.setPaint(relleno);
                g2d.fill(s);
            }
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
        //si no se pone aquí, el trazo sale del mismo color que el relleno
        g2d.setColor(getColor());
        g2d.draw(s);
    }
}
