package Entity.Creatures.Display.Sprites.Assets;

import Entity.Creatures.Display.Sprites.SpriteSheet;
import Utils.ImageLoader;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Admin on 12.08.2017.
 */
public class PlayerAssets extends Assets {
    public static BufferedImage[] player;
    public static BufferedImage defaultPlayerSprite;

    public static void init() throws IOException {
        SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/spritesheet.png"));
        player = new BufferedImage[2];
        defaultPlayerSprite = spriteSheet.crop(7 * SPRITE_HIGHT * 2,3 * SPRITE_HIGHT * 2,SPRITE_WIDTH * 2,SPRITE_HIGHT * 2);
        player[0] = spriteSheet.crop(7 * SPRITE_HIGHT * 2,3 * SPRITE_HIGHT * 2,SPRITE_WIDTH * 2,SPRITE_HIGHT * 2);
        player[1] = spriteSheet.crop(7 * SPRITE_HIGHT * 2,3 * SPRITE_HIGHT * 2,SPRITE_WIDTH * 2,SPRITE_HIGHT * 2);
    }

}
