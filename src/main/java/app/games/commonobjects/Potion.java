package app.games.commonobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;
import jdk.incubator.vector.Vector;

public class Potion extends DynamicGameObject {
    private int healAmount;
    private Vector2D location;

    public Potion(int healAmount,Vector2D location){
        super(location,10);
        this.healAmount = healAmount;
        this.spriteSheetFilename = "User Interface/Icons-Essentials.png";
        if (this.healAmount >= 0){
            this.defaultSpriteLocation = new SpriteLocation(0,1);
        }else{
            this.defaultSpriteLocation = new SpriteLocation(1,1);
        }
    }

    @Override
    public void collideWithDynamicObject(DynamicGameObject otherObject) {
        ;
    }
}
