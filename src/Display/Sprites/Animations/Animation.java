package Display.Sprites.Animations;

import Display.Sprites.Assets.PlayerAssets;
import Entity.Creatures.Player;

import java.awt.image.BufferedImage;

/**
 * Created by Admin on 10.08.2017.
 */
public class Animation {

    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames){

        this.speed = speed;
        this.frames = frames;
        index = 0;
        lastTime = System.currentTimeMillis();
    }

    public BufferedImage getCurrentFrame(){
        if( frames[index]!=null)return frames[index];
        else return PlayerAssets.defaultPlayerSprite;
    }

    public void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer>speed){
            index++;
            timer = 0;

            if(index>= frames.length){
                index = 0;
            }
        }
    }

}
