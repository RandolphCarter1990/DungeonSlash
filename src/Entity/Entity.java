package Entity;

import main.Game;
import main.Handler;

import java.awt.*;

/**
 * Created by Admin on 17.07.2017.
 */
public abstract class Entity {

    protected Handler handler;
    protected float x,y;
    protected int width,height;
    protected Rectangle bounds;

    public Entity(Handler handler, float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;

        bounds = new Rectangle(0,0,width,height);
    }

    public Rectangle getColliionBounds(float xOffset,float yOffset){
        return new Rectangle((int)(x + bounds.x + xOffset),(int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for (Entity entity : handler.getWorld().getEntityManager().getEntityList() ){
            if(entity.equals(this)){
                continue;
            }
            if(entity.getColliionBounds(0f,0f).intersects(getColliionBounds(xOffset,yOffset))){
                return true;
            }
        }
        return false;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);
}
