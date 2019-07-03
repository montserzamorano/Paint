package eventos;

import java.util.EventListener;

/**
 * Interfaz LienzoListener. Hereda de EventListener. Permite la gestión
 * de eventos del lienzo.
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */
public interface LienzoListener extends EventListener{
    /**
     * Gestiona la adicción de una nueva figura
     * @param evt LienzoEvent
     */
    public void shapeAdded(LienzoEvent evt);
    /**
     * Gestiona el cambio de una propiedad
     * @param evt LienzoEvent
     */
    public void propertyChange(LienzoEvent evt);    
    /**
     * Gestiona el movimiento del ratón en el lienzo
     * @param evt LienzoEvent
     */
    public void mouseMoved(LienzoEvent evt);
    /**
     * Gestiona la falta de forma en el lienzo
     * @param evt LienzoEvent
     */
    public void faltaForma(LienzoEvent evt);
    /**
     * Gestiona la falta de color de trazo en el lienzo
     * @param evt LienzoEvent
     */    
    public void faltaColorTrazo(LienzoEvent evt);
    /**
     * Gestiona la falta de tipo de línea en el lienzo
     * @param evt LienzoEvent
     */    
    public void faltaTipoLinea(LienzoEvent evt);
    /**
     * Gestiona la falta de tipo de relleno en el lienzo
     * @param evt LienzoEvent
     */    
    public void faltaTipoRelleno(LienzoEvent evt);
    /**
     * Gestiona la falta de color de relleno en el lienzo
     * @param evt LienzoEvent
     */    
    public void faltaColorRelleno(LienzoEvent evt);
     /**
     * Gestiona la falta de color de degradado en el lienzo
     * @param evt LienzoEvent
     */   
    public void faltaColorDegradado(LienzoEvent evt);
    /**
     * Gestiona la activación de un lienzo
     * @param evt LienzoEvent
     */    
    public void lienzoSeleccionado(LienzoEvent evt);
    public void lienzoCerrado(LienzoEvent evt);
}
