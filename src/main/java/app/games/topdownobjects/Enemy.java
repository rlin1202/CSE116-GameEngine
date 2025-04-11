package app.games.topdownobjects;

import app.gameengine.Level;
import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.ai.DecisionTree;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;

import static app.gameengine.model.ai.Pathfinding.findPath;

/**
 * Basic enemy class.
 *
 * In future tasks, you will develop tools to give enemies more features:
 * like pathfinding, AI, etc.
 */
public class Enemy extends DynamicGameObject {

    private int strength;

    public Enemy(Vector2D location) {
        this(location, 3);
    }

    public Enemy(Vector2D location, int strength) {
        super(location, 10);
        this.strength = strength;
        this.spriteSheetFilename = "Characters/Monsters/Demons/ArmouredRedDemon.png";
        this.defaultSpriteLocation = new SpriteLocation(0, 2);
    }
    /*
    public void update(double time, Level level) {
        Vector2D enemy = new Vector2D(this.getLocation().getX(), this.getLocation().getY());
        Vector2D player = new Vector2D(level.getPlayer().getLocation().getX(), level.getPlayer().getLocation().getY());
        if (path == null) {
            setPath(findPath(enemy, player));
        } else if (Math.sqrt(Math.pow(enemy.getX() - path.getValue().getX(), 2) + Math.pow(enemy.getY() - path.getValue().getY(), 2)) < 0.01) {
            this.getLocation().setX(path.getValue().getX());
            this.getLocation().setY(path.getValue().getY());
            path = path.getNext();
        } else {
            if (Math.abs(this.getLocation().getX() - path.getValue().getX()) > Math.abs(this.getLocation().getY() - path.getValue().getY())) {
                if(this.getLocation().getX() < path.getValue().getX()){
                    this.getVelocity().setX(1.0);
                    this.getVelocity().setY(0.0);
                }else{
                    this.getVelocity().setX(-1.0);
                    this.getVelocity().setY(0.0);
                }
            }else{
                if(this.getLocation().getY() < path.getValue().getY()){
                    this.getVelocity().setX(0.0);
                    this.getVelocity().setY(1.0);
                }else{
                    this.getVelocity().setX(0.0);
                    this.getVelocity().setY(-1.0);
                }
            }
        }
    }
     */

    @Override
    public void collideWithDynamicObject(DynamicGameObject otherObject) {
        if(otherObject.isPlayer()){
            if(otherObject.getInvincibilityFrames() <= 0.0){
                otherObject.takeDamage(this.strength);
                otherObject.setInvincibilityFrames(0.5);
            }
        }
    }

}
