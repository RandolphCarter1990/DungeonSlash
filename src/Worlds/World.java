package Worlds;

import Entity.Creatures.Player;
import Entity.EntityManager;
import Entity.Statics.Chest;
import Tiles.Tile;
import Tiles.TileManager;
import Utils.Util;
import main.Game;
import main.Handler;

import java.awt.*;

import static Utils.Util.loadFileAsString;
import static Utils.Util.parseInt;


/**
 * Created by Admin on 02.08.2017.
 */
public class World {

    private Handler handler;
    private int width,height;
    private Tile [][] tiles;
    private int spawnX,spawnY;
    private EntityManager entityManager;

    public World(Handler handler,String path){
        this.handler = handler;
        entityManager = new EntityManager(handler,new Player(handler,100,100));
        loadWorld(path);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
        entityManager.addEntity(new Chest(handler,10,5));
    }
    private void loadWorld(String path){
        String file = loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = parseInt(tokens[0]);
        height = parseInt(tokens[1]);
        spawnX = parseInt(tokens[2]);
        spawnY = parseInt(tokens[3]);

        tiles = new Tile[width][height];

        for (int y = 0; y < width; y++) {
            System.out.println();
            for (int x = 0; x < height; x++) {
                 try{
                     tiles[x][y] = TileManager.createTile(parseInt(tokens[(x+y*width)+4]));
                 } catch (NumberFormatException e){
                     System.out.println("Empty tile field");
                     tiles[x][y] = TileManager.createTile(0);
                 }
                 System.out.print(tiles[x][y].getId());
            }
        }
        System.out.println();
    }

    public void tick(){
      entityManager.tick();
    }

    public void render(Graphics graphics){
        int xStart = (int)(Math.max(0,handler.getGameCamera().getxOffset())/Tile.TILEWIDTH );
        int yStart = (int)(Math.max(0,handler.getGameCamera().getyOffset())/Tile.TILEHEIGHT );
        int xEnd = (int)Math.min(width,(handler.getGameCamera().getxOffset() + handler.getGame().getWidth()) / Tile.TILEWIDTH + 1 );
        int yEnd = (int)Math.min(height,(handler.getGameCamera().getyOffset() + handler.getGame().getHeight()) / Tile.TILEHEIGHT + 1 );
        for (int y = yStart; y < yEnd ; y++) {
            for (int x = xStart; x < xEnd ; x++) {
               getTile(x,y).render(graphics,(int)(x*Tile.TILEWIDTH-handler.getGameCamera().getxOffset()),
                       (int) (y*Tile.TILEHEIGHT-handler.getGameCamera().getyOffset()));
            }
        }

        entityManager.render(graphics);
    }

    public Tile getTile(int x,int y){
         if(x<0||y<0||x>=width||y>=height){
           if(x<0) System.out.println("x= "+x);
             if(y<0) System.out.println("y= "+y);
             if(x>=width) System.out.println("x= "+x);
             if(y>=width) System.out.println("y= "+y);
             System.out.println("null tile1");
           return TileManager.createTile(0);
       }

        Tile tile = tiles[x][y];
       if(tile==null) {
           System.out.println("null tile2");
           return TileManager.createTile(0);
       }
       return tile;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
