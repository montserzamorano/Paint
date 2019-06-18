/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 */
public class MiManejadorLienzo extends LienzoAdapter{
    public void shapeAdded(LienzoEvent evt){
        System.out.println("Figura " + evt.getForma().toString() + " añadida");
    }
}
