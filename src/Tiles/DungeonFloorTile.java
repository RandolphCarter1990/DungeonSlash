package Tiles;


import Display.Sprites.Assets.AssetsManager;
import Display.Sprites.Assets.DungeonAssets;

import java.awt.image.BufferedImage;

/**
 * Created by Admin on 31.07.2017.
 */
public class DungeonFloorTile extends Tile {

    private int imageId;

    public DungeonFloorTile() {
        super(0);
        imageId = AssetsManager.getRandomImageIndex(DungeonAssets.dungeonFloor);
    }

    @Override
    public BufferedImage getTexture() {
        return AssetsManager.getImage(DungeonAssets.dungeonFloor,imageId);
    }
}
