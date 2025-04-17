package app.games.topdownobjects;

import app.gameengine.Level;
import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.CollectibleGameObject;
import app.gameengine.model.physics.Vector2D;

public class AxePickup extends CollectibleGameObject {
    public AxePickup(Vector2D location) {
        super(location,"Axe");
        this.spriteSheetFilename = "Objects/Axe.png";
        this.defaultSpriteLocation = new SpriteLocation(0,0);
    }
    @Override
    public void use(Level level){
        level.getPlayer().fireProjectile(new PlayerAxeProjectile(new Vector2D(0.0,0.0)),5,level);
    }
}
