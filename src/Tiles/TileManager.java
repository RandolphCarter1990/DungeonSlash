package Tiles;

/**
 * Created by Admin on 12.08.2017.
 */
public class TileManager {

    public static Tile createTile(int id){
        if(id==0){
            return new DungeonFloorTile();
        }

        else if(id==1) {
            return new DungeonWall();
        }

        else throw new NullPointerException("Illegal id");
    }

}
