package iu;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

import eventos.LienzoEvent;
import eventos.LienzoListener;
import graficos.Elipse;
import graficos.Figura;
import graficos.Forma;
import graficos.Linea;
import graficos.Rectangulo;
import graficos.TipoLinea;
import graficos.TipoRelleno;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 14.06.2019
 */
public class Lienzo extends javax.swing.JPanel {
    //Eventos
    ArrayList <LienzoListener> lienzoEventListeners = new ArrayList();
 
    private List <Figura> vFiguras = new ArrayList();
    //atributos del lienzo
    //trazo
    private Color colorTrazo = null;
    private TipoLinea stroke = null;
    private int grosor = 1;
    //transparencia
    private boolean transparenciaActivated = false;
    private float transparencia = 1.0f;
    //relleno
    private boolean rellenoActivated = false;
    private Color colorRelleno = null;
    private TipoRelleno tipoRelleno= null;
    private Color colorDeg1 = null;
    private Color colorDeg2 = null;
    //forma
    private Forma formaActiva = null;
    //alisado
    private boolean alisadoActivated = false;
    
    private Point2D pF = new Point(-1000, -1000);
    private Point2D pI = new Point(-1000, -1000);
    
    //pixel actual
    private Point2D pA = new Point(-1000, -1000);
    
    //dimension
    private Dimension dimension = new Dimension(300,300);
    
    Figura fActiva;
    
    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
    }
    
    /*
    * Añade una figura al vector de figuras
    * @param figura a añadir
    */    
    public void addFigura(Figura f){vFiguras.add(f);}
    
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
       g2d.clip(new Rectangle(dimension));
        
        for(Figura f: vFiguras){
          f.paint(g2d);
        }
    }
    
    public void setDimension(Dimension dimension){this.dimension = dimension;}
    public Dimension getDimension(){return dimension;}
    
    public void setColorTrazo(Color color){
        colorTrazo = color;
    }
    public Color getColorTrazo(){
        return colorTrazo;
    }

    public void setForma(Forma forma){formaActiva = forma;}
    
    public Color getColorRelleno(){
        return colorRelleno;
    }
    public void setColorRelleno(Color color){
        colorRelleno = color;
    }
    
    public float getTransparencia(){
        return transparencia;
    }
    
    public void setTransparencia(float transparencia){
        this.transparencia = transparencia;
    }
    
    public boolean getTransparenciaActivated(){
        return transparenciaActivated;
    }
    
    public void setTransparenciaActivated(boolean transparenciaActivated){
        this.transparenciaActivated = transparenciaActivated;
    }
    
    public boolean getRellenoActivated(){
        return rellenoActivated;
    }
    
    public void setRellenoActivated(boolean rellenoActivated){
        this.rellenoActivated = rellenoActivated;
    }
    
    public void setRelleno(Color color){
        colorRelleno = color;
    }
    
    public TipoLinea getStroke(){
        return stroke;
    }
    
    public void setStroke(TipoLinea stroke){
        this.stroke = stroke;
    }
    
    public boolean getAlisadoActivated(){
        return alisadoActivated;
    }
    
    public void changeAlisadoActivated(){
        alisadoActivated = !alisadoActivated;
    }
    
    public void setTipoRelleno(TipoRelleno tp){
        tipoRelleno = tp;
    }
    
    public void setColorDeg1(Color deg){
        colorDeg1 = deg;
    }
    
    public Color getColorDeg1(){
        return colorDeg1;
    }
    
    public void setColorDeg2(Color deg){
        colorDeg2 = deg;
    }
    public Color getColorDeg2(){
        return colorDeg2;
    }
    
    public void setGrosor(int grosor){
        this.grosor = grosor;
    }
    
    public int getGrosor(){
        return grosor;
    }
    
    public TipoRelleno getTipoRelleno(){return tipoRelleno;}
    
    private Figura createFigura(Point2D p1, Point2D p2){
        switch(formaActiva){
            case LINEA:
                fActiva = new Linea(p1,p2,colorTrazo, stroke, grosor, transparencia, alisadoActivated);
                break;
            case RECTANGULO:
                fActiva = new Rectangulo(p1, p2, colorTrazo, stroke, grosor, colorRelleno, tipoRelleno, colorDeg1, colorDeg2, transparencia, alisadoActivated);
                break;
            case OVALO:
                fActiva = new Elipse(p1, p2, colorTrazo, stroke, grosor, colorRelleno, tipoRelleno, colorDeg1, colorDeg2, transparencia, alisadoActivated);
                break;
            default:
                break;
        }
        return fActiva;
    }
    
    
    public List <Figura> getListaFiguras(){return vFiguras;}
    
    private void updateShape(){
        fActiva.updateShape(pI, pF);
    }
    
    //EVENTOS
    
    public void addLienzoListener(LienzoListener listener){
        if(listener != null){
            lienzoEventListeners.add(listener);
        }
    }
    
    private void notifyShapeAddedEvent(LienzoEvent evt){
        if(!lienzoEventListeners.isEmpty()){
            for(LienzoListener listener : lienzoEventListeners){
                listener.shapeAdded(evt);
            }
        }
    }
    
    private void notifyPropertyChangeEvent(LienzoEvent evt){
        if(!lienzoEventListeners.isEmpty()){
            for(LienzoListener listener : lienzoEventListeners){
                listener.propertyChange(evt);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(204, 204, 204));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        pI = evt.getPoint();
        vFiguras.add(createFigura(pI, pF));
        notifyShapeAddedEvent( new LienzoEvent(this, fActiva, colorTrazo));
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this.formMouseDragged(evt);
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        pF = evt.getPoint();
        updateShape();
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        pA = evt.getPoint();
    }//GEN-LAST:event_formMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
