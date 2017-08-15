package Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Admin on 31.07.2017.
 */
public  abstract class Tile {
    protected final int id;
    public static final int TILEWIDTH = 32,
                            TILEHEIGHT = 32;

    public Tile(int id){
        this.id = id;
    }

    public void tick(){

    }

    public void render(Graphics graphics,int x,int y){
     graphics.drawImage(getTexture(),x,y,TILEWIDTH,TILEHEIGHT,null);
    }

    public int getId() {
        return id;
    }

    public boolean isSolid(){
        return false;
    }

    public abstract BufferedImage getTexture();
}
