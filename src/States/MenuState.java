package States;

import Entity.Creatures.Display.Sprites.Assets.PlayerAssets;
import main.Handler;

import java.awt.*;

/**
 * Created by Admin on 17.07.2017.
 */
public class MenuState extends State {
    public MenuState(Handler handler){
        super(handler);
    }

    @Override
    public void tick() {
      if(handler.getMouseManager().rightPressed && handler.getMouseManager().leftPressed){
          State.setCurrentState(handler.getGame().gameState);
      }
    }

    @Override
    public void render(Graphics graphics) {
      graphics.drawImage(PlayerAssets.defaultPlayerSprite, handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),null);
    }
}
