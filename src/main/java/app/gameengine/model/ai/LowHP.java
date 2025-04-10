package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class LowHP extends Decision {
    private int hpThreshold;
    public LowHP(String name,int hpThreshold) {
        super(name);
        this.hpThreshold = hpThreshold;
    }
    @Override
    public boolean decide(DynamicGameObject gameObject, Level level, double dt){
        if(gameObject.getHP() <= hpThreshold){
            return true;
        }else{
            return false;
        }
    }
}
