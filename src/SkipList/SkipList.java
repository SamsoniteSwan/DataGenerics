/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkipList;

import java.util.Iterator;

/**
 *
 * @author swans_000
 */
public class SkipList implements Iterator<SkipList> {
       
    private int myLevel;
    private SkipNode first;
    private SkipNode last;
    
    private SkipList subList;
    
    
    public SkipList(String[] sortedArray) {
        this(sortedArray, 0, sortedArray.length);
    } 
    
    public SkipList(String[] sortedArray, int lvl, int ct) {
        myLevel = lvl;
        
        // Create linked list
        SkipNode init = new SkipNode(sortedArray[0]);
        first = init;
        last = init;
        
        // recursively create sublists (levels) until
        // size cannot be halved anymore
        if (ct > 1){
            String[] temp = new String[1];
            temp[0] = sortedArray[0];
            subList = new SkipList(temp, lvl+1, ct/2);
            subList.first.setUp(init);
        }
        
        // add remaining values to this linked list
        for(int i = 1; i < sortedArray.length; i++){            
            SkipNode newNode = new SkipNode(sortedArray[i], i % 2 == 1);
            addNode(newNode);
        }
        
    }
    
    @Override
    public boolean hasNext() {
        return subList != null;
    }

    @Override
    public SkipList next() {
        return subList;
    } 
    
    private void addNode(SkipNode newN){        
        last.setNext(newN);
        boolean nodeIsEven = newN.getEven();
        if (hasNext() && !nodeIsEven){
            // add this as a lower node
            SkipNode newLowNode = new SkipNode(newN.getValue(), !last.getEven());
            next().addNode(newLowNode);
            newLowNode.setUp(newN);
        
            }
        last = newN;        
    }
   
    public SkipNode firstNode(){
        return first;
    }
    
    /**
     * Prints this list's members,
     * then does the same with it's sub
     */
    public void printall(){
        SkipNode testN = first;
        System.out.print(myLevel);
        while(testN != null) {
            System.out.print("; " + testN.getValue() + "(" + testN.getEven() + ")");
            testN = testN.next();
        }
        System.out.println();
        if (hasNext()){
            subList.printall();     // RECURSIVE CALL
        }
    }
    
    /**
     * get the lowest sublist
     */
    public SkipList getLowestSub(){
        SkipList result = null;
        if(next().hasNext()){
            result = next().getLowestSub();
        } else{
            result = next();
        }
        //System.out.println("onlevel " + myLevel);
        return result;
        
    }
    
    /**
     * 
     * @param check
     * @return 
     */
    public boolean contains(String check){
        SkipNode resultNode = getLowestSub().firstNode().nextToCheck(check);
        return resultNode != null;
    }
    
}