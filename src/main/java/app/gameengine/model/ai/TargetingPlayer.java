package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;

public class TargetingPlayer extends Decision{
    private double distance;
    public TargetingPlayer(String name,double distance){
        super(name);
        this.distance = distance;
    }
    @Override
    public boolean decide(DynamicGameObject gameObject, Level level, double dt){
        LinkedListNode<Vector2D> pathing = gameObject.getPath();
        Vector2D path = pathing.getValue();
        if(path == null){
            return false;
        }
        while(pathing.getNext() != null){
            path = pathing.getNext().getValue();
            pathing = pathing.getNext();
        }

        double x = path.getX() - level.getPlayer().getLocation().getX();
        double y = path.getY() - level.getPlayer().getLocation().getY();

        if (Math.sqrt(Math.pow(x,2) + Math.pow(y,2)) <= distance){
            return true;
        }else{
            return false;
        }
    }
}
