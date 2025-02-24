package app.tests;

import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Hitbox;
import app.gameengine.model.physics.PhysicsEngine;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Wall;
import javafx.util.Pair;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TestTask1 {

    static final double EPSILON = 0.0001;

    // TODO: write your tests here

    public void comparePlayers (Player player1, Player player2){
        assertEquals(player1.getLocation().getX() ,player2.getLocation().getX(), EPSILON);
        assertEquals(player1.getLocation().getY() , player2.getLocation().getY(),EPSILON);

        assertEquals(player1.getOrientation().getX() ,player2.getOrientation().getX(),EPSILON);
        assertEquals(player1.getOrientation().getY(),player2.getOrientation().getY(),EPSILON);

        assertEquals(player1.getVelocity().getX() ,player2.getVelocity().getX(),EPSILON);
        assertEquals(player1.getVelocity().getY(),player2.getVelocity().getY(),EPSILON);

        assertTrue(player1.getHP() == player2.getHP());
        assertTrue(player1.getMaxHP() == player2.getMaxHP());
    }

    @Test
    public void testTakeDamage(){
        Vector2D location = new Vector2D(0.0,0.0);
        Player player1 = new Player(location,100);
        Player player2 = new Player(location,100);
        comparePlayers(player1,player2);

        player1.setHP(40);
        assertTrue(player1.getHP() == 40);

        player2.takeDamage(60);
        comparePlayers(player1,player2);

        player2.takeDamage(-1);
        assertTrue(player2.getHP() == 40);

        player2.takeDamage(100);
        assertTrue(player2.getHP() == -60);
    }

    @Test
    public void testUpdateObjects(){
        Vector2D location = new Vector2D(5.0,1.0);
        Player player1 = new Player(location,100);

        PhysicsEngine test = new PhysicsEngine();

        player1.getVelocity().setX(2.0);
        player1.getVelocity().setY(3.0);

        test.updateObject(player1,5.0);

        assertEquals(player1.getLocation().getX(),15.0,EPSILON);
        assertEquals(player1.getLocation().getY(),16.0,EPSILON);

        test.updateObject(player1,-4.5);

        assertEquals(player1.getLocation().getX(),6.0,EPSILON);
        assertEquals(player1.getLocation().getY(),2.5,EPSILON);
    }

    @Test
    public void testDetectCollision(){
        Vector2D location = new Vector2D(6.0,2.0);
        Vector2D dimensions = new Vector2D(1.0,1.0);
        Hitbox hb1 = new Hitbox(location,dimensions);

        Vector2D location2 = new Vector2D(9.0,3.0);
        Vector2D dimensions2 = new Vector2D(1.0,1.0);
        Hitbox hb2 = new Hitbox(location2,dimensions2);

        PhysicsEngine test = new PhysicsEngine();

        assertFalse(test.detectCollision(hb1, hb2));

        Vector2D location3 = new Vector2D(6.5,2.5);
        Vector2D dimensions3 = new Vector2D(1.0,1.0);
        Hitbox hb3 = new Hitbox(location3,dimensions3);

        assertTrue(test.detectCollision(hb1,hb3));
        assertTrue(test.detectCollision(hb3,hb1));
    }

    @Test
    public void testWallCollisionsSimple() {
        // we give you the tests for wall collisions. Don't change them
        //
        // However, you should read through these tests to better understand what you should
        // be testing for and how you should be testing
        Player player = new Player(new Vector2D(0, 0), 10);
        Wall w1 = new Wall(1, 0);
        Wall w2 = new Wall(0, 1);
        Wall w3 = new Wall(-1, 0);
        Wall w4 = new Wall(0, -1);

        // Move right
        player.getLocation().setX(0.5);
        player.getLocation().setY(0);
        w1.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);

        // Move down
        player.getLocation().setX(0);
        player.getLocation().setY(0.5);
        w2.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);

        // Move left
        player.getLocation().setX(-0.5);
        player.getLocation().setY(0);
        w3.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);

        // Move up
        player.getLocation().setX(0);
        player.getLocation().setY(-0.5);
        w4.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);
    }

    @Test
    public void testWallCollisionsComplex() {
        Player player = new Player(new Vector2D(0.0, 0.0), 10);
        Wall w1 = new Wall(5, 2);

        player.getLocation().setX(4.5);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(4.5, player.getLocation().getX(), EPSILON);
        assertEquals(1.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.0);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(5.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.5);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(5.5, player.getLocation().getX(), EPSILON);
        assertEquals(1.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.2, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(1.5);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.5, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(2.5);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.5, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(2.8);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.8, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.2);
        player.getLocation().setY(2.8);
        w1.collideWithDynamicObject(player);
        assertEquals(5.2, player.getLocation().getX(), EPSILON);
        assertEquals(3.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(4.2);
        player.getLocation().setY(2.7);
        w1.collideWithDynamicObject(player);
        assertEquals(4.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.7, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(4.2);
        player.getLocation().setY(2.0);
        w1.collideWithDynamicObject(player);
        assertEquals(4.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(4.2);
        player.getLocation().setY(1.5);
        w1.collideWithDynamicObject(player);
        assertEquals(4.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.5, player.getLocation().getY(), EPSILON);
    }

}
