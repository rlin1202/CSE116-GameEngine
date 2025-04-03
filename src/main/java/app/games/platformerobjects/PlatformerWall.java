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
        super.collideWithDynamicObject(gameObject);
        double gameObjectX = gameObject.getLocation().getX();
        double gameObjectX2 = gameObject.getLocation().getX() + gameObject.getDimensions().getX();
        double gameObjectY = gameObject.getLocation().getY();
        double wallX = this.x;
        double wallX2 = this.x + this.getDimensions().getX();
        double wallY = this.y;

        if(gameObjectX < wallX2 && gameObjectX2 > wallX){
            gameObject.getVelocity().setY(0.0);
            if(gameObjectY < wallY){
                gameObject.setOnGround(true);
            }
        }
    }
}
