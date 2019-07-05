package iu;

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

public class ColorRenderer extends JLabel implements ListCellRenderer<Color>{
    /**
     * Crea un nuevo objeto ColorRenderer.
     */
    public ColorRenderer(){
        setOpaque(true);
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends Color> list, Color value, int index, boolean isSelected, boolean cellHasFocus) {
        //texto de la celda
        if(value == Color.RED){setText("Rojo");}
        if(value == Color.BLUE){setText("Azul");}
        if(value == Color.GREEN){setText("Verde");}
        if(value == Color.BLACK){setText("Negro");}
        if(value == Color.WHITE){setText("Blanco");}
        if(value == Color.YELLOW){setText("Amarillo");}
        if(value == Color.CYAN){setText("Cyan");}
        if(value == Color.ORANGE){setText("Naranja");}
        if(value == Color.PINK){setText("Rosa");}
        if(value == Color.LIGHT_GRAY){setText("Gris");}
        Color background;
        Color foreground;
        
        //check if this cell represents the current DnD drop location
        JList.DropLocation dropLocation = list.getDropLocation();
        if(dropLocation != null 
                && !dropLocation.isInsert()
                && dropLocation.getIndex()==index){
            background = Color.BLUE;
            foreground = value;
        //check if this cell is selected
        }else if (isSelected){
            background = value;
            foreground = Color.BLACK;
        //unselected and not the DnD drop location
        } else{
            background = value;
            foreground = Color.BLACK;
        };
        
        setBackground(background);
        setForeground(foreground);
        
        return this;
    }
    
}
