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

        gameObject.getVelocity().setX(0.0);
        gameObject.getVelocity().setY(0.0);
        while(timeSpent >= cooldown){
            gameObject.setHP(gameObject.getHP() + healAmount);
            timeSpent -= cooldown;
        }
    }
}
