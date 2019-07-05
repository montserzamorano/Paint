package iu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

/**
 * Clase LienzoImagen. Hereda de Lienzo. Representa un lienzo con un
 * área determinada para diujar.
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public class LienzoImagen extends Lienzo {
    private BufferedImage img;
    private Color colorTintado;
    private boolean tintadoActivated = false;
    
    /**
     * Creates new form LienzoImagen
     */
    public LienzoImagen() {
        initComponents();
    }
    /**
     * Determina un rectángulo de color blanco con línea negra como imagen
     * del lienzo
     */
    public void setArea(){
        int w = getDimension().width;
        int h = getDimension().height;
        img = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
        //rellenar la imagen de blanco
        Graphics2D g2d;
        g2d = img.createGraphics();
        g2d.setColor(Color.WHITE);
        Rectangle r = new Rectangle(getDimension());
        g2d.fill(r);
        
        //señalar el lienzo
        g2d.setColor(Color.BLACK);
        Stroke trazo = new BasicStroke(2.0f);
        g2d.setStroke(trazo);
        g2d.draw(r);
        
        setImage(img);
    }
    /**
     * Setter.
     * @param colorTintado Color color de tintado de la imagen
     */
    public void setColorTintado(Color colorTintado){
        this.colorTintado = colorTintado;
    }
    /**
     * Getter.
     * @return Color color de tintado 
     */
    public Color getColorTintado(){
        return colorTintado;
    }
    /**
     * Setter.
     * @param tintado boolean true/false si activar/desactivar tintado 
     */
    public void setTintadoActivated(boolean tintado){tintadoActivated = tintado;}
    /**
     * Getter.
     * @return boolean true/false si el tintado está activado/desactivado
     */
    public boolean getTintadoActivated(){return tintadoActivated;}
    /**
     * Establece una imagen en el lienzo
     * @param img BufferedImage imagen a asociar al lienzo
     */
    public void setImage(BufferedImage img){
        //deseleccionamos para que no se guarde la bounding box
        this.quitBoundingBox();
        this.img = img;
        if(img!=null){
            setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        }
    }
    /**
     * Devuelve una imagen.
     * @param drawVector boolean devolverá la imagen 
     * con el vector de figuras dibujadas sobre ella si true y sin el vector
     * de figuras si false.
     * @return BufferedImage img
     */
    public BufferedImage getImage(boolean drawVector){
        if(drawVector){
            //codigo para guardar también las formas
            BufferedImage imgDest = new BufferedImage(img.getWidth(), img.getHeight(), 5);
            this.paint(imgDest.createGraphics());
            img = imgDest;
        }
        return img;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(img!=null){
            g.drawImage(img,0,0,this);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
