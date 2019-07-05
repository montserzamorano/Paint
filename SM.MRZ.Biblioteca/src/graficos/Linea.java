package graficos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Clase Linea. Hereda de FiguraLineal. Representa una línea.
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public class Linea extends FiguraLineal{
    private Line2D linea;
    /**
     * Crea un objeto de tipo línea.
     * @param puntoOrigen Point2D punto de origen
     * @param puntoFinal Point2D punto final
     * @param trazo Color color del trazo
     * @param stroke TipoLinea tipo de línea de la figura
     * @param grosor int grosor de la línea 
     * @param transparencia float grado de trasparencia
     * @param alisado boolean true/false si alisado activado/desactivado
     */
    public Linea(Point2D puntoOrigen, Point2D puntoFinal, Color trazo, TipoLinea stroke, int grosor, float transparencia, boolean alisado){
        super(puntoOrigen, puntoFinal, trazo,stroke, grosor, transparencia, alisado);
        linea = new Line2D.Float(puntoOrigen, puntoFinal);
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public void updateShape(Point2D puntoOrigen, Point2D puntoFinal){
        linea.setLine(puntoOrigen, puntoFinal);
        setPO(puntoOrigen);
        setPF(puntoFinal);
    }
    /**
     * {@inheritDoc }
     */
    @Override 
    public void paint(Graphics2D g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //color
        g2d.setColor(getColor());
        //stroke
        g2d.draw(linea);
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public void setLocation(Point2D p) {
        double dx=p.getX()-linea.getX1();
        double dy=p.getY()-linea.getY1();
        Point2D newp2 = new Point2D.Double(linea.getX2()+dx, linea.getY2()+dy);
        linea.setLine(p,newp2);
        setPO(p);
        setPF(newp2);
    }
        /**
     * {@inheritDoc }
     */
    @Override
    public String toString(){
        String ts = "Línea";
        //añadir color
        if(getColor()==Color.RED){ts+=" roja";}
        else if(getColor()==Color.BLUE){ts+=" azul";}
        else if(getColor()==Color.GREEN){ts+=" verde";}
        else if(getColor()==Color.YELLOW){ts+=" amarilla";}
        else if(getColor()==Color.WHITE){ts+=" blanca";}
        else if(getColor()==Color.BLACK){ts+=" negra";}
        //linea discontinua
        if(getStroke()==TipoLinea.CONTINUA){ts+=" continua";}
        else if(getStroke()==TipoLinea.DISCONTINUA){ts+=" discontinua";}
        else if(getStroke()==TipoLinea.PUNTEADA){ts+=" punteada";}
        return ts;
    }
}
