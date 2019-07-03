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
 *
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
     * 
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
     * 
     * @param colorTintado 
     */
    public void setColorTintado(Color colorTintado){
        this.colorTintado = colorTintado;
    }
    /**
     * 
     * @return 
     */
    public Color getColorTintado(){
        return colorTintado;
    }
    /**
     * 
     * @param tintado 
     */
    public void setTintadoActivated(boolean tintado){tintadoActivated = tintado;}
    /**
     * 
     * @return 
     */
    public boolean getTintadoActivated(){return tintadoActivated;}
    /**
     * 
     * @param img 
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
     * 
     * @param drawVector
     * @return 
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
