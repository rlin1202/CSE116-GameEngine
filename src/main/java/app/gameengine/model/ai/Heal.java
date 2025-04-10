package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class Heal extends Decision{
    private int healAmount;
    private double cooldown;
    private double timeSpent;
    public Heal(String name,int healAmount,double cooldown){
        super(name);
        this.healAmount = healAmount;
        this.cooldown = cooldown;
    }
    @Override
    public void doAction(DynamicGameObject gameObject, Level level, double dt){
        this.timeSpent += dt;
        if(timeSpent >= cooldown){
            gameObject.setHP(gameObject.getHP() + healAmount);
            timeSpent = 0;
        }
        gameObject.getLocation().setX(0);
        gameObject.getLocation().setY(0);
    }
}
