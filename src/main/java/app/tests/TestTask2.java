package app.tests;

import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.physics.Vector2D;
import app.games.topdownobjects.TopDownLevel;
import org.junit.Test;
import static app.gameengine.model.ai.Pathfinding.findPath;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class TestTask2 {
    public void validatePath(LinkedListNode<Vector2D> path){
        if(path != null && path.getNext() == null){
            assertEquals(Math.floor(path.getValue().getX()),path.getValue().getX(),0.001);
            assertEquals(Math.floor(path.getValue().getY()),path.getValue().getY(),0.001);
        }
        while(path.getNext() != null){
            double euclidean = Math.sqrt(Math.pow(path.getValue().getX() - path.getNext().getValue().getX(),2) + Math.pow(path.getValue().getY() - path.getNext().getValue().getY(),2));
            assertEquals(Math.floor(path.getValue().getX()),path.getValue().getX(),0.001);
            assertEquals(Math.floor(path.getValue().getY()),path.getValue().getY(),0.001);
            assertEquals(Math.floor(path.getValue().getX()),path.getNext().getValue().getX(),0.001);
            assertEquals(Math.floor(path.getValue().getY()),path.getNext().getValue().getY(),0.001);
            assertEquals(1.0, euclidean,0.001);
            path = path.getNext();
        }
    }

}
