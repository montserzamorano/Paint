package graficos;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

/**
 * Clase RectanguloRedondeado. Hereda de FiguraRellenable. Representa un
 * rectángulo con las esquinas redondeadas.
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public class RectanguloRedondeado extends FiguraRellenable{
    
    /**
    * Constructor
     * @param pO Point2D
     * @param pF Point2D
    * @param trazo Color
    * @param stroke TipoLinea
     * @param grosor int
    * @param relleno Color
     * @param tr TipoRelleno
     * @param deg1 Color
     * @param deg2 Color
     * @param transparencia float
     * @param alisado boolean true/false si alisado activado/desactivado
     **/
    public RectanguloRedondeado(Point2D pO, Point2D pF, Color trazo, TipoLinea stroke, int grosor,  
            Color relleno, TipoRelleno tr, Color deg1, Color deg2, 
            float transparencia, boolean alisado){
        super(pO, pF,trazo,stroke,grosor,relleno, tr, deg1, deg2, transparencia, alisado);
        RoundRectangle2D rectangulo = new RoundRectangle2D.Double(pO.getX(),pO.getY(),pF.getX()-pO.getX(),pF.getY()-pO.getY(),50,50);
        super.setShape(rectangulo);
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public void updateShape(Point2D puntoOrigen, Point2D puntoFinal){
        RoundRectangle2D rectangulo = ((RoundRectangle2D) super.getShape());
        rectangulo.setFrameFromDiagonal(puntoOrigen, puntoFinal);
        setPO(puntoOrigen);
        setPF(puntoFinal);
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public void setLocation(Point2D p) {
        RoundRectangle2D rectangulo = ((RoundRectangle2D) super.getShape());
        double w = Math.abs(getPO().getX()-getPF().getX());
        double h = Math.abs(getPO().getY()-getPF().getY());
        rectangulo.setFrame(p.getX(), p.getY(), w, h);
        setPO(new Point.Double(rectangulo.getMinX(), rectangulo.getMinY()));
        setPF(new Point.Double(rectangulo.getMaxX(), rectangulo.getMaxY()));
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public String toString(){
        String ts = "Rectangulo redondeado";
        //añadir color
        if(getColor()==Color.RED){ts+=" rojo";}
        else if(getColor()==Color.BLUE){ts+=" azul";}
        else if(getColor()==Color.GREEN){ts+=" verde";}
        else if(getColor()==Color.YELLOW){ts+=" amarillo";}
        else if(getColor()==Color.WHITE){ts+=" blanco";}
        else if(getColor()==Color.BLACK){ts+=" negro";}
        if(null!=super.getStroke()) //linea discontinua
        switch (super.getStroke()) {
            case CONTINUA:
                ts+=" continuo";
                break;
            case DISCONTINUA:
                ts+=" discontinuo";
                break;
            case PUNTEADA:
                ts+=" punteado";
                break;
            default:
                break;
        }
        if(null==super.getTipoRelleno()){
            ts+=" degradado";
        }
        else //relleno
        switch (super.getTipoRelleno()) {
            case LISO:
                ts+= " liso";
                break;
            case NINGUNO:
                ts+="";
                break;
            default:
                ts+=" degradado";
                break;
        }
        return ts;
    }
}