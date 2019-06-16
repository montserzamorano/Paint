/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;
import java.awt.Color;
import java.awt.image.BufferedImage;
import sm.image.BufferedImageOpAdapter;
/**
 *
 * @author PC
 */
public class UmbralizacionOp extends BufferedImageOpAdapter{
    private int umbral;
    public UmbralizacionOp(int umbral){
        this.umbral = umbral;
    }
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
                int srcR, srcG, srcB;
                Color colorSrc = new Color(src.getRGB(x, y));
                //colores del pixel
                srcR = colorSrc.getRed();
                srcG = colorSrc.getGreen();
                srcB = colorSrc.getBlue();
                //intensidad como media de sus componentes
                int intensidad = (srcR + srcG + srcB)/3;
                if(intensidad>=umbral){
                    dest.setRGB(x, y, Color.WHITE.getRGB());
                }
                else{//intensidad < umbral
                    dest.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }
        
        return dest;
    }
    
}