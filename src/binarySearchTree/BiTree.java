/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

import QueueAndStack.ArrayQueue;
import QueueAndStack.ArrayStack;
import java.util.Iterator;
import QueueAndStack.Stackable;
import java.util.HashMap;

/**
 *
 * @author swans_000
 */
public class BiTree<V> implements BiTreeInterface<V> {
    
    private BiNode rootNode;
    
    // CONSTRUCTORS
    public BiTree(){
        rootNode = null;
    }
    
    public BiTree(V rootVal){
        rootNode = new BiNode(rootVal);
    }
    
    public BiTree(V rootVal, BiTree<V> leftSide, BiTree<V> rightSide){
        pSetTree(rootVal, leftSide, rightSide);
    }
    
    private void pSetTree(V rootVal, BiTree<V> leftSide, BiTree<V> rightSide){
        
        rootNode = new BiNode<>(rootVal);
        
        if (leftSide != null){
            if (!leftSide.isEmpty()){
                rootNode.setLeftNode(leftSide.rootNode);
            }
            if (leftSide != this){
                leftSide.clear();
            }
        }
        
        if (rightSide != null){
            if (!rightSide.isEmpty()){
                if (rightSide == leftSide){
                    rootNode.setRightNode(rightSide.rootNode.copy());
                } else {
                    rootNode.setRightNode(rightSide.rootNode);
                }
            }
            
            if (rightSide != this){
                rightSide.clear();
            }
        }
    }
    

    public void inorderRecurse(){
        inorderRecurse(rootNode);
    }
    
    private void inorderRecurse(BiNode<V> node){
        if (node != null) {
            // NEED TO MAKE TABLE WITH THIS
            if (node.hasLeftNode()) {
                inorderRecurse(node.getLeftNode());
            }
            if (node.hasRightNode()){
                inorderRecurse(node.getRightNode());
            }
        }
    }
    
    public HashMap<V, V> inorderRecurseHash() {
        HashMap<V, V> tmp = new HashMap<>();
        tmp = inorderRecurseHash(rootNode);
        return tmp;
    }
    
    private HashMap<V, V> inorderRecurseHash(BiNode<V> node) {
        HashMap<V, V> tmp = new HashMap<>();
        if (node != null) {
            tmp.putAll(inorderRecurseHash(node.getLeftNode()));
            tmp.putAll(inorderRecurseHash(node.getRightNode()));
        }
        return tmp;
    }
    


    @Override
    public void setTree(V rootValue){
        rootNode = new BiNode<>(rootValue);
    }

    @Override
    public void setTree(V rootValue, BiTreeInterface<V> leftTree, BiTreeInterface<V> rightTree) {
        pSetTree(rootValue, (BiTree<V>)leftTree, (BiTree<V>)rightTree);
    }

    @Override
    public V getRootValue() {
        return (V)rootNode.getValue();
    }

    @Override
    public int getHeight() {
        return rootNode.getHeight();
    }

    @Override
    public int getNodeCount() {
        return rootNode.getCountMeAndKids();
    }

    @Override
    public boolean isEmpty() {
        return rootNode == null;
    }

    @Override
    public void clear() {
        rootNode = null;
    }

    @Override
    public Iterator<V> getPreorderIterator() {
        return new PreOrderIterator();
    }
    
    public void inorderTraverse(){
        inorderTraverse(rootNode);
    }
    
    private void inorderTraverse(BiNode<V> node){
        if (node != null) {
            inorderTraverse(node.getLeftNode());
            node.printHash();
            inorderTraverse(node.getRightNode());
        }
    }

    // ACCESSORS & MUTATORS
    protected void setRootNode(BiNode<V> root) {
        rootNode = root;
    }
    
    protected void setRootValue(V newVal) {
        rootNode.setValue(newVal);
    }
    
    protected BiNode<V> getRootNode() {
        return rootNode;
    }

    @Override
    public Iterator<V> getLevelOrderIterator() {
        return new LevelOrderIterator();
    }
   
    // ITERATORS
    private class PreOrderIterator implements Iterator<V> {
        
        private Stackable<BiNode<V>> nodeStack;
        private BiNode<V> curNode;
        
        public PreOrderIterator() {
            nodeStack = new ArrayStack<>();
            curNode = rootNode;
        }
        @Override
        public boolean hasNext() {
            
            boolean result = false;
            if (!nodeStack.isEmpty()) {
                result = true;
            }
            if (curNode != null) {
                result = true;
            }
            return result;
        }

        @Override
        public V next() {
            BiNode nextNode = null;
            
            while (curNode != null){
                if (!curNode.isChildless()) {
                    if (curNode.hasLeftNode()) {
                        nextNode = curNode.getLeftNode();
                        nodeStack.push(nextNode);
                        curNode = nextNode; 
                    } else if (curNode.hasRightNode()) {
                        nextNode = curNode.getRightNode();
                        nodeStack.push(nextNode);
                        curNode = nextNode;
                    }
                } else {
                    curNode = nodeStack.pop();
                    nextNode = curNode;
                }
            }               
            return (V)nextNode.getValue();
        }
       
        public BiNode nextNode() {
            // Pre-order or Level-Order or Post-order?
            BiNode nextNode = null;
            
            while (curNode != null){
                if (!curNode.isChildless()) {
                    if (curNode.hasLeftNode()) {
                        nextNode = curNode.getLeftNode();
                        nodeStack.push(nextNode);
                        curNode = nextNode; 
                    } else if (curNode.hasRightNode()) {
                        nextNode = curNode.getRightNode();
                        nodeStack.push(nextNode);
                        curNode = nextNode;
                    }
                } else {
                    curNode = nodeStack.pop();
                    nextNode = curNode;
                }   
            } 
            return nextNode;
        }        
    }
    
    private class LevelOrderIterator<V> implements Iterator<BiNode> {

        ArrayQueue<BiNode> queue;
        private BiNode curNode;
        
        public LevelOrderIterator() {
            queue = new ArrayQueue<>();
            curNode = rootNode;
            queue.queue(rootNode);
        }
        
        public BiNode thisNode() {
            return curNode;
        }
        
        @Override
        public boolean hasNext() {
            return (curNode != null) && !queue.isEmpty();
        }

        @Override
        public BiNode next() {           
            BiNode resultNode = queue.dequeue();           
            if (resultNode.hasLeftNode()){
                queue.queue(resultNode.getLeftNode());
            }
            if (resultNode.hasRightNode()) {
                queue.queue(resultNode.getRightNode());
            }                      
            return resultNode;
        }       
    }
}
