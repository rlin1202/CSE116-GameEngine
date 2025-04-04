package app.gameengine.model.gameobjects;

import app.gameengine.model.physics.Vector2D;

public abstract class DynamicGameObject extends GameObject {

    protected Vector2D velocity = new Vector2D(0.0, 0.0);

    private Vector2D orientation = new Vector2D(0.0, 1.0);
    private int maxHP;
    private int currentHP;

    private boolean onGround = false;

    public DynamicGameObject(Vector2D location, int maxHP) {
        super(location);
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getHP() {
        return currentHP;
    }

    public void setHP(int hp) {
        if (hp > maxHP){
            currentHP = maxHP;
        }else{
            currentHP = hp;
        }
    }

    public void takeDamage (int damage){
        if (damage > 0){
            currentHP-=damage;
        }
    }

    public Vector2D getOrientation() {
        return orientation;
    }

    public Vector2D getVelocity() {
        return this.velocity;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    @Override
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    @Override
    public void revive() {
        super.revive();
    }

    @Override
    public void collideWithStaticObject(StaticGameObject otherObject) {

    }

    @Override
    public void collideWithDynamicObject(DynamicGameObject otherObject) {

    }

}
