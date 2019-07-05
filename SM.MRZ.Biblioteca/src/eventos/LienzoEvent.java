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
 * Clase LienzoEvent. Representa un evento lanzado por el lienzo.
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */


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
    /**
     * Crea un evento LienzoEvent listener
     * @param source Object
     * @param figura Figura figura activa
     * @param posicion Point2D posición
     * @param vFiguras List Figura lista de figuras
     * @param colorTrazo Color color de trazo
     * @param stroke TipoLinea tipo de línea del trazo
     * @param grosor int grosor de la línea
     * @param transparencia float grado de transparencia
     * @param colorRelleno Color color de relleno
     * @param tipoRelleno TipoRelleno tipo de relleno
     * @param colorDeg1 Color primer color de degradado
     * @param colorDeg2 Color segundo color de degradado
     * @param formaActiva Forma forma activa
     * @param alisado boolean true/false activado activado
     */
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
     * Getter.
     * @return Figura
     */
    public Figura getFigura(){return figura;}
    /**
     * Getter.
     * @return Color color de trazo
     */
    public Color getColorTrazo(){return colorTrazo;}
    /**
     * Getter.
     * @return Color color de relleno
     */
    public Color getColorRelleno(){return colorRelleno;}
    /**
     * Getter.
     * @return Point2D posicion
     */
    public Point2D getPosicion(){return posicion;}
    /**
     * Getter.
     * @return List Figura vector de figuras
     */
    public List<Figura> getVFiguras(){return vFiguras;}
    /**
     * Getter.
     * @return TipoLinea tipo de línea
     */
    public TipoLinea getStroke(){return stroke;}
    /**
     * Getter.
     * @return int grosor de la línea
     */
    public int getGrosor(){return grosor;}
    /**
     * Getter.
     * @return float grado de transparencia
     */
    public float getTransparencia(){return transparencia;}
    /**
     * Getter.
     * @return TipoRelleno tipo de relleno
     */
    public TipoRelleno getTipoRelleno(){return tipoRelleno;}
    /**
     * Getter.
     * @return Color primer color de degradado
     */
    public Color getColorDeg1(){return colorDeg1;}
    /**
     * Getter.
     * @return Color segundo color de degradado
     */
    public Color getColorDeg2(){return colorDeg2;}
    /**
     * Getter.
     * @return Forma forma
     */
    public Forma getForma(){return formaActiva;}
    /**
     * Getter.
     * @return boolean true/false alisado activado/desactivado 
     */
    public boolean getAlisado(){return alisado;}
}
