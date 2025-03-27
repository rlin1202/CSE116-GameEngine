package app.games.platformerobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.games.commonobjects.Wall;

public class PlatformerWall extends Wall {
    public PlatformerWall(int x, int y) {
        super(x, y);
        this.spriteSheetFilename = "Ground/Cliff.png";
        this.defaultSpriteLocation = new SpriteLocation(4,0);
    }

    @Override
    public void collideWithDynamicObject(DynamicGameObject gameObject){
        double gameObjectX = gameObject.getLocation().getX();
        double gameObjectX2 = gameObject.getLocation().getX() + gameObject.getDimensions().getX();

        double gameObjectY = gameObject.getLocation().getY();
        double gameObjectY2 = gameObject.getLocation().getY() + gameObject.getDimensions().getY();

        double wallX = this.x;
        double wallX2 = this.x + this.getDimensions().getX();

        double wallY = this.y;
        double wallY2 = this.y + this.getDimensions().getY();

        super.collideWithDynamicObject(gameObject);
        if (gameObjectX2 < wallX || wallX2 < gameObjectX){
            gameObject.setOnGround(false);
        }else{
            if(gameObjectY2 < wallY || wallY2 < gameObjectY){
                gameObject.setOnGround(false);
            }else{
                gameObject.getVelocity().setY(0);
                gameObject.setOnGround(true);
            }
        }
    }
}
