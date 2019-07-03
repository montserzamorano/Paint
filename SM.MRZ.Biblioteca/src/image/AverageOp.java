package image;
import java.awt.Color;
import java.awt.image.BufferedImage;
import sm.image.BufferedImageOpAdapter;
/**
 * 
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */
public class AverageOp extends BufferedImageOpAdapter{
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
                //operacion pixel a pixel
                destR = Math.min(255,(srcR+srcG+srcB)/2);
                destG = Math.min(255,(srcR+srcG+srcB)/2);
                destB = Math.min(255,(srcR+srcG+srcB)/2);
                
                colorDest = new Color(destR, destG, destB);
                dest.setRGB(x, y, colorDest.getRGB());
            }
        }
        
        return dest;
    }
    
}