/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 14.06.2019
 */
package graficos;

import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;

public abstract class FiguraLineal extends Figura{
    public FiguraLineal(Point2D puntoOrigen, Point2D puntoFinal, Color trazo, Stroke stroke, boolean alisado){
        super(puntoOrigen, puntoFinal, trazo,stroke, alisado);
    }
    
    
}
