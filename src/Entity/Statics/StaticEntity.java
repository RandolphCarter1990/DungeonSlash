package Entity.Statics;

import Entity.Entity;
import main.Handler;

/**
 * Created by Admin on 10.08.2017.
 */
public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }

}
