package image;
import java.awt.Color;
import java.awt.image.BufferedImage;
import sm.image.BufferedImageOpAdapter;

/**
 *
 * @author Montserrat Rodríguez Zamorano
 * @version 1.1
 */

public class SepiaOp extends BufferedImageOpAdapter{

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
                int sepiaR, sepiaG, sepiaB;
                int srcR, srcG, srcB;
                Color colorSrc = new Color(src.getRGB(x, y));
                Color colorDest;
                //color del pixel
                srcR = colorSrc.getRed();
                srcG = colorSrc.getGreen();
                srcB = colorSrc.getBlue();
                //convertirlo a sepia
                sepiaR = (int) Math.min(255, 0.393*srcR+0.769*srcG+0.189*srcB);
                sepiaG = (int) Math.min(255, 0.349*srcR+0.686*srcG+0.168*srcB);
                sepiaB = (int) Math.min(255, 0.272*srcR+0.534*srcG+0.131*srcB);
                
                colorDest = new Color(sepiaR, sepiaG, sepiaB);
                dest.setRGB(x, y, colorDest.getRGB());
            }
        }
        
        return dest;
    }
    
}
