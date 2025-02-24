package app.gameengine.model.physics;

import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.Level;
import app.gameengine.model.gameobjects.StaticGameObject;

import java.util.ArrayList;

public class PhysicsEngine {

    public PhysicsEngine() {}

    public void updateLevel(Level level, double dt) {

        // Update the location of each dynamic object based on its velocity
        for(DynamicGameObject dynamicObject : level.getDynamicObjects()){
            updateObject(dynamicObject, dt);
        }

        // detect all collisions for each dynamic object
        for (int i = 0; i < level.getDynamicObjects().size(); i++) {
            DynamicGameObject dynamicObject1 = level.getDynamicObjects().get(i);

            // check for collisions with other dynamic objects
            // start at i+1 to avoid reporting collision multiple times
            for (int j = i+1; j < level.getDynamicObjects().size(); j++) {
                DynamicGameObject dynamicObject2 = level.getDynamicObjects().get(j);
                if(detectCollision(dynamicObject1.getHitBox(), dynamicObject2.getHitBox())){
                    dynamicObject1.collideWithDynamicObject(dynamicObject2);
                    dynamicObject2.collideWithDynamicObject(dynamicObject1);
                }
            }

            // check for collisions with static objects
            for(StaticGameObject so : level.getStaticObjects()){
                if(detectCollision(so.getHitBox(), dynamicObject1.getHitBox())){
                    so.collideWithDynamicObject(dynamicObject1);
                    dynamicObject1.collideWithStaticObject(so);
                }
            }
        }

    }

    public void updateObject(DynamicGameObject dynamicObject, double dt){
        dynamicObject.getLocation().setX(dynamicObject.getLocation().getX() + dynamicObject.getVelocity().getX()*dt);
        dynamicObject.getLocation().setY(dynamicObject.getLocation().getY() + dynamicObject.getVelocity().getY()*dt);
    }

    public boolean detectCollision(Hitbox hb1, Hitbox hb2){
        // TODO: return true if the 2 hitboxes overlap; false otherwise

        /*first check if hb1 and hb2 overlap
        * if hb1s x2 is less than hb2s x1 they are not overlapping
        * if hb2s y1 is greater than hb1s y2 they are not overlapping*/

        double hb1X = hb1.getLocation().getX();
        double hb1X2 = hb1.getLocation().getX() + hb1.getDimensions().getX();

        double hb1Y = hb1.getLocation().getY();
        double hb1Y2 = hb1.getLocation().getY() + hb1.getDimensions().getY();

        double hb2X = hb2.getLocation().getX();
        double hb2X2 = hb2.getLocation().getX() + hb2.getDimensions().getX();

        double hb2Y = hb2.getLocation().getY();
        double hb2Y2 = hb2.getLocation().getY() + hb2.getDimensions().getY();

        if (hb2X >= hb1X  && hb2X <= hb1X2){
            if (hb2Y >= hb1Y && hb2Y <= hb1Y2){
                return true;
            }else if (hb2Y2 >= hb1Y && hb2Y2 <= hb1Y2){
                return true;
            }else{
                return false;
            }
        }else if( hb2X2 >= hb1X && hb2X2 <= hb1X2){
            if (hb2Y >= hb1Y && hb2Y <= hb1Y2){
                return true;
            }else if (hb2Y2 >= hb1Y && hb2Y2 <= hb1Y2){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
