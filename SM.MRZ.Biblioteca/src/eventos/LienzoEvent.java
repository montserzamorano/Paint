/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos;

import graficos.Figura;
import java.awt.Color;
import java.util.EventObject;

/**
 *
 * @author PC
 */
public class LienzoEvent extends EventObject{
    private Figura forma;
    private Color color;
    
    public LienzoEvent(Object source, Figura forma, Color color) {
        super(source);
        this.forma = forma;
        this.color = color;
    }
    
    public Figura getForma(){
        return forma;
    }
    
    public Color getColor(){
        return color;
    }
    
}
