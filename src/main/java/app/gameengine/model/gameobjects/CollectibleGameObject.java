package app.gameengine.model.gameobjects;

import app.gameengine.Level;
import app.gameengine.model.physics.Vector2D;

public abstract class CollectibleGameObject extends DynamicGameObject{
    private String itemID;
    public CollectibleGameObject(Vector2D location,String itemID){
        super(location,10);
        this.itemID = itemID;
    }
    public String getItemID(){
        return itemID;
    }
    @Override
    public void takeDamage(int damage){
        return;
    }
    abstract void use(Level level);
}
