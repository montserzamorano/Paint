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
import java.awt.Stroke;
import java.awt.geom.Point2D;

public abstract class FiguraRellenable extends Figura{
    private Color colorRelleno = null;
    private float transparencia = 1.0f;
    
    public FiguraRellenable(Point2D puntoOrigen, Point2D puntoFinal,
                            Color trazo, Stroke stroke, 
                            Color colorRelleno, float transparencia, boolean alisado){
        super(puntoOrigen, puntoFinal, trazo,stroke,alisado);
        this.transparencia = transparencia;
        this.colorRelleno = colorRelleno;
    }
    
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
    * Setter.
    * @param transparencia color de relleno de la figura
    */
    public void setTransparencia(float transparencia){
        this.transparencia=transparencia;
    }
    /**
    * Getter.
    * @return transparencia grado de transparencia del relleno
    */
    public float getTransparencia(){return transparencia;}
    
}
