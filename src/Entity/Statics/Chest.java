package Entity.Statics;

import Display.Sprites.Assets.DungeonAssets;
import Tiles.Tile;
import main.Handler;
import java.awt.*;

/**
 * Created by Admin on 10.08.2017.
 */
public class Chest extends StaticEntity {

    public Chest(Handler handler, float x, float y){
        super(handler,x * Tile.TILEWIDTH,y * Tile.TILEHEIGHT,Tile.TILEWIDTH,Tile.TILEHEIGHT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
       graphics.drawImage(DungeonAssets.chest,(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()),width,height,null);
    }
}
