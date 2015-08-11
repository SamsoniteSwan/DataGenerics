/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author swans_000
 */
public class GenericSorter<S> {
      

    // SELECTION SORT
    public static <S extends Comparable<? super S>> void selectionSort(S[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int indexOfNextSmallest = getIndexOfSmallest(a, i, n-1);
            swap(a, i, indexOfNextSmallest);
        }
    }
    
    private static <S extends Comparable<? super S>> int getIndexOfSmallest(S[] a, int first, int last) {
        S min = a[first];
        int indexOfMin = first;
        for (int i = first + 1; i <= last; i++) {
            if (a[i].compareTo(min) < 0) {
                min = a[i];
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }
    
    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    
    public static <S extends Comparable<? super S>> S[] pivotSort(S[] sourceArray) {
        

        sortFirstMiddleLast(sourceArray, 0, sourceArray.length/2, sourceArray.length);
        
        return sourceArray;
    }
    
    private static <S extends Comparable<? super S>> void sortFirstMiddleLast(S[] array, int first, int mid, int last) {
        
        if (array[first].compareTo(array[mid]) > 0) {
            S temp = array[first];
            array[first] = array[mid];
            array[mid] = temp;
        }
        
        if (array[first].compareTo(array[last]) > 0) {
            S temp = array[first];
            array[first] = array[last];
            array[last] = temp;
        }
        
        if (array[mid].compareTo(array[last]) > 0) {
            S temp = array[mid];
            array[mid] = array[last];
            array[last] = temp;
        }
    }
    
    // QUICK SORT
    // WORKING
    public static <S extends Comparable<? super S>> S[] quickSort(S[] arry) {
        S[] tmp = arry.clone();
        
        quickSorter(tmp);
        return tmp;
    }
    
    
    private static <S extends Comparable<? super S>> void quickSorter(S[] arry) {
        
        quickSorter(arry, 0, arry.length - 1);
        
    }
    private static <S extends Comparable<? super S>> void quickSorter(S[] arry, int bottomIndex, int topIndex) {
        int low = bottomIndex;
        int high = topIndex;
        
        // get middle object to pivot
        S mid = arry[low + ((high-low)/2)];
        
        while (low <= high) {
            while(arry[low].compareTo(mid) < 0) {
                low++;
            }
            while(arry[high].compareTo(mid) > 0) {
                high--;
            }
            
            if (low <= high) {
                swap(arry, low, high); // switch values with the swap method
                low++;
                high--;
            }
        }
        // if not at the lowerbound, recursive call
        if (bottomIndex < high) {
            quickSorter(arry, bottomIndex, high);
        }
        // if not at the upperbound, recursive call
        if (topIndex > low) {
            quickSorter(arry, low, topIndex);
        }

    }
   
    // MERGE SORT
    public static <S extends Comparable<? super S>> S[] mergeSort(S[] source) {
        S[] result = source.clone();
        S[] temp = (S[])new Comparable<?>[source.length];
        mergeSort(result, temp, 0, source.length-1);
        return result;
    }
    
    private static <S extends Comparable<? super S>> void mergeSort(S[] array, S[] temp, int low, int high) {

        if (low < high) {
            int mid = low + ((high - low) / 2);
            
            mergeSort(array, temp, low, mid); // sort first half
            mergeSort(array, temp, mid + 1, high); // sort second half
            merge(array, temp, low, mid, high); // combine
        }
    }
    
    private static <S extends Comparable<? super S>> void merge(S[] array, S[] temp, int low, int mid, int high) {
        
        
        for (int i = low; i <= high; i++) {
            temp[i] = array[i];
        }
        
        int l = low;
        int l2 = low; // lower int needs to be saved in 2 different instances for iterating
        int m = mid + 1;
        
        //copy smallest values back into original array.
        while (l <= mid && m <= high) {

            if (temp[l].compareTo(temp[m]) <= 0) {
                array[l2] = temp[l];
                l++;
            }else {
                array[l2] = temp[m];
                m++;
            }
            l2++;
        }
        
        // copy remaining values back into original array.
        while (l <= mid) {
            array[l2] = temp[l];
            l2++;
            l++;
        }
    }
        public static <S extends Comparable<? super S>> void printline(String methodName, S[] sourceArray) throws InstantiationException, IllegalAccessException{
           
        long timeTaken;
        
        Class GenSortClass = GenericSorter.class;
        // attempt REFLECTION
        try {
        Method method = GenSortClass.getDeclaredMethod(methodName, new Class[] {sourceArray.getClass()});//.getMethod(methodName, Integer[].class);
        
        timeTaken = System.currentTimeMillis();
        Object inst = GenSortClass.newInstance();
        Object Array = method.invoke(inst, (Object)sourceArray.clone());
        //Array.
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
}
