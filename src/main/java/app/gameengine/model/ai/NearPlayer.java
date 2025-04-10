package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class NearPlayer extends Decision{
    private double distance;
    public NearPlayer(String name,double distance){
        super(name);
        this.distance = distance;
    }
    @Override
    public boolean decide(DynamicGameObject gameObject, Level level, double dt){
        /*
        gameobject locationx - player locationx
        gameobject locationy -player locationy
        sqrt(x^2 + y^2)
         */

        double x = gameObject.getLocation().getX() - level.getPlayer().getLocation().getX();
        double y = gameObject.getLocation().getY() - level.getPlayer().getLocation().getY();


        if (Math.sqrt(Math.pow(x,2) + Math.pow(y,2)) <= distance){
            return true;
        }else{
            return false;
        }
    }
}
