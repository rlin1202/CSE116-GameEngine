package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class Decision {
    private String name;
    public Decision(String name){
        setName(name);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public boolean decide(DynamicGameObject gameObject, Level level, double dt){
        return false;
    }
    public void doAction(DynamicGameObject gameObject, Level level, double dt){
        return;
    }
}
