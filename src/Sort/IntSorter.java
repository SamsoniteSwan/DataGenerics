/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author swans_000
 */
public class IntSorter {
    
    public static void mergeSort(int[] arry) {
        
        int[] temp = new int[arry.length];
        

        mergeSort(arry, temp, 0, arry.length-1);
        }

    
    private static void mergeSort(int[] arry, int[] tmp) {
        
        int indexEndHalf1 = arry.length / 2;
        int ctIn1 = arry.length / 2;
        int ctIn2 = ctIn1;
        
        int indexStartHalf2;
        if ((arry.length % 2) == 1) {
            ctIn2++;
        }
        
        int[] firsthalf = new int[ctIn1];
        int[] secondhalf = new int[ctIn2];
        

    }
    private static <S extends Comparable<? super S>> void mergeSort(int[] unsorted, int[] temp, int first, int last) {
        
        if (unsorted[first] < unsorted[last]) {
            int mid;
            if (((last - first) % 2) == 1){
                mid = ((last - first) / 2) + 1;
            } else {
                mid = unsorted.length / 2;
            }
            
            mergeSort(unsorted, temp, first, mid);
            mergeSort(unsorted, temp, mid + 1, last);
            merge(unsorted, temp, first, mid, last);
        }

    }
    
    private static <S extends Comparable<? super S>> void merge(int[] unsorted, int[] temp, int first, int mid, int last) {
        
        int firststart = first;
        int firstend = mid;
        int secondstart = mid + 1;
        int secondend = last;
        int i = 0;
        while ((firststart <= firstend) && (secondstart <= secondend)) {
            //int tmp = unsorted[secondstart];
            if (unsorted[firststart] <= unsorted[secondstart]) {
                temp[i] = unsorted[firststart];
                firststart++;
            } else {
                temp[i] = unsorted[secondstart];
                secondstart++;
            }
            i++;
            
        }
        /**
        if (firststart > firstend) {
            while (secondstart <= secondend) {
                temp[i] = unsorted[secondstart];
                secondstart++;
                i++;
            }
        } else if (secondstart > secondend)
                while (firststart <= firstend) {
                temp[i] = unsorted[firststart];
                firststart++;
                i++;
            }*/
        for (i = 0; i < temp.length; i++) {
            unsorted[i] = temp[i];
        }
               
        
    }
    
    public static void selectionSort(int[] a) {
        selectionSort(a, a.length);
    }
    
   public static void selectionSort(int[] source, int size) {
        for (int i = 0; i < size - 1; i++) {
            int indexOfNextSmallest = getIndexOfSmallest(source, i, size-1);
            swap(source, i, indexOfNextSmallest);
        }
    }
    
    private static int getIndexOfSmallest(int[] a, int first, int last) {
        int min = a[first];
        int indexOfMin = first;
        for (int i = first + 1; i <= last; i++) {
            if (a[i] < min) {
                min = a[i];
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }
    
    private static void swap(int[] a, int i, int j) {
        //Object temp = a[i];
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void insertionSort(int[] arry, int first, int last) {
        if (arry[first] > arry[last]) {
            
        }
    }

    public static int[] quickSort(int[] arry) {
        int[] tmp = arry;
        
        quickSortem(tmp, 0, tmp.length - 1);
        return tmp;
    }
    
    /*private static void quickSorter(int[] arry) {
        
        quickSortem(arry, 0, arry.length - 1);
        
    }
    */
    private static void quickSortem(int[] arry, int bottomIndex, int topIndex) {
        int low = bottomIndex;
        int high = topIndex;
        
        int mid = arry[low + ((high-low)/2)];
        
        while (low <= high) {
            while(arry[low] < mid) {
                low++;
            }
            while(arry[high] > mid) {
                high--;
            }
            
            if (low <= high) {
                int tmp = arry[low];
                arry[low] = arry[high];
                arry[high] = tmp;
                low++;
                high--;
            }
        }
        
        if (bottomIndex < high) {
            quickSortem(arry, bottomIndex, high);
        }
        
        if (topIndex > low) {
            quickSortem(arry, low, topIndex);
        }

    }
    
    // RADIX
    public static int[] radixSort(int[] arry, int aSize, int exp) {
        
        int unboxedCt = arry.length;
        int[] unboxed = new int[unboxedCt];
        int[] boxed = new int[unboxed.length];
        
        int modten = (int)Math.pow(10, exp);
        
        int j = 0;
        for (int i = 0; i < unboxed.length; i++) {
            
            if (arry[i] % modten == unboxed[i]) {
                boxed[j] = arry[i];
                j++;
                unboxedCt--;
            } else {
                
            }
                
        }
        
        //if 
        
        return boxed;
        /*
        for (int shft = Integer.SIZE - 1; shft > -1; shft--) {
            int[] box = new int[arry.length];
            
        }
                */
    }
    
}
