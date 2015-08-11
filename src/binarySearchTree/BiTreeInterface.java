/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

/**
 *
 * @author swans_000
 */
public interface BiTreeInterface<V> extends TreeInterface<V>, TreeIterable<V> {
    
    /**
     * Make tree top without any children
     * @param rootValue 
     */
    public void setTree(V rootValue);
    
    /**
     * make binary tree with top value and two children.
     * @param rootValue value of tree root.
     * @param leftTree  left sub-tree
     * @param rightTree right sub-tree
     */
    public void setTree(V rootValue, BiTreeInterface<V> leftTree, 
            BiTreeInterface<V> rightTree);
}
