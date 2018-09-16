package Entity.Creatures.Display.Sprites.Assets;

import Entity.Creatures.Display.Sprites.SpriteSheet;
import Utils.ImageLoader;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Admin on 12.08.2017.
 */
public class DungeonAssets extends Assets {

    public static BufferedImage wall,chest;
    public static ArrayList<BufferedImage> dungeonFloor;

    public static void init() throws IOException {
        SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/spritesheet2.png"));
        dungeonFloor = new ArrayList <>();
        dungeonFloor.add(0, spriteSheet.crop(4 * SPRITE_HIGHT, 9 * SPRITE_HIGHT, SPRITE_WIDTH, SPRITE_HIGHT));
        dungeonFloor.add(1, spriteSheet.crop(0 * SPRITE_HIGHT, 21 * SPRITE_HIGHT, SPRITE_WIDTH, SPRITE_HIGHT));
        dungeonFloor.add(2, spriteSheet.crop(1 * SPRITE_HIGHT, 21 * SPRITE_HIGHT, SPRITE_WIDTH, SPRITE_HIGHT));
        dungeonFloor.add(3, spriteSheet.crop(2 * SPRITE_HIGHT, 21 * SPRITE_HIGHT, SPRITE_WIDTH, SPRITE_HIGHT));
        dungeonFloor.add(4, spriteSheet.crop(0 * SPRITE_HIGHT, 20 * SPRITE_HIGHT, SPRITE_WIDTH, SPRITE_HIGHT));
        dungeonFloor.add(5, spriteSheet.crop(1 * SPRITE_HIGHT, 20 * SPRITE_HIGHT, SPRITE_WIDTH, SPRITE_HIGHT));
        dungeonFloor.add(6, spriteSheet.crop(2 * SPRITE_HIGHT, 20 * SPRITE_HIGHT, SPRITE_WIDTH, SPRITE_HIGHT));
        wall = spriteSheet.crop(1 * SPRITE_WIDTH ,17 * SPRITE_HIGHT,SPRITE_WIDTH,SPRITE_HIGHT);
        chest = spriteSheet.crop(27 * SPRITE_HIGHT ,2 * SPRITE_HIGHT,SPRITE_WIDTH,SPRITE_HIGHT);
    }


}
