/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

import Utils.RandomGenerator;
import java.util.Iterator;

/**
 *
 * @author swans_000
 */
public class Test {
    
    public static final int TRUE_CT = 5;       // Number of occurring values to test
    public static final int FALSE_CT = 5;      // Number of 'false' values to create
    public static final int DUPLICATE_CT = 5;
    public static final int RANDOM_CT = 200;
    public static final int TOT_SIZE = RANDOM_CT + DUPLICATE_CT;  // Number of values for the list
    public static final int REMOVE_CT = 3;
    public static final int RELATION_CT = 20;
    
    public static void main(String[] args) {

        // Initialize empty arrays
        String[] unsorted = new String[TOT_SIZE];
        String[] shouldFindVals = new String[TRUE_CT];
        // noFindValues are known to not occur, because they either use
        //  all caps or are longer than the randomly generated. 
        String[] noFindVals = new String[FALSE_CT];
        String[] checkRel = new String[RELATION_CT];
                
        int j = 0;
        // create randomly generated Strings for the list...
        System.out.println("Creating strings... :");
        for (int i = 0; i < RANDOM_CT; i++, j++) {
            
            unsorted[i] = RandomGenerator.randStringVarSize(2, 7);
            System.out.print(" " + unsorted[i]);
            // take the first TRUE_CT of randomly generated values
            // and add them to the test array
            if (i < TRUE_CT){
                shouldFindVals[i] = unsorted[i];
            } 
        }
        
        // make list of values to test parent/child relationships
        int k = 0;
        int[] checkarray = new int[RELATION_CT];
        
        while (k < RELATION_CT) {
            int getSpot = RandomGenerator.randInt(0, RANDOM_CT - 1);
            boolean alreadyused = false;
            for (int chk : checkarray) {
                if (getSpot == chk) {
                    alreadyused = true;
                }
            }
            if (!alreadyused) {
                checkarray[k] = getSpot;
                checkRel[k] = unsorted[getSpot];
                k++;
            }
        }
        
        //make some duplicates
        for (int d = 0; d < DUPLICATE_CT; d++, j++) {   
            int idxDuplicate = RandomGenerator.randInt(0, RANDOM_CT);
            unsorted[j] = unsorted[idxDuplicate];
        }
        
        // create randomly generated strings for testing that are
        // too large to exist in the list.
        for (int i = 0; i < noFindVals.length; i++) {
            noFindVals[i] = RandomGenerator.randStringFixedSize(12);
        }
        
        BiSearchTree<String> randValTree = new BiSearchTree<>();
        
        // Add all values to the structure
        for (int i = 0; i < TOT_SIZE; i++){
            //System.out.println("ADDING " + unsorted[i]);
            randValTree.add(unsorted[i]);            
        }
        
        // test all the values that should be found
        System.out.println();
        System.out.println("~SEARCH FOR EXISTING VALUES~ (SHOULD RETURN ALL TRUE)");
        for (String find : shouldFindVals) {
            System.out.print("check " + find + ": ");
            System.out.println(randValTree.contains(find));            
        }

        // test ALLCAPS values that should NOT be found
        System.out.println();
        System.out.println("SEARCH FOR NON-EXISTENT VALUES~ (SHOULD RETURN ALL FALSE)");
        for (String find : noFindVals) {
            System.out.print("check " + find + ": ");
            System.out.println(randValTree.contains(find));            
        }
        
        //randValTree.inorderTraverse();       
        System.out.println();
        System.out.println("~REMOVE NODES~");
        for (int i = 0; i < REMOVE_CT; i++) {
            int idxRemove = RandomGenerator.randInt(0, TOT_SIZE-1);
            System.out.print(randValTree.remove(unsorted[idxRemove]) + "; ");
            
        }
        System.out.println();        
        //randValTree.inorderTraverse();       
        System.out.println();
        System.out.println("LEVEL-ORDER NODE TRAVERSAL USING ITERATOR");
        Iterator iter = randValTree.getOrderIterator();
        BiNode cur = (BiNode)iter.next();
        int row = cur.getHeight();
        int prevrow = cur.getHeight();
        while (iter.hasNext()) {           
            System.out.print(cur.toString() + "(KidCt:" + cur.getCountMeAndKids() + " lvl:" + cur.getHeight() + ")");
            prevrow = cur.getHeight();
            cur = (BiNode)iter.next();
            row = cur.getHeight();
            if (row > prevrow){
                System.out.println();
            }           
        }
        
        /*
        *Use a small, known structure to perform basic tests.
        *                     julip
        *                    /     \
        *                cat         kalvin
        *              /   \         /     \
        *         breeze  crazy     jz    kevin
        *         /       /  \            /   \
        *    apple   celery  empire      kb    prop
        */
        String[] myBuild = new String[]{"julip", "cat", "crazy", "kalvin", 
            "kevin", "breeze", "jz", "kb", "prop", "apple", "celery", "empire"};
        
        BiSearchTree<String> myValTree = new BiSearchTree<>();
        for (int i = 0; i < myBuild.length; i++) {
            myValTree.add(myBuild[i]);
        }
        
        myValTree.inorderTraverse();
        Iterator myIter = myValTree.getLevelOrderIterator();
        cur = (BiNode)myIter.next();
        int prevlvl = cur.getHeight();
        int curlvl = cur.getHeight();
        while (true){
            if (curlvl < prevlvl) {
                System.out.println();
                System.out.println();
                prevlvl = curlvl;
            }
            System.out.print(cur.toString() + "(KidCt:" + cur.getCountMeAndKids() + " lvl:" + cur.getHeight() + ")");
            if(!myIter.hasNext()){
                break;
            }
            cur = (BiNode)myIter.next();
            curlvl = cur.getHeight();           
        }
        
        System.out.println();
        System.out.println("~CHECK RELATIONS~ (SHOULD RETURN ALL TRUE)");
        System.out.println(myValTree.is1ParentTo2("julip", "kevin"));
        System.out.println(myValTree.is1ParentTo2("kalvin", "kb"));
        System.out.println(myValTree.is1ParentTo2("cat", "empire"));
        
        System.out.println();
        System.out.println("~CHECK RELATIONS~ (SHOULD RETURN ALL FALSE)");
        System.out.println(myValTree.is1ParentTo2("kevin", "julip"));
        System.out.println(myValTree.is1ParentTo2("apple", "cat"));
        System.out.println(myValTree.is1ParentTo2("cat", "jz"));
    }   
}
