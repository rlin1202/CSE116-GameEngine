package app.games.topdownobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.physics.Vector2D;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerAxeProjectile extends Projectile{
    public PlayerAxeProjectile(Vector2D location){
        super(location,6);
        this.spriteSheetFilename = "Objects/Axe.png";
        this.animations.put("default",new ArrayList<>(Arrays.asList(
                new SpriteLocation(0,0),
                new SpriteLocation(1,0),
                new SpriteLocation(2,0),
                new SpriteLocation(3,0),
                new SpriteLocation(0,1),
                new SpriteLocation(1,1),
                new SpriteLocation(2,1),
                new SpriteLocation(3,1)
        )));
    }
}
