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
        if(path == null || path.getNext() == null){
            return ;
        }
        while(path.getNext() != null){
            assertEquals(Math.floor(path.getValue().getX()),path.getValue().getX(),0.001);
            assertEquals(Math.floor(path.getValue().getY()),path.getValue().getY(),0.001);
            double distanceX = Math.abs(path.getValue().getX() - path.getNext().getValue().getX());
            double distanceY = Math.abs(path.getValue().getY() - path.getNext().getValue().getY());
            assertEquals(1.0,distanceX + distanceY,0.001);
            path = path.getNext();
        }
    }
    @Test
    public void testFindPath(){
        Vector2D decimals = new Vector2D(4.5,6.9);
        LinkedListNode<Vector2D> invalidPath = new LinkedListNode<>(decimals,null);
        validatePath(invalidPath);

        Vector2D start = new Vector2D(0.0,0.0);
        Vector2D end = new Vector2D(10.0,12.0);

        validatePath(findPath(start,end));

        Vector2D start1 = new Vector2D(5.5,5.6);
        Vector2D end1 = new Vector2D(15.8,12.5);

        validatePath(findPath(start1,end1));
        validatePath(findPath(end1,start1));
    }

    @Test
    public void testFindPathAdjacent(){
        Vector2D line1 = new Vector2D(1.0,1.0);
        Vector2D line2 = new Vector2D(2.0,2.0);

        int count = 0;
        LinkedListNode<Vector2D> path = findPath(line1, line2);
        validatePath(path);
        while(path.getNext() != null){
            count+=1;
            path = path.getNext();
        }
        assertTrue(count == 2);
    }
}
