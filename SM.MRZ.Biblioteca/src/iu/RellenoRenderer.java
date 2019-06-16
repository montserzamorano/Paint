/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */
package iu;

import graficos.TipoRelleno;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

//incluir referencia al enlace en la documentacion

public class RellenoRenderer extends JLabel implements ListCellRenderer<TipoRelleno>{
    public RellenoRenderer(){
        setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends TipoRelleno> list, TipoRelleno value, int index, boolean isSelected, boolean cellHasFocus) {
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
