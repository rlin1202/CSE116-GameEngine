package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.datastructures.BinaryTreeNode;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class DecisionTree {
    private BinaryTreeNode<Decision> treeNode;
    public DecisionTree(BinaryTreeNode<Decision> treeNode){
        setTree(treeNode);
    }
    public BinaryTreeNode<Decision> getTree(){
        return treeNode;
    }
    public void setTree(BinaryTreeNode<Decision> treeNode){
        this.treeNode = treeNode;
    }
    public Decision traverse(BinaryTreeNode<Decision> tree,DynamicGameObject gameObject, Level level,double dt){
        if (tree == null){
            return null;
        }
        if (tree.getLeft() == null && tree.getRight() == null){
            return tree.getValue();
        }
        if(tree.getValue().decide(gameObject,level,dt)){
            if(tree.getRight() != null){
                return traverse(tree.getRight(),gameObject,level,dt);
            }else if(tree.getLeft() != null && tree.getRight() == null){
                return null;
            }
        }else if(!tree.getValue().decide(gameObject, level, dt)){
            if(tree.getLeft() != null){
                return traverse(tree.getLeft(),gameObject,level,dt);
            }else if(tree.getRight() != null && tree.getLeft() == null){
                return null;
            }
        }
        return null;
    }

    public void traverse(DynamicGameObject gameObject,Level level,double dt){
        Decision decision = traverse(treeNode,gameObject,level,dt);
        if(decision == null){
            return;
        }
        decision.doAction(gameObject,level,dt);
    }
    public void reverse(BinaryTreeNode<Decision> tree){
        if(tree == null){
            return;
        }
        BinaryTreeNode<Decision> temp = tree.getLeft();
        tree.setLeft(tree.getRight());
        tree.setRight(temp);
        reverse(tree.getLeft());
        reverse(tree.getRight());
    }
    public void reverse(){
        reverse(treeNode);
    }
}
