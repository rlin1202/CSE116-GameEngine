package app.tests;

import app.gameengine.Level;
import app.gameengine.model.ai.Decision;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class Task4Helper extends Decision {
    private boolean bool;

    public Task4Helper(boolean bool, String name){
        super(name);
        this.bool = bool;
    }

    @Override
    public void doAction(DynamicGameObject gameObject, Level level, double dt){
        gameObject.setHP(100);
    }

    @Override
    public boolean decide(DynamicGameObject gameObject, Level level, double dt){
        return this.bool;
    }
}
