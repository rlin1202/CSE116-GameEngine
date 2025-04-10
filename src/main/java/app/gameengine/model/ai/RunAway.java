package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;

import static app.gameengine.model.ai.Pathfinding.findPath;

public class RunAway extends Decision{
    public RunAway(String name){
        super(name);
    }
    @Override
    public void doAction(DynamicGameObject gameObject, Level level, double dt){
        Vector2D enemy = new Vector2D(gameObject.getLocation().getX(), gameObject.getLocation().getY());
        Vector2D player = new Vector2D(level.getPlayer().getLocation().getX(), level.getPlayer().getLocation().getY());
        if (gameObject.getPath() == null) {
            gameObject.setPath(findPath(enemy, player));
        } else if (Math.sqrt(Math.pow(enemy.getX() - gameObject.getPath().getValue().getX(), 2) + Math.pow(enemy.getY() - gameObject.getPath().getValue().getY(), 2)) < 0.01) {
            gameObject.getLocation().setX(gameObject.getPath().getValue().getX());
            gameObject.getLocation().setY(gameObject.getPath().getValue().getY());
            gameObject.setPath(gameObject.getPath().getNext());

        } else {
            if (Math.abs(gameObject.getLocation().getX() - gameObject.getPath().getValue().getX()) > Math.abs(gameObject.getLocation().getY() - gameObject.getPath().getValue().getY())) {
                if(gameObject.getLocation().getX() < gameObject.getPath().getValue().getX()){
                    gameObject.getVelocity().setX(-1.0);
                    gameObject.getVelocity().setY(0.0);
                }else{
                    gameObject.getVelocity().setX(1.0);
                    gameObject.getVelocity().setY(0.0);
                }
            }else{
                if(gameObject.getLocation().getY() < gameObject.getPath().getValue().getY()){
                    gameObject.getVelocity().setX(0.0);
                    gameObject.getVelocity().setY(-1.0);
                }else{
                    gameObject.getVelocity().setX(0.0);
                    gameObject.getVelocity().setY(1.0);
                }
            }
        }
    }
}
