/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import java.util.Random;
import java.lang.reflect.Method;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author swans_000
 */
public class TestSort {
    
    public static final int ARRAY_SIZE = 5000;
    
    public static void main(String args[]) throws InstantiationException, IllegalAccessException {
        

        
        int random[] = createIntArray(ARRAY_SIZE);
        
        long timeTaken;
    
        // for generics
        Integer randomI[] = new Integer[random.length];
        Integer sortedDesI[] = new Integer[random.length];
        
        Integer randomI2[] = new Integer[random.length];
        for (int i = 0; i < random.length; i++) {
            randomI[i] = random[i];
            sortedDesI[i] = random[i];
            
            randomI2[i] = random[i];
        }
        
        
        
        Integer sortedAscI[] = GenericSorter.quickSort(randomI);
        // Make reverse order
        int j = sortedAscI.length-1;        
        for (int i = 0; i < sortedAscI.length; i++) {
            sortedDesI[i] = sortedAscI[j--];
        }        
        
        // Header line
        System.out.println("ALGORITHM\tRANDOM\tSORTED\tREVERSE SORT");
        // QUICK SORT
        System.out.print("QuickSort:\t");
        Integer qSort[];
        timeTaken = System.currentTimeMillis();
        qSort = GenericSorter.quickSort(randomI);
        timeTaken = System.currentTimeMillis() - timeTaken;
        System.out.print((float)timeTaken/1000 + "\t");
        
        /*
        System.out.println();
         System.out.print("UNSORTED:");
        for (int i = 0; i < randomI.length; i++) {
            System.out.print(randomI[i] + " ");
        }
        System.out.println();
        */
        /*
        System.out.println();
                System.out.print("QSORT sorted:");
        for (int i = 0; i < qSort.length; i++) {
            System.out.print(qSort[i] + " ");
        }
        System.out.println();
        */
        
        timeTaken = System.currentTimeMillis();
        qSort = GenericSorter.quickSort(sortedAscI);
        timeTaken = System.currentTimeMillis() - timeTaken;
        System.out.print((float)timeTaken/1000 + "\t");
        
        timeTaken = System.currentTimeMillis();
        qSort = GenericSorter.quickSort(sortedDesI);
        timeTaken = System.currentTimeMillis() - timeTaken;
        System.out.print((float)timeTaken/1000 + "\t");
        System.out.println();
        /*
        System.out.println();
        System.out.print("mod:" + modulator());
        */
        
        // MERGE SORT
        System.out.print("MergeSort:\t");
        Integer mSort[];
        timeTaken = System.currentTimeMillis();
        mSort = GenericSorter.mergeSort(randomI2);
        timeTaken = System.currentTimeMillis() - timeTaken;
        System.out.print((float)timeTaken/1000 + "\t");
        
        /*
        System.out.println();
        System.out.print("randomI2 Unsorted:");
        for (int i = 0; i < randomI2.length; i++) {
            System.out.print(randomI2[i] + " ");
        }
        System.out.println();
        */

        //GenericSorter.printline("mergeSort", randomI);
        
        timeTaken = System.currentTimeMillis();
        mSort = GenericSorter.mergeSort(sortedAscI);
        timeTaken = System.currentTimeMillis() - timeTaken;
        System.out.print((float)timeTaken/1000 + "\t");
        
        timeTaken = System.currentTimeMillis();
        mSort = GenericSorter.mergeSort(sortedDesI);
        timeTaken = System.currentTimeMillis() - timeTaken;
        System.out.print((float)timeTaken/1000 + "\t");
        /*
        System.out.print("Reversed:");
        for (int i = 0; i < sortedDesI.length; i++) {
            System.out.print(sortedDesI[i] + " ");
        }
        System.out.println();
        */
        
        /**Scanner inpt = new Scanner(System.in);
        while (!(inpt.nextLine()).isEmpty()){
            
        }*/
        
        //timeTaken = System.currentTimeMillis() - timeTaken;
        
        //System.out.println("Time taken:" + (float)timeTaken/1000);
        

        /*
        System.out.print("sorted:");
        for (int i = 0; i < sortedAscI.length; i++) {
            System.out.print(sortedAscI[i] + " ");
        }*/

    }
    
    // Create an array of random int values, 0 - size specified
    public static int[] createIntArray(int size) {
        
        int temp[] = new int[size];
        Random rndm = new Random();
        for (int i = 0; i < size; i++) {
        //for (int i : temp) {
            
            temp[i] = rndm.nextInt(size);

        }
        
        return temp;
        
    }
    
    public static int modulator(){
        int result;
        
        result = 151 % 1000;
        
        return result;
    }
    
    /*
    private static void printline(String methodName, Integer[] sourceArray) throws InstantiationException, IllegalAccessException{
           
        long timeTaken;
        
        Class GenSortClass = GenericSorter.class;
        try {
        Method method = GenSortClass.getDeclaredMethod(methodName, new Class[] {Integer[].class});//.getMethod(methodName, Integer[].class);
        
        timeTaken = System.currentTimeMillis();
        Object inst = GenSortClass.newInstance();
        Object Array = method.invoke(inst, (Object[])sourceArray);
                //method.invoke(null, sourceArray);
        timeTaken = System.currentTimeMillis() - timeTaken;
        System.out.print((float)timeTaken/1000 + "\t");
        }catch(NoSuchMethodException e) {
            System.err.println("NoSuchMethod Error: " + e.getMessage());
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(TestSort.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(TestSort.class.getName()).log(Level.SEVERE, null, ex);
        }  
        

    }
    */
    
}
