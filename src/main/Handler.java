package main;

import Entity.Creatures.Display.GameCamera;
import Utils.TestRendering;
import Worlds.World;

/**
 * Created by Admin on 07.08.2017.
 */
public class Handler {

    private Game game;
    private World world;
    private TestRendering testRendering;

    public Handler(Game game){
        this.game = game;
        testRendering = new TestRendering(this);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public World getWorld() {
        if(world!=null){
            return world;
        }
        else throw new NullPointerException("переменная world пустая ");
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public TestRendering getTestRendering() {
        return testRendering;
    }
}
