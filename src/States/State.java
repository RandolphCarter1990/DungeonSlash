package States;

import main.Game;
import main.Handler;

import java.awt.*;

/**
 * Created by Admin on 17.07.2017.
 */
public abstract class State {

    private static State currentState = null;

    public static void setCurrentState(State currentState) {
        State.currentState = currentState;
    }

    public static State getCurrentState() {
        return currentState;
    }


    protected Handler handler;

    public State(Handler handler){
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);
}
