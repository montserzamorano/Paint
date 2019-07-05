package eventos;

/**
 * Clase LienzoAdapter. Implementa la interfaz LienzoListener. Adaptará
 * la interfaz para la clase MiManejadorLienzo.
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */
public class LienzoAdapter implements LienzoListener{
    /**
    * {@inheritDoc }
    */    
    @Override
    public void shapeAdded(LienzoEvent evt){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
    * {@inheritDoc }
    */    
    @Override
    public void propertyChange(LienzoEvent evt){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
    * {@inheritDoc }
    */  
    @Override
    public void mouseMoved(LienzoEvent evt){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
    * {@inheritDoc }
    */  
    @Override
    public void faltaForma(LienzoEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
    * {@inheritDoc }
    */  
    @Override
    public void faltaColorTrazo(LienzoEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
    * {@inheritDoc }
    */  
    @Override
    public void faltaTipoLinea(LienzoEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
    * {@inheritDoc }
    */  
    @Override
    public void faltaTipoRelleno(LienzoEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
    * {@inheritDoc }
    */  
    @Override
    public void faltaColorRelleno(LienzoEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
    * {@inheritDoc }
    */  
    @Override
    public void faltaColorDegradado(LienzoEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
    * {@inheritDoc }
    */  
    @Override
    public void lienzoSeleccionado(LienzoEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void lienzoCerrado(LienzoEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
