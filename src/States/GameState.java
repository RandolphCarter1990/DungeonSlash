package States;

import Worlds.World;
import main.Handler;

import java.awt.*;

/**
 * Created by Admin on 17.07.2017.
 */
public class GameState extends State {
    private World world;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler,"res/Worlds/Worlds1.txt");
        handler.setWorld(world);

    }

    public void tick() {
        world.tick();
    }

    public void render(Graphics graphics) {
        world.render(graphics);
        handler.getTestRendering().testRendering(graphics);
    }


}
