package graficos;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Clase que representa una bounding box, que engloba una determinada figura
 * seleccionada.
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */
public class BoundingBox extends Rectangulo{
    
    public BoundingBox(Rectangle2D frame) {
        super(new Point.Double(frame.getMinX(), frame.getMinY()), 
              new Point.Double(frame.getMaxX(), frame.getMaxY()),
              Color.BLUE, TipoLinea.DISCONTINUA, 2, Color.BLUE, TipoRelleno.LISO, 
              null, null, 0.15f, true);
        Point2D pO = new Point.Double(frame.getMinX()-10, frame.getMinY()-10);
        Point2D pF = new Point.Double(frame.getMaxX()+10, frame.getMaxY()+10);
        Rectangle2D rectangulo = this.getRectangulo();
        //altura y ancho más grandes del marco
        double w = Math.abs(pO.getX()-pF.getX());
        double h = Math.abs(pO.getY()-pF.getY());
        rectangulo.setRect(pO.getX(), pO.getY(), w, h);
        setPO(pO);
        setPF(pF);
    }
    
}
