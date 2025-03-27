package app.tests;

import org.junit.Test;
import static org.junit.Assert.*;
import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Vector2D;
import app.games.platformerobjects.PlatformerWall;

public class TestTask3 {
    @Test
    public void testPlatformerWallCollision(){
        Player player = new Player(new Vector2D(1.0,1.0),100);
        PlatformerWall wall = new PlatformerWall(1,2);
        player.getVelocity().setY(1.0);
        wall.collideWithDynamicObject(player);
        assertTrue(player.isOnGround());
        assertEquals(player.getVelocity().getY(), 0.0,0.001);
    }
}
