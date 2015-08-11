/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueAndStack;

import java.util.Scanner;

/**
 *
 * @author swans_000
 */
public class TestIt {
    
    public static void main(String args[]) {
        
        System.out.println(reverseString());
        
        System.out.println(RPN("5 1 2 + 4 x + 3 -"));
        
        System.out.println(RPN("8 5 2 - 7 / - 3 +"));
        
        System.out.println(queueString());

    }
    
    // Use ArrayStack to print strings in reverse order
    public static String reverseString() {
        
        Scanner inpt = new Scanner(System.in);
        
        ArrayStack<String> stringStack = new ArrayStack<>();
        
        String result = "";
        String lineTxt;
        
        
        while (!(lineTxt = inpt.nextLine()).isEmpty()) {
            stringStack.push(lineTxt);
        }
        
        while (!stringStack.isEmpty()){
            result += stringStack.pop() + " ";
        }
        return result;
    }
    
    public static String queueString() {
        Scanner inpt = new Scanner(System.in);
        CircularArrayQueue<String> stringQueue = new CircularArrayQueue<>();
        
        String result = "";
        String lineTxt;
        
        while (!(lineTxt = inpt.nextLine()).isEmpty()) {
            stringQueue.queue(lineTxt);
        }
        
        // remove first 2
        stringQueue.dequeue();
        stringQueue.dequeue();

        stringQueue.queue("appear");
        stringQueue.queue("at");
        stringQueue.queue("the");
        stringQueue.queue("end");
        
        
        while (!stringQueue.isEmpty()){
            result += stringQueue.dequeue() + " ";
            //System.out.print(stringStack.pop() + " ");
        }
        return result;
        
    }
    
    public static String queuestack() {
        
        Scanner inpt = new Scanner(System.in);
        ArrayQueue<String> stringQueue = new ArrayQueue<>();
        ArrayStack<String> stringStack = new ArrayStack<>();
        
        String result = "";
        String lineTxt;
        
        while (!(lineTxt = inpt.nextLine()).isEmpty()) {
            stringQueue.queue(lineTxt);
        }
        
        while (!stringQueue.isEmpty()) {
            stringStack.push(stringQueue.dequeue());
        }
        
        while (!stringStack.isEmpty()){
            result += stringStack.pop() + " ";
            //System.out.print(stringStack.pop() + " ");
        }
        
        return result;
    }
    
    public static int RPN(String expression) {
        int result = 0;
        
        ArrayStack<Integer> stack = new ArrayStack();
        
        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);
            
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));

            } else {   
                    int val1;
                    int val2;
                switch (ch){
                    case '+': // Addition
                        stack.push(stack.pop() + stack.pop());
                        break;
                        
                    case 'X':
                    case 'x':
                    case '*': // Multiplication
                        stack.push(stack.pop() * stack.pop());
                        break;
                
                    case '-': // Subtraction
                        // order is significant, so pops must be assigned to temporary variables
                        val1 = stack.pop();
                        val2 = stack.pop();
                        stack.push(val2 - val1);
                            
                        break;
                        
                    case '/': // Division
                        val1 = stack.pop();
                        val2 = stack.pop();
                        stack.push(val2 / val1); 
                     
                    default: // Whitespace, letters, or other chars not handled are ignored
                        break;
                }
            }      
        }

        result = stack.pop();
        return result;
    }
    
}
