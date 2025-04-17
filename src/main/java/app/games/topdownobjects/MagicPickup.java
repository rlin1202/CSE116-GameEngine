package app.games.topdownobjects;

import app.gameengine.Level;
import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.CollectibleGameObject;
import app.gameengine.model.physics.Vector2D;

public class MagicPickup extends CollectibleGameObject {
    public MagicPickup(Vector2D location) {
        super(location,"Magic");
        this.spriteSheetFilename = "User Interface/Icons-Essentials.png";
        this.defaultSpriteLocation = new SpriteLocation(1,0);
    }
    @Override
    public void use(Level level){
        level.getPlayer().fireProjectile(new PlayerMagicProjectile(new Vector2D(0.0,0.0)),10,level);
    }
}
