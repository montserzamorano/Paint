package iu;

import graficos.TipoLinea;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Clase TipoLineaRenderer. Hereda de JLabel. Representa una celda que contiene
 * un objeto TipoLinea.
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public class TipoLineaRenderer extends JLabel implements ListCellRenderer<TipoLinea>{
    /**
     * Constructor de clase.
     */
    public TipoLineaRenderer() {
        setOpaque(true);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends TipoLinea> list, TipoLinea value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.toString());
        Color background;
        Color foreground;
        
        //check if this cell represents the current DnD drop location
        JList.DropLocation dropLocation = list.getDropLocation();
        if(dropLocation != null 
                && !dropLocation.isInsert()
                && dropLocation.getIndex()==index){
            background = Color.BLUE;
            foreground = Color.WHITE;
        //check if this cell is selected
        }else if (isSelected){
            background = Color.BLUE;
            foreground = Color.BLACK;
        //unselected and not the DnD drop location
        } else{
            background = Color.WHITE;
            foreground = Color.BLACK;
        };
        
        setBackground(background);
        setForeground(foreground);
        
        return this;
    }
    
}