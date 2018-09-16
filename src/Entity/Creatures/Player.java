package Entity.Creatures;

import Entity.Creatures.Display.Sprites.Assets.PlayerAssets;
import Entity.Creatures.Display.Sprites.Animations.Animation;
import Utils.TestFetures;
import main.Handler;

import java.awt.*;

/**
 * Created by Admin on 17.07.2017.
 */
public class Player extends Creature {

    private Animation animation;

    public Player(Handler handler, float x, float y){
        super(handler,x,y,Creature.DEFAULT_CREATURE_WIDTH,DEFAULT_CREATURE_HEIGHT);
        bounds.x = 16;
        bounds.y = 16;
        bounds.width = 32;
        bounds.height = 32;
        animation = new Animation(500, PlayerAssets.player);
    }

    @Override
    public void tick() {
        animation.tick();
        getInput();
        move();
        handler.getGame().getGameCamera().centerOnEntity(this);
        printPlayerCoordinates();
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getGame().getKeyManager().up){
            yMove = -speed;
        }


        if(handler.getGame().getKeyManager().down){
            yMove = speed;
        }


        if(handler.getGame().getKeyManager().left){
            xMove = -speed;
        }


        if(handler.getGame().getKeyManager().right){
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(animation.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
        graphics.setColor(Color.red);
        if(TestFetures.showBounds()){
            graphics.fillRect(  (int)(x+bounds.x - handler.getGameCamera().getxOffset()),
                    (int)(y+bounds.y - handler.getGameCamera().getyOffset()),
                    bounds.width,bounds.height);
        }

        }

        public void printPlayerCoordinates(){
               if(TestFetures.printPlayerCoordinates()){
                   System.out.println(x + " " + y );
               }
        }

}

