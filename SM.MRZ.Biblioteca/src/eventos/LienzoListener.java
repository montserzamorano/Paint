
package eventos;

import java.util.EventListener;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 */
public interface LienzoListener extends EventListener{
    public void shapeAdded(LienzoEvent evt);
    public void propertyChange(LienzoEvent evt);
    public void mouseMoved(LienzoEvent evt);
}
