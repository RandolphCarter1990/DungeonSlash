package Display.Sprites.Assets;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Admin on 12.08.2017.
 */
public class AssetsManager {

    public static void initAllAssets() throws IOException {
        DungeonAssets.init();
        PlayerAssets.init();
    }

    public static int getRandomImageIndex (ArrayList<BufferedImage> images){
        return (int) (Math.random() * images.size());
    }

    public static BufferedImage getImage(ArrayList<BufferedImage> images,int index){
        return images.get(index);
    }
}
