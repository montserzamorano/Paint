/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import iu.Lienzo;
import iu.LienzoImagen;

/**
 *
 * @author PC
 */
public class VentanaInterna extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaMultimedia
     */
    public VentanaInterna() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzoImagen1 = new iu.LienzoImagen();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        javax.swing.GroupLayout lienzoImagen1Layout = new javax.swing.GroupLayout(lienzoImagen1);
        lienzoImagen1.setLayout(lienzoImagen1Layout);
        lienzoImagen1Layout.setHorizontalGroup(
            lienzoImagen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        lienzoImagen1Layout.setVerticalGroup(
            lienzoImagen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        getContentPane().add(lienzoImagen1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private iu.LienzoImagen lienzoImagen1;
    // End of variables declaration//GEN-END:variables

    public LienzoImagen getLienzo() {
        return lienzoImagen1;
    }
}