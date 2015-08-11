/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReverseString;

/**
 *
 * @author swans_000
 */
public class StringReverse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Run printReverse on each command line argument (string)
        for (String arg : args) {
            printReverse(arg);
        }
    }
    
    /**
     * print the previous character until
     * out of characters.
     * @param myString entire string to reverse
     * @param position current character location (as integer) in string
     */
    public static void printReverse(String myString, int position) {
        
        --position; // decrement
        
        if (position >= 0) {
            System.out.print(myString.charAt(position)); // print the character
            printReverse(myString, position); // Recursively call this function
        } else {
            // EXIT RECURSIVE LOOP
            System.out.println(); // print new line
        }
    }
    
    /**
     * Overload printNext to input the string length
     * @param myString 
     */
    public static void printReverse(String myString) {
        printReverse(myString, myString.length());
    }
    
}
