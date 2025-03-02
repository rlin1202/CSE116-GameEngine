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

   public Vector2D findOverlap (DynamicGameObject gameObject){
       double gameObjectX = gameObject.getLocation().getX();
       double gameObjectX2 = gameObject.getLocation().getX() + gameObject.getDimensions().getX();

       double gameObjectY = gameObject.getLocation().getY();
       double gameObjectY2 = gameObject.getLocation().getY() + gameObject.getDimensions().getY();

       double wallX = this.getLocation().getX();
       double wallX2 = this.getLocation().getX() + this.getDimensions().getX();

       double wallY = this.getLocation().getY();
       double wallY2 = this.getLocation().getY() + this.getDimensions().getY();

       Vector2D objectOverlap = new Vector2D(0.0,0.0);

       if (gameObjectX < wallX2 && gameObjectX2 > wallX) {
           objectOverlap.setX(Math.min(gameObjectX2 - wallX, wallX2 - gameObjectX));
       }

       if (gameObjectY < wallY2 && gameObjectY2 > wallY) {
           objectOverlap.setY(Math.min(gameObjectY2 - wallY, wallY2 - gameObjectY));
       }
       return objectOverlap;
   }
    public void collideWithDynamicObject(DynamicGameObject gameObject){
        double gameObjectX = gameObject.getLocation().getX();
        double gameObjectY = gameObject.getLocation().getY();

        double wallX = this.getLocation().getX();
        double wallY = this.getLocation().getY();


        double objectOverlapX = findOverlap(gameObject).getX();
        double objectOverlapY = findOverlap(gameObject).getY();


        if (objectOverlapX < objectOverlapY) {
            if (gameObjectX < wallX) {
                gameObject.getLocation().setX(gameObjectX - objectOverlapX);
            }else{
                gameObject.getLocation().setX(gameObjectX + objectOverlapX);
            }
        } else if (objectOverlapX > objectOverlapY) {
            if (gameObjectY < wallY) {
                gameObject.getLocation().setY(gameObjectY - objectOverlapY);
            }else{
                gameObject.getLocation().setY(gameObjectY + objectOverlapY);
            }
        }
    }
}
