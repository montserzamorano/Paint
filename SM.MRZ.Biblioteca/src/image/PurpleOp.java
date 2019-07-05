package image;
import java.awt.Color;
import java.awt.image.BufferedImage;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase PurpleOp. Hereda de BufferedImageOpAdapter. Implementa una operación
 * punto a punto sobre la imagen que tinta la imagen de morado.
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public class PurpleOp extends BufferedImageOpAdapter{
    /**
     * {@inheritDoc }
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if(src == null){
            throw new NullPointerException("src image is null");
        }
        if(dest == null){
            dest = createCompatibleDestImage(src, null);
        }
        
        for(int x=0; x<src.getWidth(); x++){
            for(int y=0; y<src.getHeight(); y++){
                int destR, destG, destB;
                int srcR, srcG, srcB;
                Color colorSrc = new Color(src.getRGB(x, y));
                Color colorDest;
                //color del pixel
                srcR = colorSrc.getRed();
                srcG = colorSrc.getGreen();
                srcB = colorSrc.getBlue();
                //operacion componente a componente
                destR = (int) Math.min(255,1.3*srcR);
                destG = (int) Math.min(255,0.2*srcG);
                destB = (int) Math.min(255,1.5*srcB);
                
                colorDest = new Color(destR, destG, destB);
                dest.setRGB(x, y, colorDest.getRGB());
            }
        }
        
        return dest;
    }
    
}