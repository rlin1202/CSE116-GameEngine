package app.gameengine.model.physics;

import app.gameengine.model.gameobjects.DynamicGameObject;

public class PhysicsEngineWithGravity extends PhysicsEngine{
    private double acceleration;

    public PhysicsEngineWithGravity(double acceleration){
        super();
        this.acceleration = acceleration;
    }
    @Override
    public void updateObject(DynamicGameObject dynamicObject, double dt){
        dynamicObject.getVelocity().setY(dynamicObject.getVelocity().getY() + dt*acceleration);
        super.updateObject(dynamicObject, dt);
    }
}
