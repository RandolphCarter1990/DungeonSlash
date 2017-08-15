package Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Admin on 15.07.2017.
 */
public class ImageLoader {
    public static BufferedImage loadImage(String path) throws IOException {
       try {
           return ImageIO.read(ImageLoader.class.getResource(path));
       } catch (IOException e){
           System.out.println("Error in image reader");
           return null;
       }
    }
}
