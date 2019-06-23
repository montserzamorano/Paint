package iu;

import graficos.Figura;
import graficos.Rectangulo;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public class FiguraRenderer extends JLabel implements ListCellRenderer<Figura>{
    public FiguraRenderer(){
        setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Figura> list, Figura value, int index, boolean isSelected, boolean cellHasFocus) {
        //texto de la celda
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