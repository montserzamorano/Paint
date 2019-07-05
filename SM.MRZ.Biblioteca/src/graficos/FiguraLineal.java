package graficos;

import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 * Clase FiguraLineal. Hereda de Figura. Representa una figura de tipo lineal.
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public abstract class FiguraLineal extends Figura{
    /**
     * Crea un objeto de tipo FiguraLineal
     * @param puntoOrigen Point2D punto de origen
     * @param puntoFinal Point2D punto final
     * @param trazo Color color de trazo
     * @param stroke TipoLinea tipo de lína
     * @param grosor int grosor del trazo
     * @param transparencia float grado de transparencia
     * @param alisado boolean true/false alisado activado/deactivado
     */
    public FiguraLineal(Point2D puntoOrigen, Point2D puntoFinal, Color trazo, TipoLinea stroke, int grosor, float transparencia, boolean alisado){
        super(puntoOrigen, puntoFinal, trazo,stroke, grosor, transparencia, alisado);
    }
    
}
