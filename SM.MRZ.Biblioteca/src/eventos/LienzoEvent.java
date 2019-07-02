package eventos;

import graficos.Figura;
import graficos.Forma;
import graficos.TipoLinea;
import graficos.TipoRelleno;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

//https://www.javaworld.com/article/2077333/mr-happy-object-teaches-custom-events.html

public class LienzoEvent extends EventObject{
    private Figura figura;
    private Point2D posicion;
 
    private List <Figura> vFiguras;
    //atributos del lienzo
    //trazo
    private Color colorTrazo;
    private TipoLinea stroke;
    private int grosor;
    //transparencia
    private float transparencia;
    //relleno
    private Color colorRelleno;
    private TipoRelleno tipoRelleno;
    private Color colorDeg1;
    private Color colorDeg2;
    //forma
    private Forma formaActiva;
    //alisado
    private boolean alisado;
    
    public LienzoEvent(Object source, Figura figura, Point2D posicion, List <Figura> vFiguras,
        Color colorTrazo, TipoLinea stroke, int grosor, float transparencia, Color colorRelleno,
        TipoRelleno tipoRelleno, Color colorDeg1, Color colorDeg2, Forma formaActiva, boolean alisado) {
        super(source);
        this.figura = figura;
        this.posicion = posicion;
        this.colorTrazo = colorTrazo;
        this.stroke = stroke;
        this.grosor = grosor;
        this.transparencia = transparencia;
        this.colorRelleno = colorRelleno;
        this.tipoRelleno = tipoRelleno;
        this.colorDeg1 = colorDeg1;
        this.colorDeg2 = colorDeg2;
        this.formaActiva = formaActiva;
        this.alisado = alisado;
        this.vFiguras = vFiguras;
    }
    /**
     * 
     * @return 
     */
    public Figura getFigura(){return figura;}
    /**
     * 
     * @return 
     */
    public Color getColorTrazo(){return colorTrazo;}
    /**
     * 
     * @return 
     */
    public Color getColorRelleno(){return colorRelleno;}
    /**
     * 
     * @return 
     */
    public Point2D getPosicion(){return posicion;}
    /**
     * 
     * @return 
     */
    public List<Figura> getVFiguras(){return vFiguras;}
    /**
     * 
     * @return 
     */
    public TipoLinea getStroke(){return stroke;}
    /**
     * 
     * @return 
     */
    public int getGrosor(){return grosor;}
    /**
     * 
     * @return 
     */
    public float getTransparencia(){return transparencia;}
    /**
     * 
     * @return 
     */
    public TipoRelleno getTipoRelleno(){return tipoRelleno;}
    /**
     * 
     * @return 
     */
    public Color getColorDeg1(){return colorDeg1;}
    /**
     * 
     * @return 
     */
    public Color getColorDeg2(){return colorDeg2;}
    /**
     * 
     * @return 
     */
    public Forma getForma(){return formaActiva;}
    /**
     * 
     * @return 
     */
    public boolean getAlisado(){return alisado;}
}
