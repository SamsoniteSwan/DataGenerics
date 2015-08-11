/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkipList;

import Sort.GenericSorter;
import Utils.RandomGenerator;

/**
 *
 * @author swans_000
 */
public class Test {

    public static final int LIST_SIZE = 35;  // Number of values for the list  
    public static final int TRUE_CT = 8;       // Number of occurring values to test
    public static final int FALSE_CT = 8;      // Number of 'false' values to create
    
    public static void main(String[] args) {

        // Initialize empty arrays
        String[] unsorted = new String[LIST_SIZE];
        String[] sorted = new String[LIST_SIZE];
        String[] shouldFindVals = new String[TRUE_CT];
        // noFindValues are known to not occur, because they either use
        //  all caps or are longer than the randomly generated. 
        String[] noFindVals = new String[FALSE_CT];
        
        // create randomly generated Strings for the list...
        for (int i = 0; i < unsorted.length; i++) {
            
            unsorted[i] = RandomGenerator.randStringVarSize(2, 10);
            // take the first TRUE_CT of randomly generated values
            // and add them to the test array before they get sorted.
            if (i < TRUE_CT){
                shouldFindVals[i] = unsorted[i];
            }
        }
        
        // Sort the array
        sorted = GenericSorter.quickSort(unsorted);
        
        // create randomly generated strings for testing that are
        // to large to exist in the list.
        for (int i = 0; i < noFindVals.length; i++) {
            noFindVals[i] = RandomGenerator.randStringFixedSize(12);
        }
        
        SkipList skipper = new SkipList(sorted);
        
        skipper.printall();

        // test all the values that should be found
        System.out.println();
        System.out.println("~SHOULD RETURN ALL TRUE~");
        for (String find : shouldFindVals) {
            System.out.print("check " + find + ": ");
            System.out.println(skipper.contains(find));            
        }

        // test ALLCAPS values that should NOT be found
        System.out.println();
        System.out.println("~SHOULD RETURN ALL FALSE~");
        for (String find : noFindVals) {
            System.out.print("check " + find + ": ");
            System.out.println(skipper.contains(find));            
        }
        //skipper.getLowestSub().printall();
    }
    
}
