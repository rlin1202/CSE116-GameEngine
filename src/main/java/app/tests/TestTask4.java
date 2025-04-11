package app.tests;

import app.gameengine.*;
import app.gameengine.model.ai.Decision;
import app.gameengine.model.ai.DecisionTree;
import app.gameengine.model.datastructures.BinaryTreeNode;
import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Vector2D;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTask4 {
    public static void compareBinaryTreesOfDecisions(BinaryTreeNode<Decision> b1, BinaryTreeNode<Decision> b2){
        if(b1 == null || b2 == null){
            assertTrue(b1 == b2);
            return;
        }
        compareBinaryTreesOfDecisions(b1.getLeft(), b2.getLeft());
        assertEquals(b1.getValue().getName(), b2.getValue().getName());
        compareBinaryTreesOfDecisions(b1.getRight(), b2.getRight());
    }

}

