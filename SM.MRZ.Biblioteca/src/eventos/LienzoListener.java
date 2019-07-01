package eventos;

import java.util.EventListener;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */
public interface LienzoListener extends EventListener{
    public void shapeAdded(LienzoEvent evt);
    public void propertyChange(LienzoEvent evt);
    public void mouseMoved(LienzoEvent evt);
    public void faltaForma(LienzoEvent evt);
    public void faltaColorTrazo(LienzoEvent evt);
    public void faltaTipoLinea(LienzoEvent evt);
    public void faltaTipoRelleno(LienzoEvent evt);
    public void faltaColorRelleno(LienzoEvent evt);
    public void faltaColorDegradado(LienzoEvent evt);
    public void lienzoSeleccionado(LienzoEvent evt);
    public void figuraSeleccionada(LienzoEvent evt);
}
