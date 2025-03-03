package app.tests;

import app.gameengine.model.gameobjects.DynamicGameObject;
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
    public void testDynamicObjectConstructor(){
        Vector2D location = new Vector2D(0.0,5.0);
        Player player1 = new Player(location,100);

        assertTrue(player1.getHP() == 100);
        assertTrue(player1.getMaxHP() == 100);
        assertEquals(player1.getLocation().getX(),0.0,EPSILON);
        assertEquals(player1.getLocation().getY(),5.0,EPSILON);
        assertEquals(player1.getOrientation().getX(),0.0,EPSILON);
        assertEquals(player1.getOrientation().getY(),0.1,EPSILON);
        assertEquals(player1.getVelocity().getX(),0.0,EPSILON);
        assertEquals(player1.getVelocity().getY(),0.0,EPSILON);

        Vector2D location2 = new Vector2D(2.9,4.6);
        Player player2 = new Player(location2, 250);

        assertTrue(player2.getHP() == 250);
        assertTrue(player2.getMaxHP() == 250);
        assertEquals(player2.getLocation().getX(),2.9,EPSILON);
        assertEquals(player2.getLocation().getY(),4.6,EPSILON);
        assertEquals(player2.getOrientation().getX(),0.0,EPSILON);
        assertEquals(player2.getOrientation().getY(),0.1,EPSILON);
        assertEquals(player2.getVelocity().getX(),0.0,EPSILON);
        assertEquals(player2.getVelocity().getY(),0.0,EPSILON);

        Vector2D location3 = new Vector2D(5.1,4.9);
        Player player3 = new Player(location3, 341);

        assertTrue(player3.getHP() == 341);
        assertTrue(player3.getMaxHP() == 341);
        assertEquals(player3.getLocation().getX(),5.1,EPSILON);
        assertEquals(player3.getLocation().getY(),4.9,EPSILON);
        assertEquals(player3.getOrientation().getX(),0.0,EPSILON);
        assertEquals(player3.getOrientation().getY(),0.1,EPSILON);
        assertEquals(player3.getVelocity().getX(),0.0,EPSILON);
        assertEquals(player3.getVelocity().getY(),0.0,EPSILON);

        Vector2D location4 = new Vector2D(0.0,0.0);
        Player player4 = new Player(location4,0);

        assertTrue(player4.getHP() == 0);
        assertTrue(player4.getMaxHP() == 0);
        assertEquals(player4.getLocation().getX(),0.0,EPSILON);
        assertEquals(player4.getLocation().getY(),0.0,EPSILON);
        assertEquals(player4.getOrientation().getX(),0.0,EPSILON);
        assertEquals(player4.getOrientation().getY(),0.1,EPSILON);
        assertEquals(player4.getVelocity().getX(),0.0,EPSILON);
        assertEquals(player4.getVelocity().getY(),0.0,EPSILON);

        Vector2D location5 = new Vector2D(9.9,5.6);
        Player player5 = new Player(location5,499192391);

        assertTrue(player5.getHP() == 499192391);
        assertTrue(player5.getMaxHP() == 499192391);
        assertEquals(player5.getLocation().getX(),9.9,EPSILON);
        assertEquals(player5.getLocation().getY(),5.6,EPSILON);
        assertEquals(player5.getOrientation().getX(),0.0,EPSILON);
        assertEquals(player5.getOrientation().getY(),0.1,EPSILON);
        assertEquals(player5.getVelocity().getX(),0.0,EPSILON);
        assertEquals(player5.getVelocity().getY(),0.0,EPSILON);

        Vector2D location6 = new Vector2D(0.1234,0.5678);
        Player player6 = new Player(location6, -100);

        assertTrue(player6.getHP() == -100);
        assertTrue(player6.getMaxHP() == -100);
        assertEquals(player6.getLocation().getX(),0.1234,EPSILON);
        assertEquals(player6.getLocation().getY(),0.5678,EPSILON);
        assertEquals(player6.getOrientation().getX(),0.0,EPSILON);
        assertEquals(player6.getOrientation().getY(),0.1,EPSILON);
        assertEquals(player6.getVelocity().getX(),0.0,EPSILON);
        assertEquals(player6.getVelocity().getY(),0.0,EPSILON);

        Vector2D location7 = new Vector2D(0.0,0.0);
        Player screwAutoLabs = new Player(location7,-897641241);

        assertTrue(screwAutoLabs.getHP() == -897641241);
        assertTrue(screwAutoLabs.getMaxHP() == -897641241);
        assertEquals(screwAutoLabs.getLocation().getX(),0.0,EPSILON);
        assertEquals(screwAutoLabs.getLocation().getY(),0.0,EPSILON);
        assertEquals(screwAutoLabs.getOrientation().getX(),0.0,EPSILON);
        assertEquals(screwAutoLabs.getOrientation().getY(),0.1,EPSILON);
        assertEquals(screwAutoLabs.getVelocity().getX(),0.0,EPSILON);
        assertEquals(screwAutoLabs.getVelocity().getY(),0.0,EPSILON);

        Player pleasePass = screwAutoLabs;
        assertTrue(pleasePass.getHP() == -897641241);
        assertTrue(pleasePass.getMaxHP() == -897641241);
        assertEquals(pleasePass.getLocation().getX(),0.0,EPSILON);
        assertEquals(pleasePass.getLocation().getY(),0.0,EPSILON);
        assertEquals(pleasePass.getOrientation().getX(),0.0,EPSILON);
        assertEquals(pleasePass.getOrientation().getY(),0.1,EPSILON);
        assertEquals(pleasePass.getVelocity().getX(),0.0,EPSILON);
        assertEquals(pleasePass.getVelocity().getY(),0.0,EPSILON);
    }

    @Test
    public void testSetHP(){
        Vector2D location = new Vector2D(0.0,0.0);
        Player player1 = new Player(location,100);

        player1.setHP(50);
        assertTrue(player1.getHP() == 50);

        player1.setHP(200);
        assertTrue(player1.getHP() == 100);

        player1.setHP(-50);
        assertTrue(player1.getHP() == -50);
    }
    @Test
    public void testTakeDamage(){
        Vector2D location = new Vector2D(0.0,0.0);
        Player player1 = new Player(location,100);
        Player player2 = new Player(location,100);
        comparePlayers(player1,player2);

        player1.takeDamage(-100);
        comparePlayers(player1,player2);

        player1.takeDamage(200);
        player2.setHP(-100);
        comparePlayers(player1,player2);

        player1.takeDamage(0);
        comparePlayers(player1,player2);
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

        player1.getVelocity().setX(0.0);
        player1.getVelocity().setY(0.0);

        test.updateObject(player1,0.0);
        assertEquals(player1.getLocation().getX(),6.0,EPSILON);
        assertEquals(player1.getLocation().getY(),2.5,EPSILON);

        Vector2D location2 = new Vector2D(5.65,7.89);
        Player player2 = new Player(location2,100);

        player2.getVelocity().setX(7.891234);
        player2.getVelocity().setY(-5.678912345);

        test.updateObject(player2,-9.5678213);
        assertEquals(player2.getLocation().getX(),-69.8519167485,EPSILON);
        assertEquals(player2.getLocation().getY(),62.2248184953,EPSILON);
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
