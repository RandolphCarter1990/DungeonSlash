package Entity.Creatures;

import Entity.Entity;
import Tiles.Tile;
import main.Game;
import main.Handler;

/**
 * Created by Admin on 17.07.2017.
 */
public abstract class Creature extends Entity{

    protected int health;
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64;

    protected float speed;
    protected float xMove,yMove;


    public Creature (Handler handler, float x, float y, int width, int height){
        super(handler,x,y,width,height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    protected boolean collisionWithTile(int x,int y){
        return handler.getWorld().getTile(x,y).isSolid();
    }

    public void move(){
        if (!checkEntityCollisions(xMove,0f)){
        moveX();
        }
        if (!checkEntityCollisions(0f, yMove)){
        moveY();
        }
    }

    public void moveX(){
        if(xMove>0){ //moving right
            int tX = (int) (x + xMove + bounds.x + bounds.width )/ Tile.TILEWIDTH ;
            int upperRightCorner = (int)(y + bounds.y) / Tile.TILEHEIGHT;
            int lowerRightCorner = (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            handler.getTestRendering().setCollisionTileCoord(tX,lowerRightCorner);

                if (!collisionWithTile(tX, upperRightCorner) &&
                    !collisionWithTile(tX, lowerRightCorner) &&
                    x / Tile.TILEWIDTH < handler.getWorld().getWidth() -1
                        ) {
                x += xMove;
            }
        } else if(xMove<0){ //moving left
            int tX = (int) (x + xMove + bounds.x )/ Tile.TILEWIDTH ;
            int upperLeftCorner = (int)(y + bounds.y) / Tile.TILEHEIGHT;
            int lowerLeftCorner = (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            handler.getTestRendering().setCollisionTileCoord(tX,lowerLeftCorner);
                if (!collisionWithTile(tX,upperLeftCorner ) &&
                    !collisionWithTile(tX,lowerLeftCorner ) &&
                      x >= 0) {
                      x += xMove;
                     }
    }
    }

    public void moveY(){
        if(yMove>0){ //going downward
            int tY = (int) (y + yMove + bounds.y + bounds.height ) / Tile.TILEHEIGHT ;
                if (!collisionWithTile((int)(x + bounds.x) /Tile.TILEHEIGHT,tY )&&
                    !collisionWithTile((int)(x + bounds.width + bounds.x) /Tile.TILEHEIGHT,tY ) &&
                        y / Tile.TILEHEIGHT < handler.getWorld().getHeight() - 1
                    ) {
                y += yMove;
            }
        } else if(yMove<0){  //going upward
            int tY = (int) (y + yMove + bounds.y ) / Tile.TILEHEIGHT ;
            if (    !collisionWithTile((int) (x + bounds.x) / Tile.TILEHEIGHT,tY ) &&
                    !collisionWithTile((int) (x+bounds.x + bounds.width) / Tile.TILEHEIGHT,tY ) &&
                    y>=0
                    ) {
                y += yMove;
            }
            }
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

}
