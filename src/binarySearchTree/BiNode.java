/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

import java.util.HashMap;

/**
 *
 * @author swans_000
 */
class BiNode<V> {
    
    private V value;
    private int count;
    private BiNode<V> leftChild;
    private BiNode<V> rightChild;
    private HashMap<V, Integer> kidHash;
    
    // CONSTRUCTORS
    public BiNode() {
        this(null);
    }
    
    public BiNode(V val) {
        this(val, null, null);
    }
    
    public BiNode(V val, BiNode<V> newLeftChild, BiNode<V> newRightChild) {
        value = val;
        count = 1;
        leftChild = newLeftChild;
        rightChild = newRightChild;
        kidHash = new HashMap<>();
    }

    // SETTERS
    public void setValue(V val) {
        value = val;
    }
    
    public void setLeftNode(BiNode<V> newLeftChild) {
        leftChild = newLeftChild;
        //kidHash.put(newLeftChild, newLeftChild.count);
    }
    
    public void setRightNode(BiNode<V> newRightChild) {
        rightChild = newRightChild;
    } 
     
    // GETTERS
    public V getValue() {
        return value;
    }
    
    public int getCount() {
        return count;
    }
    
    public HashMap getKidHash(){
        return kidHash;
    }

    public BiNode<V> getLeftNode() {
        return leftChild;
    }
    
    public BiNode<V> getRightNode() {
        return rightChild;
    }

    public int getHeight(){
        return getHeight(this);
    }
    
    private int getHeight(BiNode<V> node) {        
        int result = 0;
        if (node != null){
            result = 1 + Math.max(getHeight(node.getLeftNode()), 
                    getHeight(node.getRightNode()));
        }
        return result;
    }
    
    public boolean hasLeftNode(){
        return leftChild != null;
    }
    
    public boolean hasRightNode() {
        return rightChild != null;
    }
    
    public boolean isChildless(){
        return !hasLeftNode() && !hasRightNode();
    }
        
    /* Increment count when a duplicate is added */
    public void increment() {
        count++;
    }
    
    /* Reduce the value count to a minimum value of 0 */
    public boolean decrement() {
        boolean result = false;
        if (count > 0) {
            count--;
            result = true;
        }
        return result;
    }   
    //Would clone be better?
    public BiNode<V> copy() {
        BiNode<V> result = new BiNode<>(value);
        
        if (leftChild != null) {
            result.setLeftNode(leftChild.copy());
        }
        if (rightChild != null) {
            result.setRightNode(rightChild.copy());
        }
        
        return result;
    }
    
    // MAY BE INCOMPLETE
    @Override
    public Object clone() {
        
        BiNode<V> result = null;
        
        try{
            result = (BiNode)super.clone();
        } catch(CloneNotSupportedException e){
            System.err.println("Cannot clone " + e.toString());
        }
        
        return result;
    }
    
    public int getCountMeAndKids(){
        int leftCt = 0;
        int rightCt = 0;
        
        if (leftChild != null){
            leftCt = leftChild.getCountMeAndKids();
        }
        if (rightChild != null){
            rightCt = rightChild.getCountMeAndKids();
        }
        
        return 1 + leftCt + rightCt;
    }
    
    public void printAll(){
        System.out.print("me=" + value.toString());
        if (leftChild != null) {
            System.out.print("   left:");
            leftChild.printAll();
        }
        if (rightChild != null) {
            System.out.print("   right:");
            rightChild.printAll();
        }
        System.out.println();
    }
    
    public void addToKidHash(BiNode<V> toAdd) {
            kidHash.put(toAdd.getValue(), toAdd.getCount());
    }
    
    public void addToKidHash(V val) {
        int tmp = 1;
        if (kidHash.containsKey(val)) {
            tmp = (int)kidHash.get(val);
            tmp++;
        }
        kidHash.put(val, tmp);
        
    }
    
    public V removeFromKidHash(V val) {
        V result = null;
        if (kidHash.containsKey(val)) {
            int tmp = (int)kidHash.get(val);
            if (tmp > 0) {
                tmp--;
                result = val;
                kidHash.put(val, tmp);
            }
        }
        return result;
    }
    
    public void printHash() {
        System.out.println();
        System.out.println("---Children for " + value.toString() + "---");
        for (V ky: kidHash.keySet()){
            System.out.print("(Key=" + ky.toString());
            System.out.print(" Count=" + kidHash.get(ky).toString() + ")");
            
        }
    }
    
    @Override
    public String toString(){
        return "[Value:" + value.toString() + "; Count:" + count + "]";
    }

}
