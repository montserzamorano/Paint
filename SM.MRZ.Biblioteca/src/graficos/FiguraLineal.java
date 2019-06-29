package graficos;

import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public abstract class FiguraLineal extends Figura{
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
    public FiguraLineal(Point2D puntoOrigen, Point2D puntoFinal, Color trazo, TipoLinea stroke, int grosor, float transparencia, boolean alisado){
        super(puntoOrigen, puntoFinal, trazo,stroke, grosor, transparencia, alisado);
    }
    
}
