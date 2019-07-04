package graficos;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public class Rectangulo extends FiguraRellenable{
    //private Rectangle2D rectangulo;
    
    /**
    * Constructor
     * @param pO
     * @param pF
    * @param trazo
    * @param stroke
     * @param grosor
    * @param relleno
     * @param tr
     * @param deg1
     * @param deg2
     * @param transparencia
     * @param alisado
    */
    public Rectangulo(Point2D pO, Point2D pF, Color trazo, TipoLinea stroke, int grosor,  
            Color relleno, TipoRelleno tr, Color deg1, Color deg2, 
            float transparencia, boolean alisado){
        super(pO, pF,trazo,stroke,grosor,relleno, tr, deg1, deg2, transparencia, alisado);
        Rectangle2D rectangulo = new Rectangle2D.Double(pO.getX(),pO.getY(),pF.getX()-pO.getX(),pF.getY()-pO.getY());
        super.setShape(rectangulo);
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public void updateShape(Point2D puntoOrigen, Point2D puntoFinal){
        Rectangle2D rectangulo = ((Rectangle2D)super.getShape());
        rectangulo.setFrameFromDiagonal(puntoOrigen, puntoFinal);
        setPO(puntoOrigen);
        setPF(puntoFinal);
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public void setLocation(Point2D p) {
        Rectangle2D rectangulo = ((Rectangle2D)super.getShape());
        double w = Math.abs(getPO().getX()-getPF().getX());
        double h = Math.abs(getPO().getY()-getPF().getY());
        rectangulo.setRect(p.getX(), p.getY(), w, h);
        setPO(new Point.Double(rectangulo.getMinX(), rectangulo.getMinY()));
        setPF(new Point.Double(rectangulo.getMaxX(), rectangulo.getMaxY()));
    }
    /**
     * 
     * {@inheritDoc}
     */
    protected Rectangle2D getRectangulo(){return ((Rectangle2D)super.getShape());}
    @Override
    public String toString(){
        String ts = "Rectangulo";
        //añadir color
        if(getColor()==Color.RED){ts+=" rojo";}
        else if(getColor()==Color.BLUE){ts+=" azul";}
        else if(getColor()==Color.GREEN){ts+=" verde";}
        else if(getColor()==Color.YELLOW){ts+=" amarillo";}
        else if(getColor()==Color.WHITE){ts+=" blanco";}
        else if(getColor()==Color.BLACK){ts+=" negro";}
        //linea discontinua
        if(getStroke()==TipoLinea.CONTINUA){ts+=" continuo";}
        else if(getStroke()==TipoLinea.DISCONTINUA){ts+=" discontinuo";}
        else if(getStroke()==TipoLinea.PUNTEADA){ts+=" punteado";}
        //relleno
        if(getTipoRelleno()==TipoRelleno.LISO){ts+= " liso";}
        else if(getTipoRelleno()==TipoRelleno.NINGUNO){ts+="";}
        else{
            ts+=" degradado";
        }
        return ts;
    }
   
}
