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
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;

public abstract class FiguraRellenable extends Figura{
    private Color colorRelleno = null;
    private TipoRelleno tipoRelleno = null;
    
    public FiguraRellenable(Point2D puntoOrigen, Point2D puntoFinal,
                            Color trazo, Stroke stroke, 
                            Color colorRelleno, TipoRelleno tr, float transparencia, boolean alisado){
        super(puntoOrigen, puntoFinal, trazo,stroke,transparencia,alisado);
        this.colorRelleno = colorRelleno;
        tipoRelleno = tr;
    }
    
    public void setTipoRelleno(TipoRelleno tipoRelleno){
        this.tipoRelleno = tipoRelleno;
    }
    
    public TipoRelleno getTipoRelleno(){return tipoRelleno;}
    
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
    @Override
    public void paint(Graphics2D g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //transparencia
        Composite comp;
        comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getTransparencia());
        g2d.setComposite(comp);
    }
}
