package app.games.topdownobjects;

import app.gameengine.Level;
import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.CollectibleGameObject;
import app.gameengine.model.physics.Vector2D;

public class PotionPickup extends CollectibleGameObject {
    private int healAmount;
    public PotionPickup(Vector2D location, int healAmount) {
        super(location,"Health Potion");
        this.spriteSheetFilename = "User Interface/Icons-Essentials.png";
        this.defaultSpriteLocation = new SpriteLocation(3,1);
        this.healAmount = healAmount;
    }
    @Override
    public void use(Level level){
        level.getPlayer().setHP(level.getPlayer().getHP()+healAmount);
        removeActiveItem();
    }
}
