package Utils;

import Tiles.Tile;
import main.Handler;

import java.awt.*;

/**
 * Created by Admin on 10.08.2017.
 */
public class TestRendering {

    private Handler handler;
    private int tX;
    private int tY;

    public TestRendering(Handler handler){
        this.handler = handler;
        tX = 0;
        tY = 0;
    }

    public void visualiseCollisionTile(Graphics graphics){
        if(!TestFetures.showCollisionTile()){
            return;
        }
        graphics.setColor(Color.red);
        graphics.drawRect(
                tX * Tile.TILEWIDTH + (int)handler.getGameCamera().getxOffset(),
                tY * Tile.TILEHEIGHT  + (int)handler.getGameCamera().getyOffset(),
                 Tile.TILEWIDTH,
                 Tile.TILEHEIGHT
        );

    }

    public void testRendering(Graphics graphics){
        visualiseCollisionTile(graphics);
    }

    public void settX(int tX) {
        this.tX = tX;
    }

    public void settY(int tY) {
        this.tY = tY;
    }

    public void setCollisionTileCoord(int x, int y) {
        tX = x;
        tY = y;
    }
}


