package app.gameengine.model.ai;

import app.gameengine.model.datastructures.BinaryTreeNode;

public class DecisionTree {
    private BinaryTreeNode<Decision> treeNode;
    public DecisionTree(BinaryTreeNode<Decision> treeNode){
        setTreeNode(treeNode);
    }
    public BinaryTreeNode<Decision> getTreeNode(){
        return treeNode;
    }
    public void setTreeNode(BinaryTreeNode<Decision> treeNode){
        this.treeNode = treeNode;
    }
}
