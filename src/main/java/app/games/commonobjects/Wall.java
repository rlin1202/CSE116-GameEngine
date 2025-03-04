package app.games.commonobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.gameobjects.StaticGameObject;
import app.gameengine.model.physics.Vector2D;

import java.util.Vector;

/**
 * A wall object the player can collide with, serves as a building block
 * for your levels.
 */
public class Wall extends StaticGameObject {

    public Wall(int x, int y) {
        super(x, y);
        this.spriteSheetFilename = "Ground/Cliff.png";
        this.defaultSpriteLocation = new SpriteLocation(3, 0);
    }

    public void collideWithDynamicObject(DynamicGameObject gameObject){
        double gameObjectX = gameObject.getLocation().getX();
        double gameObjectX2 = gameObject.getLocation().getX() + gameObject.getDimensions().getX();

        double gameObjectY = gameObject.getLocation().getY();
        double gameObjectY2 = gameObject.getLocation().getY() + gameObject.getDimensions().getY();

        double wallX = this.x;
        double wallX2 = this.x + this.getDimensions().getX();

        double wallY = this.y;
        double wallY2 = this.y + this.getDimensions().getY();

        double objectDistanceX = Math.min(gameObjectX2 - wallX,wallX2 - gameObjectX);
        double objectDistanceY = Math.min(gameObjectY2 - wallY,wallY2 - gameObjectY);

        if (objectDistanceX < objectDistanceY){
            if (gameObjectX < wallX){
                gameObject.getLocation().setX(gameObjectX - objectDistanceX);
            }else{
                gameObject.getLocation().setX(gameObjectX + objectDistanceX);
            }
        }else{
            if (gameObjectY < wallY){
                gameObject.getLocation().setY(gameObjectY - objectDistanceY);
            }else{
                gameObject.getLocation().setY(gameObjectY + objectDistanceY);
            }
        }
    }
}
