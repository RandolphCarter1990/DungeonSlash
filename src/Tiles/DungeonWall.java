package Tiles;

import Display.Sprites.Assets.AssetsManager;
import Display.Sprites.Assets.DungeonAssets;

import java.awt.image.BufferedImage;

/**
 * Created by Admin on 31.07.2017.
 */
public class DungeonWall extends Tile {


    public DungeonWall() {
        super(1);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public BufferedImage getTexture() {
        return DungeonAssets.wall;
    }


}
