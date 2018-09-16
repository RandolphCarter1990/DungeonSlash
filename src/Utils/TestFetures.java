package Utils;

import Worlds.World;

import main.Handler;

import java.awt.*;

/**
 * Created by Admin on 09.08.2017.
 */
public class TestFetures {

    private Handler handler;

    public TestFetures(Handler handler) {
        this.handler = handler;
    }

    public static boolean showBounds() {
        return false;
    }

    public static boolean checkBlankSpace() {
        return true;
    }

    public static boolean printPlayerCoordinates() {
        return false;
    }

    public static boolean printFps() {
        return false;
    }

    public static boolean showCollisionTile(){
        return false;
    }
}
