package Entity;

import Entity.Creatures.Player;
import main.Handler;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Admin on 12.08.2017.
 */
public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList <Entity> entityList;

    public EntityManager(Handler handler,Player player){
        this.handler = handler;
        this.player = player;
        entityList = new ArrayList <Entity>();
        addEntity(player);
    }

    public void tick(){
        for(Entity entity:entityList){
            entity.tick();
        }
    }

    public void render(Graphics graphics){

        for(Entity entity:entityList){
            entity.render(graphics);
        }
    }

    public void addEntity(Entity entity){
        entityList.add(entity);
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList <Entity> getEntityList() {
        return entityList;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}