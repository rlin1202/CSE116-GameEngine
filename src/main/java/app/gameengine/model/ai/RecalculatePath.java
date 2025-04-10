package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class RecalculatePath extends Decision{
    public RecalculatePath(String name){
        super(name);
    }
    @Override
    public void doAction(DynamicGameObject gameObject, Level level, double dt){
        gameObject.getVelocity().setX(0);
        gameObject.getVelocity().setY(0);
        gameObject.setPath(Pathfinding.findPath(gameObject.getLocation(),level.getPlayer().getLocation()));
    }
}
