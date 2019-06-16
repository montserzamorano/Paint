/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */
package graficos;

import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;

public abstract class FiguraLineal extends Figura{
    public FiguraLineal(Point2D puntoOrigen, Point2D puntoFinal, Color trazo, TipoLinea stroke, int grosor, float transparencia, boolean alisado){
        super(puntoOrigen, puntoFinal, trazo,stroke, grosor, transparencia, alisado);
    }
    
    
}
