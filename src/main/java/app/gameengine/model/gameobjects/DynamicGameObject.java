package app.gameengine.model.gameobjects;

import app.gameengine.model.physics.Vector2D;

public abstract class DynamicGameObject extends GameObject {

    protected Vector2D velocity = new Vector2D(0.0, 0.0);

    public DynamicGameObject(Vector2D location, int maxHP) {
        super(location);
    }

    public int getMaxHP() {
        return 0;
    }

    public int getHP() {
        return 0;
    }

    public void setHP(int hp) {

    }

    public Vector2D getOrientation() {
        return new Vector2D(0.0, -1.0);
    }

    public Vector2D getVelocity() {
        return this.velocity;
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
