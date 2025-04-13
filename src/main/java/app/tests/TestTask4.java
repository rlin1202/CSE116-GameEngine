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

    @Test
    public void testCompareTree(){
        BinaryTreeNode<Decision> tree = new BinaryTreeNode<>(new Decision("attack"),null,null);
        tree.setLeft(new BinaryTreeNode<>(new Decision("heal"),null,null));
        tree.setRight(new BinaryTreeNode<>(new Decision("find player"),null,null));

        BinaryTreeNode<Decision> tree2 = new BinaryTreeNode<>(new Decision("attack"),null,null);
        tree2.setLeft(new BinaryTreeNode<>(new Decision("heal"),null,null));
        tree2.setRight(new BinaryTreeNode<>(new Decision("find player"),null,null));

        compareBinaryTreesOfDecisions(tree,tree2);
    }

    //write test for traverse basic functionality
    //write test for traverse for doAction
    //write test for traverse to make sure null is returned properly

    @Test
    public void testTraverseSimple(){
        BinaryTreeNode<Decision> tree = new BinaryTreeNode<>(new Task4Helper(true,"patrol"),null,null);
        tree.setLeft(new BinaryTreeNode<>(new Task4Helper(false,"attack"),null,null));
        tree.setRight(new BinaryTreeNode<>(new Task4Helper(false,"heal"),null,null));

        DecisionTree decisionTree = new DecisionTree(tree);

        Player player = new Player(new Vector2D(0.0,0.0),100);
        Level level = null;
        double dt = 1.0;

        decisionTree.traverse(player,level,dt);
        assertEquals(75,player.getHP());

        BinaryTreeNode<Decision> tree2= new BinaryTreeNode<>(new Task4Helper(true,"patrol"),null,null);
        tree2.setLeft(new BinaryTreeNode<>(new Task4Helper(false,"attack"),null,null));
        DecisionTree decisionTree2 = new DecisionTree(tree2);

        assertEquals(tree2.getRight(),null);
        assertEquals(decisionTree2.traverse(tree2,player,level,dt),null);
    }

    @Test
    public void testTraverseComplex(){
        BinaryTreeNode<Decision> tree = new BinaryTreeNode<>(new Task4Helper(true,"attack"),null,null);
        tree.setLeft(new BinaryTreeNode<>(new Task4Helper(false,"run"),null,null));
        tree.setRight(new BinaryTreeNode<>(new Task4Helper(false,"target"),null,null));
        tree.getLeft().setLeft(new BinaryTreeNode<>(new Task4Helper(false,"something"),null,null));
        tree.getRight().setLeft(new BinaryTreeNode<>(new Task4Helper(false,"random action"),null,null));
        tree.getRight().setRight(new BinaryTreeNode<>(new Task4Helper(true,"heal"),null,null));

        DecisionTree decisionTree = new DecisionTree(tree);

        Player player = new Player(new Vector2D(0.0,0.0),100);
        Level level = null;
        double dt = 1.0;

        assertEquals(100,player.getHP());
        decisionTree.traverse(player,null,1.0);
        assertEquals(75,player.getHP());
    }

    //write test for reverse basic functionality
    //write test for reverse with more than 5 nodes

    @Test
    public void testReverseSimple(){
        BinaryTreeNode<Decision> left = new BinaryTreeNode<>(new Task4Helper(false,"heal"),null,null);
        BinaryTreeNode<Decision> right = new BinaryTreeNode<>(new Task4Helper(false,"chase"),null,null);
        BinaryTreeNode<Decision> tree = new BinaryTreeNode<>(new Task4Helper(true,"attack"),left,right);

        DecisionTree decisionTree = new DecisionTree(tree);
        decisionTree.reverse();

        BinaryTreeNode<Decision> expected = new BinaryTreeNode<>(new Task4Helper(true,"attack"),null,null);
        expected.setLeft(new BinaryTreeNode<>(new Task4Helper(false,"chase"),null,null));
        expected.setRight(new BinaryTreeNode<>(new Task4Helper(false,"heal"),null,null));
        compareBinaryTreesOfDecisions(expected,decisionTree.getTree());

        BinaryTreeNode<Decision> left1 = new BinaryTreeNode<>(new Task4Helper(false,"crying"),null,null);
        BinaryTreeNode<Decision> right1 = new BinaryTreeNode<>(new Task4Helper(false,"malding"),null,null);
        BinaryTreeNode<Decision> tree2 = new BinaryTreeNode<>(new Task4Helper(true,"release me"),left1,right1);

        DecisionTree decisionTree2 = new DecisionTree(tree2);
        decisionTree2.reverse();

        BinaryTreeNode<Decision> expected2 = new BinaryTreeNode<>(new Task4Helper(true,"release me"),null,null);
        expected2.setLeft(new BinaryTreeNode<>(new Task4Helper(false,"malding"),null,null));
        expected2.setRight(new BinaryTreeNode<>(new Task4Helper(false,"crying"),null,null));


        compareBinaryTreesOfDecisions(expected2,decisionTree2.getTree());

        BinaryTreeNode<Decision> left2 = new BinaryTreeNode<>(new Task4Helper(false,"AHHHHHHH"),null,null);
        BinaryTreeNode<Decision> tree3 = new BinaryTreeNode<>(new Task4Helper(true,"get me out"),left2,null);

        DecisionTree decisionTree3 = new DecisionTree(tree3);
        decisionTree3.reverse();

        BinaryTreeNode<Decision> expected3 = new BinaryTreeNode<>(new Task4Helper(true,"get me out"),null,null);
        expected3.setRight(new BinaryTreeNode<>(new Task4Helper(false,"AHHHHHHH"),null,null));

        compareBinaryTreesOfDecisions(expected3,decisionTree3.getTree());


    }

    @Test
    public void testReverseComplex(){

        BinaryTreeNode<Decision> left = new BinaryTreeNode<>(new Task4Helper(true,"heal"),null,null);
        BinaryTreeNode<Decision> right = new BinaryTreeNode<>(new Task4Helper(true,"chase"),null,null);
        BinaryTreeNode<Decision> left2 = new BinaryTreeNode<>(new Task4Helper(false,"defend"),null,null);
        BinaryTreeNode<Decision> right2 = new BinaryTreeNode<>(new Task4Helper(true,"hide"),null,null);
        BinaryTreeNode<Decision> left3 = new BinaryTreeNode<>(new Task4Helper(false,"run"),null,null);
        BinaryTreeNode<Decision> right3 = new BinaryTreeNode<>(new Task4Helper(true,"die"),null,null);

        BinaryTreeNode<Decision> tree = new BinaryTreeNode<>(new Task4Helper(true,"attack"),left,right);
        tree.getLeft().setLeft(left2);
        tree.getLeft().setRight(right2);
        tree.getRight().setLeft(left3);
        tree.getRight().setRight(right3);

        DecisionTree decisionTree = new DecisionTree(tree);
        decisionTree.reverse();

       BinaryTreeNode<Decision> expected = new BinaryTreeNode<>(new Task4Helper(true,"attack"),null,null);
       expected.setLeft(new BinaryTreeNode<>(new Task4Helper(true,"chase"),null,null));
       expected.setRight(new BinaryTreeNode<>(new Task4Helper(true,"heal"),null,null));
       expected.getLeft().setLeft(new BinaryTreeNode<>(new Task4Helper(true,"die"),null,null));
       expected.getLeft().setRight(new BinaryTreeNode<>(new Task4Helper(false,"run"),null,null));
       expected.getRight().setLeft(new BinaryTreeNode<>(new Task4Helper(true,"hide"),null,null));
       expected.getRight().setRight(new BinaryTreeNode<>(new Task4Helper(false,"defend"),null,null));

        compareBinaryTreesOfDecisions(decisionTree.getTree(),expected);
    }
}

