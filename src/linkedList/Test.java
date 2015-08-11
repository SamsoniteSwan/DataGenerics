/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedList;

import Utils.RandomGenerator;
import java.util.ArrayList;

/**
 *
 * @author swans_000
 */
public class Test {
    
    public static int RANDOM_INT_COUNT = 20; // number of random integers to use
    public static int RANDOM_STRING_COUNT = 20; // number of random Strings to use
    
    public static int CHANCE = 3; // chance a value will be added to array list(i.e. 1 in X). Higher is less likely
    
    public static void main(String[] args) {
        
        DblLinkedList<Boolean, String> bolList = new DblLinkedList();
        DblLinkedList<String, String> strList = new DblLinkedList();
        DblLinkedList<Integer, String> intList = new DblLinkedList();
        
        // use ArrayLists only for holding values to test
        ArrayList<String> getValueStrings = new ArrayList<>();
        ArrayList<String> checkRemoveStrings = new ArrayList<>();
        ArrayList<Integer> getValueInts = new ArrayList<>();
        ArrayList<Integer> checkRemoveInts = new ArrayList<>();
        
        int i;
        int sum;

        // BOOLEAN TEST
        bolList.add(true, "this is true");
        bolList.add(false, "this is false");
        bolList.printindex();
        System.out.println();
        System.out.println(bolList.printall());

        // STRINGS TEST
         sum = 0;
        i = RANDOM_STRING_COUNT;
        
        while ( i > 0) {
            // generate random string
            String key = RandomGenerator.randStringVarSize(2, 7);
        
            strList.add(key, key + " is value of " + key);
            
            int ri = RandomGenerator.randInt(1, CHANCE);
            if (ri == 1) {
                //Add to list of values to check for
                getValueStrings.add(key);
            } else if (ri == CHANCE) {
                //Add to list of values to remove
                checkRemoveStrings.add(key);
            }
            
            i--;
        }
        // print values and indexes
        System.out.println(strList.printall());
        strList.printindex();        
        
        for(String key : getValueStrings) {
            System.out.println("Value of " + key + " is " + strList.getValue(key) + "; ");
        }
        
        for(String key : checkRemoveStrings) {
            strList.remove(key);
        }
        System.out.println();
        System.out.println("AFTER REMOVAL: " + strList.printall());
        /*
        strList.add("bbb", "This is B");
        strList.add("ccc", "This is C");
        strList.printindex();
        
        
        strList.add("ddd", "This is D");
        strList.add("aaa", "This is a");



        strList.add("xxx", "here is x");
        strList.add("ppp", "This is p");
        strList.add("hhh", "This is h");
        System.out.println("Removing ppp.  Value was " +strList.remove("ppp"));
        
        strList.add("ggg", "This is g");
        strList.add("hhh", "This is h2");
        strList.add("eee", "This is e");
        strList.add("ab", "this is sb");
        
        strList.printindex();
        System.out.println("this is the value of hhh:" + strList.getValue("hhh"));
        System.out.println("this is the value of NOTHING:" + strList.getValue("tretr"));
        */
        
        //Iterator<String> listIterator = strList.iterator();
        //listIterator.restart();
        
        //while(listIterator.hasNext() == true){
        //    System.out.println("Iterator: " + listIterator.next());
        //}
        //intList.printindex();
        //System.out.println(intList.printall());

        sum = 0;
        i = RANDOM_INT_COUNT;
        while ( i > 0) {
            int key = RandomGenerator.randInt(0, 1000);
        
            intList.add(key, key + " is value of " + key);
            i--;
            
            int ri = RandomGenerator.randInt(1, CHANCE);
            if (ri == 1) {
                //Add to list of values to check for
                getValueInts.add(key);
            } else if (ri == CHANCE) {
                //Add to list of values to remove
                checkRemoveInts.add(key);
            }
        }        
        /*
        intList.add(50, "this is 50");
        intList.add(60, "this is 60");
        intList.add(40, "this is 40");
        intList.add(30, "this is 30");
        intList.add(20, "this is 20");
        intList.add(3, "this is 3");
        intList.add(12, "this is 12");
        intList.add(90, "this is 90");
        intList.add(24, "this is 24");
        intList.add(110, "this is 110");*/
        intList.printindex();
        System.out.println(intList.printall());
        
        for(int key : getValueInts) {
            System.out.println("Value of " + key + " is " + intList.getValue(key) + "; ");
        }
        // remove ints in arraylist
        for(int key : checkRemoveInts) {
            intList.remove(key);
        }
        System.out.println();
        System.out.println("AFTER REMOVAL: " + intList.printall());
        

        /*
        Iterator<Integer> intListIterator = intList.iterator();
        while(intListIterator.hasNext()) {
            System.out.println("Iterator: " + intListIterator.next());
        }*/
        
        //DblLinkedList<String, String> strList2 = new DblLinkedList();

        
        /*
        Iterator<String> listIterator2 = strList2.iterator();
        while (listIterator2.hasNext() == true){
            sum++;
            System.out.print("Iterator: " + listIterator2.next());
            
            System.out.println("   Sum: " + sum);
        }
        
        //System.out.println("removing " + strList2.remove());
        
        Iterator<String> listIterator3 = strList2.iterator();
        sum = 0;
        while (listIterator3.hasNext() == true){
            sum++;
            System.out.print("Iterator: " + listIterator3.next());
            
            System.out.println("   Sum: " + sum);
        }*/
        
        //strList.printAll();
        //System.out.println("ALL LIST: " + strList.printAll());
        //strList.print123();
    }
    
}
