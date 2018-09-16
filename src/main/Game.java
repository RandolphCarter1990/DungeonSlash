package main;

import Entity.Creatures.Display.Display;
import Entity.Creatures.Display.GameCamera;
import Entity.Creatures.Display.Sprites.Assets.AssetsManager;
import States.GameState;
import States.MenuState;
import States.State;
import Utils.TestFetures;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

/**
 * Created by Admin on 15.07.2017.
 */
public class Game implements Runnable {

    private Display display;
    private Thread thread;
    private Graphics graphics;


    private BufferStrategy bufferStrategy;
    public String title;
    private int width,height;

    private boolean running = false;

    public State gameState;
    public State menuState;
    private KeyManager keyManager;
    private MouseManager mouseManager;
    private GameCamera gameCamera;
    private Handler handler;

    public Game(String title,int width,int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init() throws IOException {
        handler = new Handler(this);
        gameCamera = new GameCamera(handler,25,25);
        this.display = new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        AssetsManager.initAllAssets();
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setCurrentState(gameState);
    }

    private void tick(){
        keyManager.tick();
        if(GameState.getCurrentState()!=null){
          State.getCurrentState().tick();
      }
    }

    private void render(){
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        //clear th screen
        graphics.clearRect(0,0,width,height);
        //draw
        if(GameState.getCurrentState()!=null){
            State.getCurrentState().render(graphics);
        }
        //end draw
        bufferStrategy.show();
        //показываем
        graphics.dispose();
    }

    public void run(){
        int fps = 60;
        double timePerTick = 1_000_000_000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (running){
            now = System.nanoTime();
            delta +=(now - lastTime)/ timePerTick;
            timer += now - lastTime;
            lastTime = now;
           if(delta>=1){
               tick();
               render();
               ticks++;
               delta--;
           }
           if(timer >= 1_000_000_000 && TestFetures.printFps()){
               System.out.println("Ticks and Frames:"+ticks);
               ticks = 0;
               timer = 0;
           }
        }

        stop();
    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if (!running)
            return;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
